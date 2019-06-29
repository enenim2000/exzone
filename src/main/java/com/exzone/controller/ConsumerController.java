package com.exzone.controller;

import com.exzone.annotation.Get;
import com.exzone.annotation.Permission;
import com.exzone.annotation.Post;
import com.exzone.annotation.Role;
import com.exzone.constant.RoleConstant;
import com.exzone.constant.RouteConstant;
import com.exzone.dto.request.ConsumerRequest;
import com.exzone.dto.response.ModelResponse;
import com.exzone.dto.response.PageResponse;
import com.exzone.dto.response.Response;
import com.exzone.enums.UserType;
import com.exzone.exception.AppException;
import com.exzone.model.dao.Consumer;
import com.exzone.model.dao.Login;
import com.exzone.service.dao.ConsumerService;
import com.exzone.service.dao.LoginService;
import com.exzone.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    private final ConsumerService consumerService;
    private final PasswordEncoder passwordEncoder;
    private final LoginService loginService;

    @Autowired
    public ConsumerController(ConsumerService consumerService, PasswordEncoder passwordEncoder, LoginService loginService) {
        this.consumerService = consumerService;
        this.passwordEncoder = passwordEncoder;
        this.loginService = loginService;
    }

    @Get
    @Role({RoleConstant.STAFF})
    @Permission(RouteConstant.USER_CONSUMER_INDEX)
    public Response<PageResponse<Consumer>> getConsumers() {
        return new Response<>(new PageResponse<>(consumerService.getConsumers()));
    }

    @Get("/{id}")
    @Role({RoleConstant.CONSUMER, RoleConstant.STAFF})
    @Permission(RouteConstant.USER_CONSUMER_SHOW)
    public Response<ModelResponse<Consumer>> showConsumer(@PathVariable Long id) {
        return new Response<>(new ModelResponse<>(consumerService.getConsumer(id)));
    }

    @Post("/sign-up")
    public Response<ModelResponse<Consumer>> signUpConsumers(@Valid @RequestBody ConsumerRequest request){

        if(!request.getPassword().equals(request.getConfirmPassword())){
            throw new AppException("password mismatch");
        }

        Consumer consumer = request.buildModel();
        consumer.skipAuthorization(true);
        consumer = consumerService.saveConsumer(consumer);

        if(!StringUtils.isEmpty(consumer)){

            Login login = new Login();
            login.setUsername(consumer.getEmail());
            login.setUserType(UserType.CONSUMER);
            login.setUserId(consumer.getId());
            login.setPassword(passwordEncoder.encode(request.getPassword()));
            login = loginService.saveLogin(login);

            if(!StringUtils.isEmpty(login.getId())){
                mailSenderService.send(consumer);
            }

            ModelResponse<Consumer> response = new ModelResponse<>(consumer);
            response.setMessage("consumer sign-up success");

            return new Response<>(new ModelResponse<>(consumer));
        }

        throw new AppException("sign-up failed");
    }

}

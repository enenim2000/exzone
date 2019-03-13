package com.exzone.controller;

import com.exzone.dto.request.Request;
import com.exzone.dto.request.StaffRequest;
import com.exzone.dto.response.ModelResponse;
import com.exzone.dto.response.Response;
import com.exzone.model.dao.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TestController {

    @PostMapping("/users")
    public Response<ModelResponse<Staff>> createUser(@RequestBody Request<StaffRequest> request){

        Staff staff = new Staff();

        staff.setEmail("enenim2000@gmail.com");
        staff.setEmployeeId("1101");

        return new Response<>(new ModelResponse<>(staff));
    }
}

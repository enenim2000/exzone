package com.exzone.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ErrorValidator {

    private final Environment env;

    @Autowired
    public ErrorValidator(Environment env) {
        this.env = env;
    }

    public Map<String, List<Map<String, String>>> errors (MethodArgumentNotValidException ex){
        Map<String, List<Map<String, String>>> errors = new HashMap<>();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String messagePropertyKey = fieldError.getDefaultMessage();
            if(!StringUtils.isEmpty(messagePropertyKey) && messagePropertyKey.contains("{")){
                String messageKey = messagePropertyKey.replace("{", "").replace("}", "");
                String[] array = messageKey.split("\\.");
                String rule = array[2];
                String fieldName = array[1];
                if(StringUtils.isEmpty(errors.get(fieldName))){
                    errors.put(fieldName, new ArrayList<>());
                }
                errors.get(fieldName).add(
                    new HashMap<String, String>(){{put("rule", rule); put("message", env.getProperty(messageKey));}}
                );
            }
        }
        return errors.keySet().isEmpty() ? null : errors;
    }
}
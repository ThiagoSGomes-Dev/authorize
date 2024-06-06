package com.example.authorize.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class AuthorizeController {
    private static int trueCount = 0;
    @GetMapping("authorize")
    public Response authorizeVerify() {
        boolean authorization = trueCount % 11 != 10;
        if(trueCount >= 10) {
            trueCount = 0;
        } else {
            trueCount++;
        }
        var response = new Response("success", new Data(authorization));
        return response;
    }
    record Response(String status, Data data) {}
    record Data(Boolean authorization) {}
}

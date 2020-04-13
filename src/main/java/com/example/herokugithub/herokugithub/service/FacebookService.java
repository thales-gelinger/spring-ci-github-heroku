package com.example.herokugithub.herokugithub.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface FacebookService {
    String generateFacebookAuthorizeUrl();

    void generateFacebookAccesToken(@RequestParam("code") String code);

    String getUserData();
}

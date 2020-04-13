package com.example.herokugithub.herokugithub.controllers;

import com.example.herokugithub.herokugithub.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping
public class FacebookController {

    @Autowired
    private FacebookService facebookService;

    @GetMapping("/generateFacebookAuthorizeUrl")
    public String generateFacebookAuthorizeUrl(){
        return facebookService.generateFacebookAuthorizeUrl();
    }

    @GetMapping("/facebook")
    public void generateFacebookAccesToken(@RequestParam("code") String code) {
        facebookService.generateFacebookAccesToken(code);
    }

    @GetMapping("/getUserData")
    public String getUserData() {
        return facebookService.getUserData();
    }

    @GetMapping
    public List<String> getfacebookFeeds() {
        List<String> urls = new ArrayList<String>();
        urls.add("http://localhost:8100/generateFacebookAuthorizeUrl");
        urls.add("http://localhost:8100/getUserData");
        return urls;
    }

}

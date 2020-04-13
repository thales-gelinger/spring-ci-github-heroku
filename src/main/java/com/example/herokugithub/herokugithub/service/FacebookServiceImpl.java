package com.example.herokugithub.herokugithub.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookServiceImpl implements FacebookService{

    private String accesToken;

    @Value("${spring.social.facebook.app-id}")
    private String facebookAppId;

    @Value("${spring.social.facebook.app-secret}")
    private String facebookAppSecret;

    private FacebookConnectionFactory createConnection() {
        return new FacebookConnectionFactory(facebookAppId, facebookAppSecret);
    }

    @Override
    public String generateFacebookAuthorizeUrl() {
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8100/facebook");
        params.setScope("email");
        return createConnection().getOAuthOperations().buildAuthenticateUrl(params);
    }

    @Override
    public void generateFacebookAccesToken(String code) {
        accesToken = createConnection()
                .getOAuthOperations()
                .exchangeForAccess(code,"http://localhost:8100/facebook", null )
                .getAccessToken();
    }

    @Override
    public String getUserData() {
        Facebook facebook = new FacebookTemplate(accesToken);
        String[] fields = {"id", "first_name", "name", "email","profile_pic"};
        return facebook.fetchObject("me", String.class, fields);
    }
}

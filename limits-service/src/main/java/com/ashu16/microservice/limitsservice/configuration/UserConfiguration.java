package com.ashu16.microservice.limitsservice.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// ConfigurationProperties annotation is used to read teh data from .properties file
@ConfigurationProperties("user-details")
@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class UserConfiguration {

    private String username;
    private String pw;

   /* public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public UserConfiguration(String username, String pw) {
        this.username = username;
        this.pw = pw;
    }

    public UserConfiguration() {
    }*/
}

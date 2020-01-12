package com.example.tema3.tema3.Util;


import javax.validation.constraints.NotEmpty;

public class UserRegistrationDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    //@NotEmpty
   // private String confirmPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.user;

import com.user.Annotations.NotBlank;
import com.user.Annotations.Positive;

public class User {
    
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Positive
    private int pin;

    public void setUsername(String s){
        this.username=s;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String s){
        this.password=s;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPin(int p){
        this.pin=p;
    }

    public int getPin(){
        return this.pin;
    }
}

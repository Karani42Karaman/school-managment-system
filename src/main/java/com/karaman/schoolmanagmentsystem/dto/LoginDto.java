package com.karaman.schoolmanagmentsystem.dto;

import org.springframework.web.bind.annotation.ModelAttribute;

public class LoginDto {
    private String tcNo;
    private String password;
    private String role;

    public LoginDto( String tcNo, String password, String role) {

        this.tcNo = tcNo;
        this.password = password;
        this.role = role;
    }

    public String getTcNo(){
        return tcNo;
    }
    public void setTcNo(String tcNo){
        this.tcNo=tcNo;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }

}







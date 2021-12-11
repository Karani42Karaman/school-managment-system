package com.karaman.schoolmanagmentsystem.dto;

import org.springframework.web.bind.annotation.ModelAttribute;

public class LoginDto {
    private Long tcNo;
    private String password;
    private String role;

    public LoginDto( Long tcNo, String password, String role) {

        this.tcNo = tcNo;
        this.password = password;
        this.role = role;
    }

    public Long getTcNo(){
        return tcNo;
    }
    public void setTcNo(Long tcNo){
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







package com.example.project.model.binding;


import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class UserRegisterBindingModel {
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
    private Integer age;
    private String username;
    private String telephoneNum;
    @NotNull
    @Size(min = 4)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
@NotNull
@NotBlank
@Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @NotNull
    @Size(min = 4)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @Size(min = 4)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    @Positive
    @NotNull
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Size(min =4)
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull
    @Size(min = 6, max = 10)
    @Pattern(regexp="[\\d]+")
    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }
}
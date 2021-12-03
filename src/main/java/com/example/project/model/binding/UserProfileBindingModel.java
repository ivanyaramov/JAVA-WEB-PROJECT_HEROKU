package com.example.project.model.binding;

import javax.validation.constraints.*;

public class UserProfileBindingModel {
    private String fullName;
    private String email;
    private Integer age;
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
    @Positive
    @NotNull
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @NotNull
    @Size(min = 6, max = 11)
    @Pattern(regexp="[\\d]+")
    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }
}

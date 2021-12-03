package com.example.project.model.binding;

import com.example.project.model.entity.UserRoleEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoleBindingModel {
    UserRoleEnum userRoleEnum;
@NotNull
    public UserRoleEnum getUserRoleEnum() {
        return userRoleEnum;
    }

    public void setUserRoleEnum(UserRoleEnum userRoleEnum) {
        this.userRoleEnum = userRoleEnum;
    }
}

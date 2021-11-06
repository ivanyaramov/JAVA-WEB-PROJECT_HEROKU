package com.example.project.service;

import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;

public interface UserRoleService {
    UserRoleEntity findByRole(UserRoleEnum userRoleEnum);
}

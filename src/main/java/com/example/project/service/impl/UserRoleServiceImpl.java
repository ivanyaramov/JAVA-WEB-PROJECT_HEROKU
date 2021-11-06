package com.example.project.service.impl;

import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.repository.UserRoleRepository;
import com.example.project.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleEntity findByRole(UserRoleEnum userRoleEnum) {
        return userRoleRepository.findByRole(userRoleEnum);
    }
}

package com.example.project.service.impl;

import com.example.project.model.entity.UserEntity;
import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.model.service.UserRegisterServiceModel;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserRoleService;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRoleService userRoleService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProjectUserServiceImpl projectUserService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRoleService userRoleService, UserRepository userRepository, PasswordEncoder passwordEncoder, ProjectUserServiceImpl projectUserService, ModelMapper modelMapper) {
        this.userRoleService = userRoleService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.projectUserService = projectUserService;
        this.modelMapper = modelMapper;
    }


    public boolean isUserNameFree(String username) {
        return userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    @Override
    public void registerAndLoginUser(UserRegisterServiceModel userRegistrationServiceModel) {

        UserRoleEntity userRole = userRoleService.findByRole(UserRoleEnum.USER);
        Set<UserRoleEntity> set = Set.of(userRole);

        UserEntity newUser = modelMapper.map(userRegistrationServiceModel, UserEntity.class);

//        newUser.setUsername(userRegistrationServiceModel.getUsername());
//        newUser.setFullName(userRegistrationServiceModel.getFullName());
            newUser.setActive(true);
                newUser.setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()));
               newUser.setRoles(Set.of(userRole));

        newUser = userRepository.save(newUser);

        // this is the Spring representation of a user
        UserDetails principal = projectUserService.loadUserByUsername(newUser.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);
    }
}

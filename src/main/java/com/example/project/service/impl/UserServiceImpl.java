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

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public boolean isEmailFree(String email) {
        return  userRepository.getByEmail(email).isEmpty();
    }

    @Override
    public void initaliseUsers() {
        if(userRepository.count()==0) {
            UserRoleEntity user = userRoleService.findByRole(UserRoleEnum.USER);
            UserRoleEntity mod = userRoleService.findByRole(UserRoleEnum.MODERATOR);
            UserRoleEntity admin = userRoleService.findByRole(UserRoleEnum.ADMIN);
            UserEntity gosho = new UserEntity();
            gosho.setFullName("Ivan Yaramov");
            gosho.setPassword(passwordEncoder.encode("12345"));
            gosho.setUsername("gosho");
            gosho.setAge(20);
            gosho.setEmail("absbs@gmail.com");
            gosho.setTelephoneNum("08987874568");
            gosho.setRoles(Set.of(user));
            UserEntity moderator = new UserEntity();
            moderator.setFullName("Moderator Moderatorov");
            moderator.setPassword(passwordEncoder.encode("12345"));
            moderator.setUsername("moder");
            moderator.setAge(21);
            moderator.setEmail("abs34bs@gmail.com");
            moderator.setTelephoneNum("08947874568");
            moderator.setRoles(Set.of(user, mod));
            UserEntity adminentity = new UserEntity();
            adminentity.setFullName("Admin Adminov");
            adminentity.setPassword(passwordEncoder.encode("12345"));
            adminentity.setUsername("admin");
            adminentity.setAge(22);
            adminentity.setEmail("abs52534bs@gmail.com");
            adminentity.setTelephoneNum("08947814568");
            adminentity.setRoles(Set.of(user, mod, admin));
            userRepository.save(gosho);
            userRepository.save(moderator);
            userRepository.save(adminentity);
        }
    }
}

package com.example.project.service.impl;

import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.model.view.StatsView;
import com.example.project.service.StatsService;
import com.example.project.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements StatsService {

    private final UserService userService;

    private int anonymousRequests, authRequests, adminRequests, userRequests, moderRequests;

    public StatsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onRequest() {
        UserRoleEntity admin = new UserRoleEntity();
        admin.setRole(UserRoleEnum.ADMIN);
        UserRoleEntity moder = new UserRoleEntity();
        admin.setRole(UserRoleEnum.MODERATOR);
        UserRoleEntity user = new UserRoleEntity();
        admin.setRole(UserRoleEnum.USER);

        Authentication authentication = SecurityContextHolder.
                getContext().
                getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken) && authentication!=null) {
            String currentUserName = authentication.getName();
            if(userService.findByUsername(currentUserName).getRoles().contains(admin)){
                adminRequests++;
            }
            if(userService.findByUsername(currentUserName).getRoles().contains(moder)){
                moderRequests++;
            }
            if(userService.findByUsername(currentUserName).getRoles().contains(user)){
                userRequests++;
            }
        }


        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            authRequests++;
        } else {
            anonymousRequests++;
        }
    }

    @Override
    public StatsView getStats() {
        return new StatsView(authRequests, anonymousRequests, userRequests, moderRequests, adminRequests);
    }
}

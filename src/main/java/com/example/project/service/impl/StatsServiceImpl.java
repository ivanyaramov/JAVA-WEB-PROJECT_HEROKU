package com.example.project.service.impl;

import com.example.project.model.entity.UserRoleEntity;
import com.example.project.model.entity.UserRoleEnum;
import com.example.project.model.view.StatsView;
import com.example.project.service.StatsService;
import com.example.project.service.UserRoleService;
import com.example.project.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Set;

@Service
public class StatsServiceImpl implements StatsService {

    private int anonymousRequests, authRequests;

    @Override
    public void onRequest() {
        Authentication authentication = SecurityContextHolder.
                getContext().
                getAuthentication();



        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            System.out.println(authentication.getDetails());
            authRequests++;
        } else {
            anonymousRequests++;
        }
    }

    @Override
    public StatsView getStats() {
        return new StatsView(authRequests, anonymousRequests);
    }
}

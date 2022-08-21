package com.example.book.seller.security;

import com.example.book.seller.model.User;
import com.example.book.seller.service.IUserService;
import com.example.book.seller.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}

package com.mypro.ssm.security;

import com.mypro.ssm.po.User;
import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(username);
        List<User> users = userService.find(user);
        if (users.size() > 0) {
            User thisUser = users.get(0);
            List<GrantedAuthority> gas = new ArrayList<>();
            User userRoles = userService.findUserRoles(thisUser.getId());
            for (Role r : userRoles.getRoles()) {
                SimpleGrantedAuthority ga = new SimpleGrantedAuthority(r.getRoleName());
                gas.add(ga);
            }
            return new org.springframework.security.core.userdetails.User(thisUser.getUsername(), "{noop}"+thisUser.getPassword(), gas);
        }
        return null;
    }
}

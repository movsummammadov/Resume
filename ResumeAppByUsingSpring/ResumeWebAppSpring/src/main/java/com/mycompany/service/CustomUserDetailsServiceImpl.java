package com.mycompany.service;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user=userRepo.findByEmail(email);
        UserBuilder builder=null;
        if(user!=null){
            builder=org.springframework.security.core.userdetails.User.withUsername(email);
            builder.disabled(false);
            builder.password(user.getPassword());

            String[] autoritiesArr=new String[]{"USER","ADMIN"};
            builder.authorities(autoritiesArr);
        }else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}

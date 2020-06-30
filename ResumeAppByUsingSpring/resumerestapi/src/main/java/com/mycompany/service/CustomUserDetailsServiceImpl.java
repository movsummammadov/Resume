package com.mycompany.service;


import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepo.findByEmail(email);
        if(user!=null){
            UserBuilder builder= org.springframework.security.core.userdetails.User.withUsername(email);
            builder.disabled(false);
            builder.password(user.getPassword());

            String[] authoritieArr=new String[]{"ADMIN", "USER", "ROLE_USER"};
            builder.authorities(authoritieArr);

            return builder.build();
        }else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}

package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao dao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User myUser= dao.findByEmail(userName);
        System.out.println(myUser.toString());
        UserDetails user = org.springframework.security.core.userdetails.User.builder()
                .username(myUser.getEmail())
                .password("{noop}"+myUser.getPassword())
                .roles(myUser.getRole())
                .build();
        return user;
    }
}
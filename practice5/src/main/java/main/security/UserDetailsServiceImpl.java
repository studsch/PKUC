package main.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

//    private final

    // TODO: сделать работу с юзерами и сделать регистрацию
    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {
//        User user =
        return null;
    }
}

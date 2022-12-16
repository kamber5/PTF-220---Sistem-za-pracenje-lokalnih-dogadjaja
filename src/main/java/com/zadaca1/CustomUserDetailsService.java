package com.zadaca1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
 
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new CustomUserDetails(user);
    }
 
}

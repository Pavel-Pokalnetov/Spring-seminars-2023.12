package ru.gb.pokalnetovps.hw7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.hw7.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ru.gb.pokalnetovps.hw7.model.User myUser= userRepository.findByName(userName);
        System.out.println(myUser);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: "+userName);
        }
        UserDetails user = User.builder()
                .username(myUser.getName())
                .password(myUser.getPassword())
                .roles(myUser.getUserGroup().split(","))
                .build();
        return user;
    }
}
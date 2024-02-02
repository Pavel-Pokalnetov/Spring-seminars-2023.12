package ru.gb.pokalnetovps.hw7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.pokalnetovps.hw7.model.User;
import ru.gb.pokalnetovps.hw7.repository.UsersRepository;

import java.util.Optional;


@Component
public class UserInfoUserDetailService implements UserDetailsService {
    @Autowired
    private UsersRepository uRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo  = uRepo.findByName(username);
        System.out.println(username+" | "+userInfo);

        return userInfo.map(UserInfoUserDetail::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}

package ru.gb.pokalnetovps.hw7.web.security;

import ru.gb.pokalnetovps.hw7.model.User;

import java.util.ArrayList;

public class JwtEntityFactory {
    public static JwtEntity create(User user){
        return new JwtEntity(
                user.getId();
                user.getName();
                user.getPassword();
                mapToGrantedAuthoritues(new ArrayList<>(user.getRoles()))
        )
    }
}

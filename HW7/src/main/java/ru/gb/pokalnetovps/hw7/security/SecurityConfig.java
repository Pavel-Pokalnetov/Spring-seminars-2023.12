package ru.gb.pokalnetovps.hw7.security;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import ru.gb.pokalnetovps.hw7.service.UserInfoUserDetailService;

import static ru.gb.pokalnetovps.devtools.DevTools.printObjMetaData;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        printObjMetaData(this);
        return new UserInfoUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        printObjMetaData(this);
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        printObjMetaData(this);
        http.authorizeHttpRequests().requestMatchers("/**").hasRole("USER").and().formLogin();
        return http.build();
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/public-data/**","/public-data").hasAnyRole("USER")
//                        .requestMatchers("/private-data/**","/private-data").hasAnyRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//                        .defaultSuccessUrl("/index.html")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/index.html"));
//        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        printObjMetaData(this);
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}

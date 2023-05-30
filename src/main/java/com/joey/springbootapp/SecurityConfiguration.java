package com.joey.springbootapp;

import com.joey.springbootapp.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.PortMapperImpl;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        PortMapperImpl portMapper = new PortMapperImpl();
//        portMapper.setPortMappings(Collections.singletonMap("8080","8080"));
//        PortResolverImpl portResolver = new PortResolverImpl();
//        portResolver.setPortMapper(portMapper);
//        LoginUrlAuthenticationEntryPoint entryPoint = new LoginUrlAuthenticationEntryPoint(
//                "/login");
//        entryPoint.setPortMapper(portMapper);
//        entryPoint.setPortResolver(portResolver);

        http
//                .exceptionHandling()
//                .authenticationEntryPoint(entryPoint)
//                .and()
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/",
                        "/",
                        "/register")
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/ads/create")
                .authenticated()
        ;
        return http.build();
    }

}

package com.ada.ProjetoFinalProgramacaoWeb2.controller.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            HandlerMappingIntrospector introspector
    ) throws Exception{
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET,"/")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/user")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.PUT, "/user")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.DELETE, "/user")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/login")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/user")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/type-product")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/type-product")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/product")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/product")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/order")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/order")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.POST, "/employee")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/employee")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.PUT, "/employee")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.DELETE, "/employee")).permitAll()
//                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/employee/searchBySalary")).permitAll()
//
////                        .requestMatchers(mvcMatcherBuilder.pattern(HttpMethod.GET, "/user")).hasRole("ADMIN")
//                        .anyRequest().authenticated())
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

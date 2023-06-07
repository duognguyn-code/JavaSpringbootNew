package com.example.manageprojectemployeeretro.config;

import com.example.manageprojectemployeeretro.entity.CustomOAuth2User;
import com.example.manageprojectemployeeretro.service.impl.CustomOAuth2UserService;
import com.example.manageprojectemployeeretro.service.impl.UserDetailsServiceImpl;
import com.example.manageprojectemployeeretro.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(oAuth2UserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {

                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                        Authentication authentication) throws IOException, ServletException {
                        System.out.println("AuthenticationSuccessHandler invoked");
                        System.out.println("Authentication name: " + authentication.getName());
                        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

                        userService.processOAuthPostLogin(oauthUser.getEmail());

                        response.sendRedirect("/home");
                    }
                })
                //.defaultSuccessUrl("/list")
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
        ;
        List<String> listConfig = new ArrayList<>();
        listConfig.add("*");
        http.csrf().disable().cors().configurationSource(httpServletRequest -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedHeaders(listConfig);
            configuration.setAllowedMethods(listConfig);
            configuration.setAllowCredentials(true);
            configuration.setAllowedOrigins(listConfig);
            return null;
        });
    }
    @Autowired
    private CustomOAuth2UserService oAuth2UserService;

    @Autowired
    private UserServiceImpl userService;

}

package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author VietDev
 * @date 01/08/2023
 * @role
 */
@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests.requestMatchers("", "/", "/home").permitAll()
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/holidays/**").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("12345").roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("54321").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}


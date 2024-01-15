package com.pawsoftedu.demo.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


// @Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }

    public UserDetailsService userDetailsService () {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("pass");

        manager.createUser(User.withUsername("test")
            .password(encodedPassword)
            .roles("USAA")
            .accountExpired(false)
            .build()
        );

        return manager;
    }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     // http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());

    //     http.cors().and()
    //         .csrf(csrf -> csrf.disable())
    //         // .userDetailsService(userDetailsService())
    //         .authorizeRequests()
    //             .requestMatchers("/login").permitAll()
    //             .requestMatchers("/materialcurs/**").hasAnyRole("ADMIN", "USAA")
    //             .anyRequest().authenticated()
    //         .and()
    //         .formLogin(login -> login.loginPage("/login").loginProcessingUrl("/login").permitAll())
    //         .logout().logoutUrl("/logout")
    //             .permitAll()
    //             .invalidateHttpSession(true)
    //             .deleteCookies("JSESSIONID");

    //     return http.build();
    // }
    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.cors().and()
      .csrf().disable()
            .authorizeRequests()
            .requestMatchers(HttpMethod.POST,"/materialcurs/**").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .and()
          .httpBasic();
      return http.build();
  }
}
package com.bickyraj.demo.keycloak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, ClientRegistrationRepository clientRegistrationRepository) throws Exception {
        http
                .csrf(withDefaults())
                .oauth2Login(withDefaults())
                .logout((logout) -> {
                    var logoutSuccessHandler = new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
                    logoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}");
                    logout.logoutSuccessHandler(logoutSuccessHandler);
                })
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().denyAll()
                );
        return http.build();
    }
}

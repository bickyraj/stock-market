package com.bickyraj.demo.keycloak;

import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) {
//        KeycloakAuthenticationProvider keycloakAuthenticationProvider = new KeycloakAuthenticationProvider();
//        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//        auth.authenticationProvider(keycloakAuthenticationProvider);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, ClientRegistrationRepository clientRegistrationRepository) throws Exception {
//        http
//                .csrf(Customizer.withDefaults())
//                .authorizeHttpRequests(authorize ->
//                        authorize
//                                .requestMatchers("/").permitAll()
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
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

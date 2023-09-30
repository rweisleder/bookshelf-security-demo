package de.workshops.bookshelf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                antMatcher("/swagger-ui.html"),
                                antMatcher("/swagger-ui/**"),
                                antMatcher("/v3/api-docs/**"),
                                antMatcher("/webjars/swagger-ui/**")
                        ).permitAll()
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.disable())
                .build();
    }
}

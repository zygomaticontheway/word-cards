package ait.wordcards.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity

@Configuration
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder encoder (){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        x -> x
                                .requestMatchers(HttpMethod.GET, "/cards").permitAll()
                                .requestMatchers(HttpMethod.GET, "/cards/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST, "/cards").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/cards/{cardId}/groups/{groupId}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/cards/{cardId}/groups/{groupId}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.GET, "/groups").permitAll()
                                .requestMatchers(HttpMethod.GET, "/groups/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST, "/groups").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/groups/{id}").hasRole("ADMIN")
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}

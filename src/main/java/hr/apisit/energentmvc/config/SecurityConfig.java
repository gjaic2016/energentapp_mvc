package hr.apisit.energentmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        MvcRequestMatcher.Builder requestMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(toH2Console())
                        .disable()
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(toH2Console()).permitAll()
                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers(requestMatcherBuilder.pattern("/styles/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/static/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/serviceproviders")).hasAnyAuthority("ROLE_USER", "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/serviceproviders/**")).hasAnyAuthority( "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/serviceproviders/delete/{id}")).hasAnyAuthority( "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/services")).hasAnyAuthority("ROLE_USER", "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/services/**")).hasAnyAuthority( "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/contracts")).hasAnyAuthority("ROLE_USER", "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/contracts/**")).hasAnyAuthority( "ADMIN", "ROLE_USER", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/households")).hasAnyAuthority("ROLE_USER", "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/households/**")).hasAnyAuthority( "ADMIN", "ROLE_USER", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/owners")).hasAnyAuthority("ROLE_USER", "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/owners/**")).hasAnyAuthority( "ADMIN", "ROLE_USER", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/address")).hasAnyAuthority("ROLE_USER", "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/address/new")).hasAnyAuthority("ROLE_USER", "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/address/**")).hasAnyAuthority( "ADMIN", "EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/users")).hasAnyAuthority( "ADMIN", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/users/update/**")).hasAnyAuthority( "ADMIN", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/users/update/{id}")).hasAnyAuthority( "ADMIN", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/users/**")).hasAnyAuthority( "ADMIN", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/error")).hasAnyAuthority("ROLE_USER", "ADMIN","EDITOR", "MANAGER", "SUPERUSER")
                .requestMatchers(requestMatcherBuilder.pattern("/country")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/country/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/about")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/login")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/home")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/home/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/register/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern(HttpMethod.DELETE, "/users/**" )).hasAuthority("ADMIN")
        ).formLogin((form) -> form
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home", true)
        ).logout((logout) -> logout
                .permitAll()
                .logoutSuccessUrl("/")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        );
        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
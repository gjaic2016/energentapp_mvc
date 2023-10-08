package hr.apisit.energentmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {

        MvcRequestMatcher.Builder requestMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(requestMatcherBuilder.pattern("/styles/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/static/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/serviceproviders")).hasAnyAuthority("ROLE_USER", "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/serviceproviders/**")).hasAnyAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/serviceproviders/delete/{id}")).hasAnyAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/services")).hasAnyAuthority("ROLE_USER", "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/services/**")).hasAnyAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/contracts")).hasAnyAuthority("ROLE_USER", "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/contracts/**")).hasAnyAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/households")).hasAnyAuthority("ROLE_USER", "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/households/**")).hasAnyAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/owners")).hasAnyAuthority("ROLE_USER", "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/owners/**")).hasAnyAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/address")).hasAnyAuthority("ROLE_USER", "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/address/**")).hasAnyAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/users")).hasAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/users/new")).hasAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/users/**")).hasAuthority( "ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern("/country")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/country/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/about")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/login")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/home")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/register")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern("/register/**")).permitAll()
                .requestMatchers(requestMatcherBuilder.pattern(HttpMethod.DELETE, "/**" )).hasAuthority("ADMIN")
                .requestMatchers(requestMatcherBuilder.pattern(HttpMethod.POST, "/**" )).hasRole("ADMIN")
        ).formLogin((form) -> form
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/home", true)
        ).logout((logout) -> logout
                .permitAll()
                .logoutSuccessUrl("/")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .deleteCookies("JSESSIONID")
        );
        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
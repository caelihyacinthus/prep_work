package lt.caeli.event.security;

import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers(HttpMethod.POST, "/api/events").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/api/events/**").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/api/events/*/participants").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/api/events").hasRole("USER")
//                .requestMatchers(HttpMethod.POST, "/api/events/*/register").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                .anyRequest().authenticated())
            .csrf(c -> c.disable())
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package org.mehana.common.configuration;

import org.mehana.user.enums.UserRoleEnum;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(
                        authorizeRequests ->
                                authorizeRequests
                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                                        .permitAll()

                                        .requestMatchers("/",
                                                "/about",
                                                "/contact",
                                                "/gallery",
                                                "/menu",
                                                "/user/login",
                                                "/user/register",
                                                "/error").permitAll()

                                        .requestMatchers(
                                                "/cart/**",
                                                "/checkout",
                                                "/order-history",
                                                "/orders/**",
                                                "/user/edit-profile").hasRole(UserRoleEnum.USER.name())

                                        .requestMatchers(
                                                "/admin/**",
                                                "/edit-product/{id}",
                                                "/disable-product/{id}",
                                                "/add-product"
                                        ).hasRole(UserRoleEnum.ADMIN.name())
                                        .anyRequest()
                                        .authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/user/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/", true)
                                .failureUrl("/user/login?error")
                )
                .logout(
                        logout ->
                                logout
                                        .logoutUrl("/user/logout")
                                        .logoutSuccessUrl("/")
                                        .invalidateHttpSession(true)
                                        .deleteCookies("JSESSIONID")
                )
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder
                .defaultsForSpringSecurity_v5_8();
    }
}

package com.pokemon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private BasicAuthenticationPoint basicAuthenticationEntryPoint;
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    public SecurityConfig(BasicAuthenticationPoint basicAuthenticationEntryPoint, AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.basicAuthenticationEntryPoint = basicAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/","/api/**").permitAll()
//                .antMatchers("/", "/home", "/about").permitAll()
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/admin/**").access("hasRole('ADMIN') and hasRole('USER')")
//                .and()
//                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated();
//        http.headers().frameOptions().disable();
//        http.httpBasic().authenticationEntryPoint(basicAuthenticationEntryPoint);


        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/about","/api").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                .logout()
                    .permitAll()
                    .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("pokemon").password("pokemon").roles("USER");
//    }

    @Bean
    public UserDetailsService userDetailsService() {
                // ensure the passwords are encoded properly
                User.UserBuilder users = User.withDefaultPasswordEncoder();
                InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
                manager.createUser(users.username("user").password("qwe").roles("USER").build());
                manager.createUser(users.username("admin").password("qwe").roles("USER","ADMIN").build());
                return manager;
    }
}


package pl.larys.prestige.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.larys.prestige.service.CustomEmployeeDetailsService;

/**
 * Created by piotr on 09.07.16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private CustomEmployeeDetailsService customEmployeeDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/przedszkola**", "/przedszkola/**").access("hasRole('ADMIN')")
                .antMatchers("/instruktorzy**", "/instruktorzy/**").access("hasRole('ADMIN')")
                .antMatchers("/zajecia**", "/zajecia/**").access("hasRole('EMPLOYEE')")
                .and()
                .formLogin()
                .loginPage("/login.html")
                //.permitAll().defaultSuccessUrl("/index")
                .usernameParameter("ssoId").passwordParameter("password")
                .and()
                .csrf()
                //.and().exceptionHandling().accessDeniedPage("/Access_Denied")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout.html"))
                //.logoutUrl("/logout.html")
                .logoutSuccessUrl("/")
                .permitAll();
            }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder registry) throws Exception {
        registry.userDetailsService(customEmployeeDetailsService);
    }
}

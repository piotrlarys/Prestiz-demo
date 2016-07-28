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
                .antMatchers("/przedszkola**", "/przedszkola/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/instruktorzy**", "/instruktorzy/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/zajecia**", "zajecia/**").access("hasRole('ROLE_EMPLOYEE')")
                .and().formLogin().loginPage("/login.html")
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf().disable().logout().logoutUrl("/logout").logoutSuccessUrl("/");

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

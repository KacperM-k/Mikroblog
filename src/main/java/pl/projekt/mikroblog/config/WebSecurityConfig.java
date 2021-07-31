package pl.projekt.mikroblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.projekt.mikroblog.service.UserService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    UserService userService;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
    }

   /* public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/all_users").hasAuthority("admin")
                .antMatchers(HttpMethod.POST, "/correct_user").access(userService.getLoggedUsername())
                .anyRequest().permitAll();
    }*/

}

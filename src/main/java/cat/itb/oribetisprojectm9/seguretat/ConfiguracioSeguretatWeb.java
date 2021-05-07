package cat.itb.oribetisprojectm9.seguretat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracioSeguretatWeb extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

            auth.userDetailsService(userDetailsService)
                    .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                   .antMatchers("/", "/h2-console/**", "/registre","/templates/**")
                   .permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                   .loginPage("/login")
                   .permitAll()
                   .and()
                .logout()//redirecció a /login?logout
                   .permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable(); //per utilitzar la consola h2
    }


}
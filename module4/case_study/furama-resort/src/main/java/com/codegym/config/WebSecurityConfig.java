package com.codegym.config;

import com.codegym.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //CSRF ( Cross Site Request Forgery) là kĩ thuật tấn công bằng cách sử dụng quyền chứng thực của người sử dụng đối với 1 website khác
        http.csrf().disable();
        
        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/listEmployee**", "/showCreateEmployee**",
                "/createEmployee**", "/view**", "/edit**", "/delete**", "/actionDelete**")
                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // Trang chỉ dành cho ADMIN
//        http.authorizeRequests().antMatchers("/employee/**").access("hasRole('ROLE_ADMIN')");

        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") //action của nó là j_spring_security_check
                .loginPage("/login")//
                .usernameParameter("username")//tham số này nhận từ form login có input name='username'
                .passwordParameter("password") //tham số này nhận từ form login có input  name='password'
                .defaultSuccessUrl("/")//Khi đăng nhập thành công thì vào trang này
                .failureUrl("/login?error=true")// Khi đăng nhập sai username và password thì nhập lại
                // Cấu hình cho Logout Page. Khi logout mình trả về trang
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

        // Cấu hình Remember Me.
        // ta có 1 nút remember me. Nếu người dùng tick vào đó ta sẽ dùng cookie lưu lại trong 24h
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        // Ta lưu tạm remember me trong memory (RAM). Nếu cần mình có thể lưu trong database
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;

        // Tạo lưu trong DB, phải tạo bảng ở DB trước
//        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
//        repository.setDataSource(dataSource);
//        return repository;
    }

}
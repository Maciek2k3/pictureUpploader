package com.pirtureuploader.pictureuploader;

import com.pirtureuploader.pictureuploader.model.ApiUser;
import com.pirtureuploader.pictureuploader.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailServiceImpl userDetailService;
    private AppUserRepo appUserRepo;

    @Autowired
    public WebSecurityConfig(UserDetailServiceImpl userDetailService, AppUserRepo appUserRepo) {
        this.userDetailService = userDetailService;
        this.appUserRepo=appUserRepo;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/gallery").hasRole("USER")
                .antMatchers("/uppload").hasRole("ADMIN")
                .antMatchers("/uploadImage").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        ApiUser apiUserUser=new ApiUser("UserJan",passwordEncoder().encode("nowak"),"ROLE_USER");
        ApiUser apiUserAdmin=new ApiUser("AdminJan",passwordEncoder().encode("nowak"),"ROLE_ADMIN");
        appUserRepo.save(apiUserUser);
        appUserRepo.save(apiUserAdmin);
  }


}

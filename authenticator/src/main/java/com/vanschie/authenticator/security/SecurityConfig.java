//package com.vanschie.authenticator.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//import javax.annotation.Resource;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Resource(name = "userService")
//    private UserDetailsService userDetailsService;
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("john").password(passwordEncoder().encode("123")).roles("USER").and()
//                .withUser("tom").password(passwordEncoder().encode("111")).roles("ADMIN").and()
//                .withUser("user1").password(passwordEncoder().encode("pass")).roles("USER").and()
//                .withUser("admin").password(passwordEncoder().encode("nimda")).roles("ADMIN");
////        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        // @formatter:off
//        http.authorizeRequests().antMatchers("/login").permitAll()
//                .antMatchers("/oauth/token/revokeById/**").permitAll()
//                .antMatchers("/tokens/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().permitAll()
//                .and().csrf().disable();
//        // @formatter:on
//    }
//
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public FilterRegistrationBean corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**", config);
//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setOrder(0);
//        return bean;
//    }
//}

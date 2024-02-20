package com.backend.bookStore.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).authorizeRequests(requests -> requests
                .antMatchers()
                .permitAll().anyRequest().authenticated()).exceptionHandling(handling -> handling
                .authenticationEntryPoint(this.jwtAuthenticationEntryPoint)).sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/send/delete/request").allowedOrigins("https://d1gmxjp1u1wf9h.cloudfront.net") // Replace
																											// with your
																											// domain
				.allowedMethods("POST").allowedHeaders("*").allowCredentials(false).maxAge(3600);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// Allow all origins, headers, and methods for testing purposes
				registry.addMapping("/server1/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("GET", "POST",
						"PUT", "DELETE", "OPTIONS");
			}
		};
	}

}

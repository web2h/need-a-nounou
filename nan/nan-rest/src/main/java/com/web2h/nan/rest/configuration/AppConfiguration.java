package com.web2h.nan.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.web2h.nan.core.service.AuthenticationService;
import com.web2h.nan.core.service.AuthenticationServiceImpl;
import com.web2h.nan.rest.interceptor.RequestValidityInterceptor;

@Configuration
@EnableWebMvc
@Import({DatabaseConfiguration.class})
@ComponentScan(basePackages = "com.web2h.nan")
@PropertySource("classpath:app.properties")
public class AppConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestValidityInterceptor(getAuthenticationService()));
		// TODO exclude path patterns for login
	}
	
	@Bean
	public AuthenticationService getAuthenticationService() {
	    return new AuthenticationServiceImpl();
	}
}
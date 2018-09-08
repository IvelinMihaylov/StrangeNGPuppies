package com.strangengpuppies.strangengpuppies.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
  public WebConfiguration() {
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/img/**",
		  "/css/**",
		  "/js/**")
		  .addResourceLocations("classpath:/static/img/",
				"classpath:/static/css/",
				"classpath:/static/js/");
  }
}

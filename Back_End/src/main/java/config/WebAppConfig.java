package config;

import advisor.AppWideExeptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AppWideExeptionHandler.class}, basePackages = "controller")
public class WebAppConfig{

}


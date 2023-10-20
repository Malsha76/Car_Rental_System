/**
 * @author:Malsha Ekanayake
 **/

package config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackages = "service")
public class WebRootConfig {
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();

    }


}

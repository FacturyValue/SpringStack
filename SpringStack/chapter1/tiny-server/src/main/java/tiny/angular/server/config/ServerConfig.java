package tiny.angular.server.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import tiny.angular.server.model.Server;
import tiny.angular.server.repository.ServerRepository;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static tiny.angular.server.enumeration.Status.SERVER_DOWN;
import static tiny.angular.server.enumeration.Status.SERVER_UP;

/**
 * @version V1.0
 * @Description:
 * @author: rudy
 * @date: 2022/4/18 20:40
 */
@Configuration
public class ServerConfig {
    @Bean
    public CommandLineRunner commandLineRunner(ServerRepository serverRepository){
        return args -> {
            serverRepository.save(new Server(null,"192.168.1.5","Ubuntu Linux","16 GB","Personal PC","http://localhost:8080/server/image/server1.png", SERVER_UP));
            serverRepository.save(new Server(null,"192.168.1.58","Fedora Linux","32 GB","Dell Tower","http://localhost:8080/server/image/server2.png", SERVER_DOWN));
            serverRepository.save(new Server(null,"192.168.1.21","MS 2008","8 GB","Web Server","http://localhost:8080/server/image/server3.png", SERVER_UP));
            serverRepository.save(new Server(null,"192.168.1.14","Red Hat Enterprise Linux","64 GB","Mail Server","http://localhost:8080/server/image/server4.png", SERVER_DOWN));
        };
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(asList("http://localhost:3000","http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
                "Accept","Jwt-Token","Authorization","Origin,Accept","X-Requested-With",
                "Access-Control-Allow-Origin","Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
                "Accept","Jwt-Token","Authorization","Access-Control-Allow-Credentials",
                "Filename"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
   /* @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/server/*").allowedOrigins("http://localhost:8080","http://localhost:4200","http://localhost:3000");
            }
        };
    }*/


}

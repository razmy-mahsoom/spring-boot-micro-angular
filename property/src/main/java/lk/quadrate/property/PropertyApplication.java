package lk.quadrate.property;

import lk.quadrate.property.entity.PropertyType;
import lk.quadrate.property.repository.PropertyTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "lk.quadrate.clients"
)
public class PropertyApplication {
    public static void main(String[] args) {
        SpringApplication.run(PropertyApplication.class,args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PropertyTypeRepository repository){
        return args -> {
            repository.saveAll(List.of(
                    PropertyType.builder().type("Hotel").build(),
                    PropertyType.builder().type("Apartment").build(),
                    PropertyType.builder().type("One Hotel").build(),
                    PropertyType.builder().type("Villa").build(),
                    PropertyType.builder().type("B&B").build()
            ));
        };
    }
}

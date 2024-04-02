package hiru.demospringboot;


import hiru.demospringboot.dto.SomethingDto;
import hiru.demospringboot.entity.SomethingEntity;
import hiru.demospringboot.mapper.SomethingMapper;
import hiru.demospringboot.repository.SomethingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoSpringbootApplication.class, args);
    }

}

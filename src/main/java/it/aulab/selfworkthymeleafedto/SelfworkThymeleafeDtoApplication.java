package it.aulab.selfworkthymeleafedto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SelfworkThymeleafeDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfworkThymeleafeDtoApplication.class, args);
    }

    @Bean
    public ModelMapper instanceModeMapper() {
        ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}
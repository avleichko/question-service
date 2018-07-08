package com.quiz;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }

    @Value(value = "serchServiceUrl")
    private String serchServiceUrl;

    @Value("searchServicePort")
    private String serchServicePort;


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}

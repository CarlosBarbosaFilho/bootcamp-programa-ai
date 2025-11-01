package br.com.programeai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApplicationWalletsService {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWalletsService.class, args);
    }
}
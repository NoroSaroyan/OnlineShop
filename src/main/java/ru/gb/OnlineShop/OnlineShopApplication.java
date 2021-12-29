package ru.gb.OnlineShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class OnlineShopApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SpringApplication.run(OnlineShopApplication.class, args);
    }

}

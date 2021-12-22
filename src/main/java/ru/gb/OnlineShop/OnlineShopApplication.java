package ru.gb.OnlineShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import ru.gb.encoder.SHA256_impl;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class OnlineShopApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SpringApplication.run(OnlineShopApplication.class, args);
       /* String pswrd = "11111";
        String hex1 = SHA256_impl.toHexString(SHA256_impl.getSHA(pswrd));
        String newPassword = "11111";
        String hex2 = SHA256_impl.toHexString(SHA256_impl.getSHA(newPassword));
        if (hex1.equals(hex2)) {
            System.out.println("accept");
            System.out.println("Hash: " + hex1.toString());
        } else {
            System.out.println("not equal");
            System.out.println("hex1: " + hex1);
            System.out.println("hex2: " + hex2);
        }*/
    }

}

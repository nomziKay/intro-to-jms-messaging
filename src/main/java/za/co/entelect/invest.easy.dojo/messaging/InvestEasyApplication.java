package za.co.entelect.invest.easy.dojo.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

//TODO: 1. Add @EnableJms annotation for the discovery of the methods with @JmsListener
@SpringBootApplication
@EnableJms
public class InvestEasyApplication {

    public static void main(String[] args){
        SpringApplication.run(InvestEasyApplication.class, args);
    }

}


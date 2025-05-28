package io.goflights.messenger.functions;

import io.goflights.messenger.dto.CustomerDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class Notifications {
    private static final Logger logger = LoggerFactory.getLogger(Notifications.class);

    @Bean
    public Function<CustomerDetailsDTO, CustomerDetailsDTO> email(){
        return customerDetailsDTO -> {
            logger.info("Sending email to customer with accountNumber" + customerDetailsDTO.accountNumber());
            return customerDetailsDTO;
        };
    }

    @Bean
    public Function<CustomerDetailsDTO, Long> sms(){
        return customerDetailsDTO -> {
            logger.info("Sending sms to customer with accountNumber" + customerDetailsDTO.accountNumber());
            return customerDetailsDTO.accountNumber();
        };
    }
}

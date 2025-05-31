package io.projects.goflights.customers.service;

import io.projects.goflights.customers.dto.CustomerDTO;
import io.projects.goflights.customers.dto.CustomerDetailsDTO;
import io.projects.goflights.customers.entity.Customer;
import io.projects.goflights.customers.exceptions.CustomerAlreadyExistsException;
import io.projects.goflights.customers.exceptions.ResourceNotFoundException;
import io.projects.goflights.customers.mapper.CustomerMapper;
import io.projects.goflights.customers.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private CustomerRepository customerRepository;
    private StreamBridge streamBridge;

    public void createCustomer(CustomerDTO customerDTO){
        Customer customer = CustomerMapper.mapToUser(customerDTO, new Customer());
        Optional<Customer> customerExists = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if(customerExists.isPresent()){
            throw new CustomerAlreadyExistsException("Customer with mobile number "+ customerDTO.getMobileNumber() + " already exists" );
        }
       Customer customerSaved= customerRepository.save(customer);
        sendEmailNotification(customerSaved);
    }

    public CustomerDTO findCustomerByMobileNumber(String mobileNumber){
        Customer customer= customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException(mobileNumber)
        );
        return CustomerMapper.mapToUserDTO(new CustomerDTO(), customer);
    }


    public void updateCustomer(CustomerDTO customerDTO){
        // Mobile Number is used to identify the customer, it is a primary key and the user cannot change it - at least for now
        Optional<Customer> customerExists = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (customerExists.isEmpty()){
            throw new RuntimeException("Customer with mobile number "+ customerDTO.getMobileNumber() + " not found");
        }
        Customer customer = CustomerMapper.mapToUser(customerDTO, customerExists.get());
        customerRepository.save(customer);
    }


    public void deleteCustomer(String mobileNumber){
        // Mobile Number is used to identify the customer. It is a primary key and the user cannot change it - at least for now
        Optional<Customer> customerExists = customerRepository.findByMobileNumber(mobileNumber);
        if (customerExists.isEmpty()){
            throw new RuntimeException("Customer with mobile number "+ mobileNumber + " not found");
        }
        Customer customer = CustomerMapper.mapToUser(new CustomerDTO(), customerExists.get());
        customerRepository.delete(customer);
    }

    public void sendEmailNotification(Customer customer){
        var cutomerDto = new CustomerDetailsDTO(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getMobileNumber());
        LOGGER.info("Sending customerDetailsDTO to Email Notification {}",  cutomerDto);
        var sendEmail = streamBridge.send("email-topic", cutomerDto);
    }

}

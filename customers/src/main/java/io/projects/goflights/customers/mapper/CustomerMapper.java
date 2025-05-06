package io.projects.goflights.customers.mapper;

import io.projects.goflights.customers.dto.CustomerDTO;
import io.projects.goflights.customers.entity.Customer;

import java.time.LocalDateTime;

public class CustomerMapper {
    public static CustomerDTO mapToUserDTO(CustomerDTO customerDTO, Customer customer){
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        return customerDTO;
    }

    public static Customer mapToUser(CustomerDTO customerDTO, Customer customer){
        customer.setEmail(customerDTO.getEmail());
        customer.setLastName(customerDTO.getLastName());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        return customer;
    }
}

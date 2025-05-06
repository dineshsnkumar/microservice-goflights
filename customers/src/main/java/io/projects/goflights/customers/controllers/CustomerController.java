package io.projects.goflights.customers.controllers;

import io.projects.goflights.customers.constants.CustomerConstants;
import io.projects.goflights.customers.dto.ResponseDTO;
import io.projects.goflights.customers.dto.CustomerDTO;
import io.projects.goflights.customers.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@Validated
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("")
    public String users(){
        return "All users";
    }

    @GetMapping("/mobile")
    public ResponseEntity<CustomerDTO> fetchUserByMobileNumber(@RequestParam String mobileNumber){
        CustomerDTO customerDTO = customerService.findCustomerByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.FOUND).body(customerDTO);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createUser(@Valid @RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(CustomerConstants.STATUS_201, CustomerConstants.MESSAGE_201));
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(CustomerConstants.STATUS_200, CustomerConstants.MESSAGE_200));
    }


    @DeleteMapping("/mobile")
    public ResponseEntity<ResponseDTO> deleteCustomer(@RequestParam String mobileNumber) {
        customerService.deleteCustomer(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(CustomerConstants.STATUS_200, CustomerConstants.MESSAGE_200));
    }


}

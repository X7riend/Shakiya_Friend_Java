package com.company.module9challenge.Controller;

import com.company.module9challenge.Model.Customer;
import com.company.module9challenge.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CustomerController
{

    @Autowired
    CustomerRepository repo;

    @GetMapping("/customers")
    public List<Customer> getCustomers() { return repo.findAll();}

    @GetMapping("customers/{id}")
    public Customer findCustomerById(@PathVariable int id) {

        Optional<Customer> returnVal = repo.findById(id);
        if(returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) { return repo.save(customer);}


    @DeleteMapping("/customers{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerbyId(@PathVariable int id) { repo.deleteById(id);}


    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {repo.save(customer);}
}

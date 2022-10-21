package com.company.module9challenge.Repository;

import com.company.module9challenge.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    Customer findCustomerById(int customerId);
    List<Customer> findAllCustomersByState(String state);

}

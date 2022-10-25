package com.company.M9ChallengeFriendShakiya.Repository;

import com.company.M9ChallengeFriendShakiya.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    Customer findCustomerById(int customerId);
    List<Customer> findAllCustomersByState(String state);

}


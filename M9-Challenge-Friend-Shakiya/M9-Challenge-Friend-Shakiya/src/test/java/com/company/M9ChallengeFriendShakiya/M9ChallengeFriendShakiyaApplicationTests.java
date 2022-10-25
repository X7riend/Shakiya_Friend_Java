package com.company.M9ChallengeFriendShakiya;

import com.company.M9ChallengeFriendShakiya.Model.Customer;
import com.company.M9ChallengeFriendShakiya.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class M9ChallengeFriendShakiyaApplicationTests
{
// Not Confident in how to test these and my computer keeps crashing when I run the tests
// Tests fail and I don't know what I'm testing for.
	@Autowired
	CustomerRepository customerRepo;

	@Test
	public void contextLoads()
	{
	}
	@Test
	public void createCustomer()
	{
		// Arrange
		Customer cust = new Customer();
		cust.setFirstName("Kiya");
		cust.setLastName("Friend");
		cust.setPhone("222-222-2440");
		cust.setAddress1("304 Rosedale Rd");
		cust.setCity("Norfolk");
		cust.setCompany("NSU");
		cust.setEmail("s@gmail.com");
		cust.setPostalCode("34509");
		cust.setState("Virginia");


	}

}

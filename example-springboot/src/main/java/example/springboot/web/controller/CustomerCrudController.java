package example.springboot.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.springboot.domain.Customer;
import example.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User : Dongle (Dongkyun)
 * Date : 2016. 12. 19.
 */
@RestController
public class CustomerCrudController {
    @Autowired
    private CustomerRepository customerRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value="/customer/create", method=RequestMethod.PUT)
    public String create(@RequestBody Customer customer) throws JsonProcessingException {
        customer = customerRepository.save(customer);
        return String.format("Created. %s", objectMapper.writeValueAsString(customer));
    }

    @RequestMapping(value="/customer/list", method=RequestMethod.GET)
    public String list() throws JsonProcessingException {
        List<Customer> customers = customerRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        for(Customer customer : customers)  {
            stringBuilder.append(String.format("Customer. %s%n", objectMapper.writeValueAsString(customer)));
        }
        return stringBuilder.toString();
    }

    @RequestMapping(value="/customer/update/{id}/{firstName}/{lastName}", method=RequestMethod.GET)
    public String update(@PathVariable("id") long id,
                         @PathVariable("firstName") String firstName,
                         @PathVariable("lastName") String lastName) throws JsonProcessingException {
        Customer customer = customerRepository.findOne(id);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);

        return String.format("Updated. %s", objectMapper.writeValueAsString(customer));
    }

    @RequestMapping(value="/customer/delete/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id)   {
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(id);
        return String.format("Deleted. %s", customer);
    }
}

package org.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PostMapping("/customer")
    public Customer save(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("/customer/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerRepository.findById(id).map(
                customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    return customerRepository.save(customer);
                }
        ).orElseGet(()-> customerRepository.save(updatedCustomer));
    }

    @GetMapping("/")
    public String welcome(){
        return "Welcome to Customer page";
    }
}


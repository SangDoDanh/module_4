package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> customerList = customerService.findAll();
        if(customerList.isEmpty()) {
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id,
                                                   @RequestBody Customer customer){
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(id);
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Customer> updateCustomerPatch(@PathVariable int id,
//                                                   @RequestBody Customer customer){
//        Optional<Customer> customerOptional = customerService.findById(id);
//        if(!customerOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        customer.setId(id);
//        customerService.save(customer);
//        return new ResponseEntity<>(customer, HttpStatus.OK);
//    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> updateCustomerPatch(@PathVariable int id,
                                                        @RequestBody Map<Object, Object> fields){
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("asd");
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Customer.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, customerOptional.get(), value);
        } );
        customerService.save(customerOptional.get());
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteById(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }
}

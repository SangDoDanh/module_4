package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping
    private String showAll(@RequestParam(required = false, defaultValue = "") String nameSearch,
                           @RequestParam(required = false, defaultValue = "") String emailSearch,
                           @RequestParam(required = false, defaultValue = "") String customerTypeSearch,
                           Model model, @PageableDefault(value = 3) Pageable pageable) {

        List<CustomerType> customerTypeList = customerTypeService.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        model.addAttribute("customerTypeList",customerTypeList );
        Page<Customer> customerList = customerService.search(nameSearch, emailSearch, customerTypeSearch, pageable);
        Page<CustomerDto> customerListDto = new PageImpl<>(customerDtoList, pageable, customerList.getTotalElements());
        model.addAttribute("customerList", customerList);
        model.addAttribute("customerEmpty", new Customer());
        return "/customer/list";
    }
    @GetMapping("/create")
    private String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList",customerTypeList );
        return "/customer/create";
    }
    @PostMapping("/create")
    private String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Add new OK!");
        return "redirect:/customers" ;
    }
    @GetMapping("delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if(!customerOptional.isPresent()){
            redirectAttributes.addFlashAttribute("message", "Remove Fail!");
        } else {
            Customer customer = customerOptional.get();
            customer.setStatus(true);
            customerService.removeCustomer(customer);
            redirectAttributes.addFlashAttribute("message", "Remove OK!");
        }

        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String editCustomer(@ModelAttribute(value = "customerEmpty") Customer customer, RedirectAttributes redirectAttributes) {
        Optional<Customer> customerOptional = customerService.findById(customer.getId());
        if(!customerOptional.isPresent()){
            redirectAttributes.addFlashAttribute("message", "Edit fail!");
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Edit OK!");
        }
        return "redirect:/customers";
    }
}

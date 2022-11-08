package com.codegym.controller;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.AttachFacility;
import com.codegym.model.facility.Facility;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;

    @GetMapping
    private String showContract(Model model, @PageableDefault(value = 3)Pageable pageable) {
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        Page<Contract> contractPage = contractService.findAll(pageable);
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("contractPage", contractPage);
        return "/contract/list";
    }


    @GetMapping("/create")
    public String showCreateContract(Model model) {
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList  = customerService.findAll();
        model.addAttribute("customerList", customerList);
        List<Facility> facilityList  = facilityService.findAll();
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("contractEmpty", new Contract());
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("attachFacilityList", attachFacilityList);
        return "/contract/create";
    }
    @PostMapping("/create")
    public String createContract(@ModelAttribute(value = "contractEmpty") Contract contract,
                                 RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create Contract Ok!");
        contractService.save(contract);
        return "redirect:/contract";
    }
}

package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("employee", new Employee());
        List<String> languages = new ArrayList<>();
        languages.add("PHP");
        languages.add("JAVA");
        languages.add("C#");
        languages.add("PYTHON");
        model.addAttribute("languages", languages);
        return "create";
    }
    @GetMapping
    public String showList(Model model) {
        List<Employee> employeeList = iEmployeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "list";
    }
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        iEmployeeService.add(employee);
        redirectAttributes.addFlashAttribute("message", "Create " + employee.getName() + " OK!");
        return "redirect:/employee";
    }


}

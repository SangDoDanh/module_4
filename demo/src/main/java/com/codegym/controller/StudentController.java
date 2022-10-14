package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

//    @GetMapping
//    public String showList(Model model) {
//        List<Student> studentList = iStudentService.findAll();
//        model.addAttribute("studentList", studentList);
//        return "list";
//    }

    @GetMapping
    public String showList(ModelMap model) {
        List<Student> studentList = iStudentService.findAll();
        model.addAttribute("studentList", studentList);
        return "list";
    }
    @GetMapping("/m")
    public ModelAndView showList2() {
        List<Student> studentList = iStudentService.findAll();
        return new ModelAndView("list", "studentList", studentList);
    }
    @PostMapping("/add")
    public String addStudent(Model model,@RequestParam int id, String name, String gender, String languages){
        String[] lang =  languages.split(",");
        Student student = new Student(id, name, gender, lang);
        iStudentService.add(student);
        List<Student> studentList = iStudentService.findAll();
        model.addAttribute(studentList);
        return "list";
    }
}

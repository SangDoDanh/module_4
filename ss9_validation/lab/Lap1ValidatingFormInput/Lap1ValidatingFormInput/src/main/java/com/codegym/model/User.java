package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User: bắt buộc không được bỏ trống")
    @Size(min = 2, max = 30, message = "User:  có độ dài tối thiểu là 2 ký tự, tối đa là 30 ký tự")
    private String userName;
    @NotBlank(message = "Password: bắt buộc không được bỏ trống")
    @Size(min = 6, max = 50, message = "Password: tối thiểu 6 ký tự tối da 50 ký tụ")
    private String password;
    @Min(value = 18, message = "Age: bắt buộc nhập, có giá trị nhỏ nhất là 18")
    private int age;
    private int status;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        User user = (User) target;
//
//        String name = user.getUserName();
//        String password = user.getPassword();
//        int age = user.getAge();
//
//        if("".equals(name) || name == null){
//            errors.rejectValue("userName", "error.userName.blank", "User name not empty!");
//        } else if(name.length() < 2 || name.length() > 30){
//            errors.rejectValue("userName", "error.userName.size", "User name: length[2-30]");
//        }

//        if("".equals(password) || password.length() < 6){
//            errors.rejectValue("password", "error.password.blank", "password  length[>6]");
//        }
//
//        if(age < 18 || age > 50) {
//            errors.rejectValue("age", "error.age.min", "Age length[18-50]");
//        }
//    }
}

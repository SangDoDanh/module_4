package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private Integer id;
    @NotBlank(message = "Not is empty!")
    @Size(min = 5, max = 45, message = "Fist Name : length[5-45]!")
    private String firstName;
    @NotBlank(message = "Not is empty!")
    @Size(min = 5, max = 45, message = "Last Name : length[5-45]!")
    private String lastName;
    @NotBlank(message = "Not is empty!")
    private String email;
    private String phoneNumber;
    private Integer age;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String regexEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String regexPhoneNumber = "^\\d{10}$";
        UserDto userDto = (UserDto) target;
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        String email = userDto.getEmail();
        String phoneNumber = userDto.getPhoneNumber();
        Integer age = userDto.getAge();

         if(!email.matches(regexEmail)) {
             errors.rejectValue("email", "","Email invalid!");
         }
         if(!phoneNumber.matches(regexPhoneNumber)) {
             errors.rejectValue("phoneNumber", "","Phone number invalid!");
         }

         if(age == null || age < 18 || age > 100) {
             errors.rejectValue("age", "","age: [18-100] invalid!");

         }
    }
}

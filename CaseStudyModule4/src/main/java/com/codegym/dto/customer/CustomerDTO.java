package com.codegym.dto.customer;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CustomerDTO implements Validator {
    private Integer id;
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
    message = "Nhắc nhở nhẹ nha. không được bỏ trống, viết hoa chữ cái đầu lên iêm! Vd: Nguyen Van A")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfBirth;

    private Integer gender = 1;
    @Pattern(regexp = "^(\\d{9}|\\d{12})$", message = "ký đầu giờ, 9 đến 12 chữ số thôi iêm!")
    private String idCard;

    @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$",
    message = "Phone number format: 090xxxxxxx | 091xxxxxxx | (84)+90xxxxxxx | (84)+91xxxxxxx")
    private String phoneNumber;
    @Email(message = "Đến email cũng nhập sai ạ! vd: daikagiangho@gmail.com")
    @NotBlank(message = "Khong duoc bo trong email")
    private String email;
    private String address;
    private Boolean status = false;
    private CustomerType customerType;
    private Set<Contract> contractSet;
    private List<String> emailList;

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public CustomerDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        CustomerDTO customerDTO = (CustomerDTO) target;
        String email = customerDTO.getEmail();
        LocalDate date = customerDTO.getDayOfBirth();

//      Validate email
        for(String emailDTO : customerDTO.getEmailList()) {
            if(emailDTO == null)
                continue;
            if(emailDTO.equals(email)){
                errors.rejectValue("email", "", "Email da ton tai!");
                break;
            }
        }

//        validate dayOfBirth
        if(date == null) {
            errors.rejectValue("dayOfBirth", "", "Không được bỏ trống!");
        } else {
            int age = LocalDate.now().getYear() - date.getYear();
            if(age< 10 || age > 100) {
                errors.rejectValue("dayOfBirth", "", "Tuổi trong khoảng: 10 -100!");
            }
        }
    }
}

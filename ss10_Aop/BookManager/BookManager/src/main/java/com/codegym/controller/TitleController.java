package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.OrderBook;
import com.codegym.model.Otp;
import com.codegym.model.Title;
import com.codegym.service.IBookService;
import com.codegym.service.IOrderService;
import com.codegym.service.IOtpService;
import com.codegym.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private ITitleService titleService;

    @Autowired
    private IOtpService otpService;

    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderService orderService;

    @GetMapping
    public String showTitle(Model model) {
        List<Title> titleList = titleService.findAll();
        model.addAttribute("titleList", titleList);
        return "/title/list";
    }

    @GetMapping("/oder/{id}")
    public String showOderTitle(@PathVariable int id, Model model) {
        int otp = otpService.getOtp(99999,11111);
        Otp otp_code = new Otp();
        otp_code.setValue(otp);
        otpService.save(otp_code);
        model.addAttribute("otp", otp_code);
        model.addAttribute("title", titleService.findTitleById(id));
        return "/title/oder";
    }

    @PostMapping("/oder")
    public String oder(@RequestParam int otpValue ,@ModelAttribute Otp otp, @ModelAttribute Title title, RedirectAttributes redirectAttributes) {
        otp.setValue(otpValue);
        int otp_code = otpService.findById(otp.getOtpId()).getValue();
        if(otp_code != otp.getValue()) {
            redirectAttributes.addFlashAttribute("message", "Otp code is not correct");
            otpService.remove(otp.getOtpId());
            return "redirect:/title";
        } else {
            otpService.remove(otp.getOtpId());
        }

        Book book = bookService.getBook(title.getId());
        if(book == null) {
            redirectAttributes.addFlashAttribute("message", "no more left to be borrowed!");
            return "redirect:/title";
        }
        OrderBook orderBook = new OrderBook();
        orderBook.setOtp(otp.getValue());
        orderBook.setBook(book);
        orderBook.setStatus(0);
        bookService.oder(book.getId());
        orderService.save(orderBook);
        redirectAttributes.addFlashAttribute("message", "Get now Ok");
        return "redirect:/title";
    }


    @GetMapping("/give")
    public String giveBook(@RequestParam(value = "otpCode", required = false, defaultValue = "0") int otpCode, RedirectAttributes redirectAttributes) {
         OrderBook orderBook = orderService.findByOtpCode(otpCode);
        if(orderBook == null) {
            redirectAttributes.addFlashAttribute("message", "Give book fail!, otp-code is not correct!" + otpCode);
            return "redirect:/title";
        }
        bookService.give(orderBook.getBook().getId());
        orderService.remove(orderBook);
        redirectAttributes.addFlashAttribute("message", "Give book Ok!" + otpCode);
        return "redirect:/title";
    }

    @GetMapping("/error")
    public String showError() {
        return "title/error";
    }

    @ExceptionHandler(Exception.class)
    public String handlerError() {
        return "title/error";
    }

}

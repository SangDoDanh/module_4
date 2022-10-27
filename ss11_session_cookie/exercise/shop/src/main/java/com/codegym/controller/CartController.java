package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("cart")
public class CartController {


    @Autowired
    HttpSession httpSession;

    @Autowired
    private IProductService productService;

    @GetMapping
    public String showCart(Model model) {
        Cart cart = getCart();
        model.addAttribute("carts", cart.getProductMap());
        model.addAttribute("total", cart.totalPay());
        return "/cart/list";
    }

    /**
     * Tăng số lượng sản phẩm trong giỏ hàng,
     * Số lượng về 0 sẽ, sản phẩm sẽ bị xóa khỏi giỏ hàng
     * Tổng tiền sẽ được cập nhật
     *
     * @param id : product_id
     * @return
     */
    @GetMapping("/add/{id}")
    public String addProductToCart(@PathVariable int id) {
        Cart cart = getCart();
        Optional<Product> optionalProduct = productService.findById(id);
        if(optionalProduct.isPresent()) {
            cart.addProduct(optionalProduct.get());
        }
        httpSession.setAttribute("cartList", cart);
        return "redirect:/cart";
    }

    /**
     * Giảm số lượng sản phẩm trong giỏ hàng,
     * Số lượng về 0 sẽ, sản phẩm sẽ bị xóa khỏi giỏ hàng
     * Tổng tiền sẽ được cập nhật
     *
     * @param id : product_id
     * @return
     */
    @GetMapping("/remove/{id}")
    public String moreProduct(@PathVariable int id) {
        Cart cart = getCart();
        if(!cart.getProductMap().isEmpty()) {
            Optional<Product> optionalProduct = productService.findById(id);
            if(optionalProduct.isPresent()) {
                cart.deleteProduct(optionalProduct.get());
            }
            httpSession.setAttribute("cartList", cart);
        }
        return "redirect:/cart";
    }
    private Cart getCart() {
        if(httpSession.getAttribute("cartList") == null)
            return new Cart();
        return (Cart) httpSession.getAttribute("cartList");
    }
}

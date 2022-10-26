package com.codegym.service.impl;

import com.codegym.model.OrderBook;
import com.codegym.repository.IOrderBookRepository;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderBookRepository orderBookRepository;

    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public OrderBook findByOtpCode(int otpCode) {
        Optional<OrderBook> optional = orderBookRepository.findOrderBookByOtp(otpCode);
        if(!optional.isPresent()){
            return null;
        }
        return optional.get();
    }

    @Override
    public void remove(OrderBook orderBook) {
        orderBookRepository.remove(orderBook.getIt());
    }
}

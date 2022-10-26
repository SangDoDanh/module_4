package com.codegym.service;

import com.codegym.model.OrderBook;

public interface IOrderService {
    void save(OrderBook orderBook);

    OrderBook findByOtpCode(int otpCode);

    void remove(OrderBook orderBook);
}

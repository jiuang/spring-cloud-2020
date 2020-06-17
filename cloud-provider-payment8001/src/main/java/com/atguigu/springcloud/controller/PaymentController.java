/*
 * Copyright (c) 2020-2020 Gannalyo.
 */

package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Gannalyo
 * @since 2020/6/10
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    private final CountDownLatch requestCount = new CountDownLatch(500000);
    private final ExecutorService executorService = Executors.newFixedThreadPool(1000);

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "Successfully to create Payment....");
        } else {
            return new CommonResult(444, "Failed to create Payment....", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> create(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        requestCount.countDown();
        System.out.println(requestCount.getCount());
        if (payment != null) {
            return new CommonResult(200, "Successfully to get Payment by id " + id + "....", payment);
        } else {
            return new CommonResult(444, "No data for " + id + " ....", null);
        }
    }

    @GetMapping(value = "/highConcurrent")
    public void highConcurrent() {
        executorService.execute(() -> {
//            Payment payment = paymentService.getPaymentById(1L);
            System.out.println(requestCount.getCount());
            requestCount.countDown();
        });
    }

    @GetMapping(value = "/empty")
    public void empty() {
    }

}

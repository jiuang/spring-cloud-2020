/*
 * Copyright (c) 2020-2020 Gannalyo.
 */

package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Gannalyo
 * @since 2020/6/10
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

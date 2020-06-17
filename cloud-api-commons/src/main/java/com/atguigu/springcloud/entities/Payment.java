/*
 * Copyright (c) 2020-2020 Gannalyo.
 */

package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gannalyo
 * @since 2020/6/9
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}

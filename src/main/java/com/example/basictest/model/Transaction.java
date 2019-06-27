package com.example.basictest.model;

import lombok.*;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/6/27     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}

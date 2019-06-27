package com.example.basictest.util;

import java.math.BigDecimal;

/**
 * <pre>
 * *********************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description:
 * HISTORY:
 * *********************************************
 *  Version       Date      Author      Desc
 *   v2.0      2016/9/5    tandeguan    金额转换工具类
 *
 * *********************************************
 * </pre>
 */
public class MoneyUtil {

    //以角为单位计算
    public static final Integer AMOUNT_LINIT_ARC = 10;

    //以分为单位计算
    public static final Integer AMOUNT_LIMIT_MIN = 100;

    /**
     * 入参金额处理
     *
     * @param param 待处理金额
     * @param limit 换算单位
     * @return
     */
    public static String requestParamHandle(String param, Integer limit) {
        if (limit == null)
            limit = AMOUNT_LIMIT_MIN;
        String amount = String.valueOf((BigDecimal.valueOf(Double.valueOf(param)).multiply(BigDecimal.valueOf(limit).setScale(0))));
        if (amount.contains(".")) {
            amount = amount.substring(0,amount.indexOf("."));
        }
        return amount;
    }

    /**
     * 出参金额处理
     *
     * @param param 待处理金额
     * @param limit 换算单位
     * @return
     */
    public static String responseParamHandle(String param, Integer limit) {
        if (limit == null)
            limit = AMOUNT_LIMIT_MIN;
        return String.valueOf((new BigDecimal(param).divide(BigDecimal.valueOf(limit).setScale(0))));
    }

    public static void main(String[] args) {
        System.err.println(MoneyUtil.responseParamHandle(String.valueOf(10000000000L), null));
        System.err.println(BigDecimal.valueOf(Double.valueOf(MoneyUtil.responseParamHandle(String.valueOf(10000000000L), null))).toString());



//        System.err.println(BigDecimal.valueOf(Double.valueOf(MoneyUtil.responseParamHandle(String.valueOf(32423), null))));
//        System.err.println(String.valueOf((BigDecimal.valueOf(Double.valueOf("5650.00")).multiply(BigDecimal.valueOf(AMOUNT_LIMIT_MIN)).setScale(0))));
//        System.err.println(Long.valueOf(String.valueOf((BigDecimal.valueOf(Double.valueOf("5650.00")).multiply(BigDecimal.valueOf(AMOUNT_LIMIT_MIN)).setScale(0)))));
    }
}

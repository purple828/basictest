package com.example.basictest.jdk8test;

import com.alibaba.fastjson.JSON;
import com.example.basictest.model.Trader;
import com.example.basictest.model.Transaction;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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
@Slf4j
public class StreamDemo2 {

    public static void main(String[] args) {

        List<Transaction> transactions =  getData();
        log.info("------------>所有数据：{}",JSON.toJSONString(transactions));

        //找出2011年的所有交易并按交易额排序（从低到高）
        List<Transaction> trans2011 = transactions.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList());
        log.info("------------>找出2011年的所有交易并按交易额排序（从低到高）：{}",JSON.toJSONString(trans2011));

        //交易员都在哪些不同的城市工作过
        List<String> cityNames = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(toList());
        List<String> cityNames2 = transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(toList());
        Set<String> cityNames3 = transactions.stream().map(t -> t.getTrader().getCity()).collect(toSet());
        log.info("------------>交易员都在哪些不同的城市工作过1111：{}",JSON.toJSONString(cityNames));
        log.info("------------>交易员都在哪些不同的城市工作过2222：{}",JSON.toJSONString(cityNames2));
        log.info("------------>交易员都在哪些不同的城市工作过3333：{}",JSON.toJSONString(cityNames3));

        //查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> cambridgeTraders = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getTrader).sorted(comparing(Trader::getName)).collect(toList());
        List<Trader> cambridgeTraders2 = transactions.stream().map(Transaction::getTrader).filter(r -> r.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName)).collect(toList());
        log.info("------------>查找所有来自于剑桥的交易员，并按姓名排序1111：{}",JSON.toJSONString(cambridgeTraders));
        log.info("------------>查找所有来自于剑桥的交易员，并按姓名排序2222：{}",JSON.toJSONString(cambridgeTraders2));

        //返回所有交易员的姓名字符串，按字母顺序排序
        String traderNames = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("",(a,b) -> a + b);
        String traderNames2 = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(joining());
        log.info("------------>返回所有交易员的姓名字符串，按字母顺序排序1111：{}",JSON.toJSONString(traderNames));
        log.info("------------>返回所有交易员的姓名字符串，按字母顺序排序2222：{}",JSON.toJSONString(traderNames2));

        //有没有交易员是在米兰工作的
        boolean milan = transactions.stream().map(Transaction::getTrader).anyMatch(r -> r.getCity().equals("Milan"));
        boolean milan2 = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        log.info("------------>有没有交易员是在米兰工作的1111：{}",milan);
        log.info("------------>有没有交易员是在米兰工作的2222：{}",milan2);

        //计算所有生活在剑桥的交易员的交易总额
        Optional<Integer> cambridge = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce(Integer::sum);
        int cambridge2 = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).mapToInt(Transaction::getValue).sum();
        log.info("------------>打印生活在剑桥的交易员的所有交易额1111：{}",cambridge.get());
        log.info("------------>打印生活在剑桥的交易员的所有交易额2222：{}",cambridge2);

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).forEach(System.out::println);

        //所有交易中，最高的交易额是多少
        Optional<Integer> maxTrade = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        log.info("------------>所有交易中，最高的交易额是多少：{}",maxTrade.get());

        //找到交易额最小的交易
        Optional<Transaction> minTrans = transactions.stream().reduce((a, b) -> a.getValue() < b.getValue() ? a : b);
        Optional<Transaction> minTrans2 = transactions.stream().min(comparing(Transaction::getValue));
        log.info("------------>找到交易额最小的交易1111：{}",minTrans.get());
        log.info("------------>找到交易额最小的交易2222：{}",minTrans2.get());

    }

    private static List<Transaction>  getData(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        return transactions;
    }


}

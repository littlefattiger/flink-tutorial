package com.atguigu.apitest.state;

import org.apache.flink.table.expressions.Or;

public class testSIngle {
    public static void main(String[] args) {

        Bank banka = Bank.getInstance();
        Bank bankb = Bank.getInstance();
        System.out.println(banka == bankb);

        Order ordera = Order.getInstance();
        Order orderb = Order.getInstance();
        System.out.println(ordera == orderb);
    }
}

class Bank {
    private Bank() {
    }

    ;
    private static Bank instance = new Bank();

    public static Bank getInstance() {
        return instance;
    }
}

class Order {
    private Order() {
    }

    ;
    private volatile static Order instance;

    public static Order getInstance() {
        if (instance == null) {
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;
    }
}
package com.cjt.practice.exam;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程中断仅仅是设置中断标识位（对synchronized和lock获取锁不可中断）
 *
 * @author caojiantao
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger integer = new AtomicInteger();
        Thread t = new Thread(() -> {
            try {
                // 中断标识位判断
                while (!Thread.currentThread().isInterrupted() && integer.intValue() < 5) {
                    System.out.println("I'm running...");
                    integer.incrementAndGet();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                // 线程阻塞（sleep、wait）中中断抛错，注意此处线程中断标识未重置了
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });
        t.start();


        Thread.sleep(2000);
        t.interrupt();
    }
}

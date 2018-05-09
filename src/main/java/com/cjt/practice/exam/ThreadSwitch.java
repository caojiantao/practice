package com.cjt.practice.exam;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author caojiantao
 */
public class ThreadSwitch {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        new Thread(() -> {
            while (true) {
                synchronized (count) {
                    try {
                        while (count.intValue() % 10 != 0) {
                            count.wait();
                        }
                        System.out.println("AAA");
                        TimeUnit.SECONDS.sleep(1);
                        count.incrementAndGet();
                        count.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (count) {
                    try {
                        while (count.intValue() % 10 != 1) {
                            count.wait();
                        }
                        System.out.println("BBB");
                        TimeUnit.SECONDS.sleep(1);
                        count.incrementAndGet();
                        count.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                synchronized (count) {
                    try {
                        while (count.intValue() % 10 != 2) {
                            count.wait();
                        }
                        System.out.println("CCC");
                        TimeUnit.SECONDS.sleep(1);
                        count.incrementAndGet();
                        count.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        }).start();
    }
}

package com.demo.test.多线程;

import java.util.ArrayList;
import java.util.List;

public class 多线程循环打印 {

    public static class Solution {

        //需要打印的数字
        private int N;
        //线程总数
        private int threadNum;
        private Object lock = new Object();
        //当前打印到的数字
        private volatile int curNum;

        private class PrintRunnable implements Runnable {

            private final int NUMBER;
            private Thread beforeThread;

            public PrintRunnable(int number) {
                this.NUMBER = number;
            }

            // 仅使用join时才需要beforeThread
            public PrintRunnable(int number, Thread beforeThread) {
                this.beforeThread = beforeThread;
                this.NUMBER = number;
            }

            @Override
            public void run() {
                // waitAndNotify();
                onlySynchronized();
//                joinThread();
            }


            private void waitAndNotify() {
                while (curNum < N) {
                    synchronized (lock) {
                        while (curNum % threadNum != NUMBER) {
                            if (curNum >= N) {
                                return;
                            }
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (curNum > N) {
                            return;
                        }
                        System.out.println(Thread.currentThread().getName() + " " + curNum);
                        curNum++;
                        lock.notifyAll();
                    }
                }
            }


            private void onlySynchronized() {
                //while循环保证线程处于执行状态，获取CPU时间
                while (curNum < N) {
                    //如果不是自己执行打印，自旋等待
                    //因为每次读取VC时都需要读取最新的值，所以VC为volatile修饰
                    while (curNum % threadNum != NUMBER) {//自旋
                        //自旋过程中发现已经打印到N，则结束线程
                        if (curNum > N) {
                            return;
                        }
                    }
                    //确定需要自己打印，获取内置锁
                    synchronized (lock) {
                        //二次判断，如果已经打印到N，结束线程
                        if (curNum > N) {
                            return;
                        }
                        //打印，并且更新curNum
                        System.out.println(Thread.currentThread().getName() + " " + curNum);
                        curNum++;
                    }
                }
            }

            private void joinThread() {
                if (beforeThread != null) {
                    try {
                        beforeThread.join();
                        System.out.println(Thread.currentThread().getName() + " " + curNum++ + " ," + beforeThread.getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " " + curNum++ + " ,beforeThread = null");
                }
            }
        }

        //函数初始化mc个线程，并且启动所有的线程
        public void printSeqNum(int N, int mc) {
            this.N = N;
            this.threadNum = mc;
            this.curNum = 0;
            for (int i = 0; i < mc; ++i) {
                new Thread(new PrintRunnable(i)).start();
            }

            // joinThread 的初始化 start，只会打印 0～mc(线程个数)
            List<Thread> list = new ArrayList<>();
            for (int i = 0; i < mc; ++i) {
                Thread thread = new Thread(new PrintRunnable(i, i == 0 ? null : list.get(i - 1)));
                list.add(thread);
            }

            for (Thread t : list) {
                t.start();
            }
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // joinThread 的初始化 end
        }
    }

    //main函数作为测试用例
    public static void main(String[] args) {
        Solution print = new Solution();
        print.printSeqNum(100, 10);
    }
}
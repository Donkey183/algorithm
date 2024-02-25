package com.demo.test.多线程;

public class 两个线程交替打印 {

  private static final Object lock = new Object();
  private static final int max = 100;
  private static volatile int cur = 1; // 从1打印则先初始化奇数线程, 若为偶数0开始打印则先初始化偶数线程

  public static void main(String[] args) {
    Task t1 = new Task();
    Task t2 = new Task();
    // 错误示范！！当前还是主线程
    // t1.run();
    // t2.run();

    // 正确示范 wait和notify方式
//    new Thread(t1, "奇数线程: ").start();
//    new Thread(t2, "偶数线程: ").start();

    // 不使用notify和wait
    Task2 t3 = new Task2();
    Task3 t4 = new Task3();
    new Thread(t3, "偶数线程: ").start();
    new Thread(t4, "奇数线程: ").start();
  }


  static class Task implements Runnable {

    @Override
    public void run() {
      while (cur <= max) {
        synchronized (lock) {
          // 打印数字，并立即释放锁
          System.out.println(Thread.currentThread().getName() + cur++);
          lock.notify();
          // 此处判断，是为了打印完了100个数字后，程序能够正常结束，否则程序将一直等待下去，耗费系统资源。
          if (cur <= 100) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }
    }
  }


  // 偶数线程
  static class Task2 implements Runnable {

    @Override
    public void run() {
      while (cur < max) {
        synchronized (lock) {
          if (cur % 2 == 0) {
            System.out.println(Thread.currentThread().getName() + cur++);
          }
        }
      }
    }
  }

  // 奇数线程
  static class Task3 implements Runnable {

    @Override
    public void run() {
      while (cur < max) {
        synchronized (lock) {
          if (cur % 2 != 0) {
            System.out.println(Thread.currentThread().getName() + cur++);
          }
        }
      }
    }
  }
}

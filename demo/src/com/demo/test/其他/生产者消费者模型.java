package com.demo.test.其他;

import java.util.LinkedList;
import java.util.Queue;

public class 生产者消费者模型 {

  private static int MAX = 10;
  private static final MyBlockingQueue<String> queue = new MyBlockingQueue<>(MAX);

  public static class Producer implements Runnable {

    private String name;
    private MyBlockingQueue<String> queue;

    public Producer(String name, MyBlockingQueue<String> queue) {
      this.name = name;
      this.queue = queue;
    }

    @Override
    public void run() {
      while (true) {
        String product = "product:" + (int) (Math.random() * 100);
        try {
          Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          queue.put(product);
          System.out.println(name + "生产了商品" + product + " ,当前共有" + queue.size() + "个商品");
        } catch (Exception e) {
//            e.printStackTrace();
        }
      }
    }
  }

  public static class Consumer implements Runnable {

    private String name;
    private MyBlockingQueue<String> queue;

    public Consumer(String name, MyBlockingQueue<String> queue) {
      this.name = name;
      this.queue = queue;
    }

    @Override
    public void run() {
      while (true) {
        try {
          Thread.sleep((long) (Math.random() * 500));
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          String product = queue.take();
          System.out.println(name + "消费了商品" + product + " ,当前共有" + queue.size() + "个商品");
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
      }
    }
  }

  public static class MyBlockingQueue<T> {

    private Queue<T> queue = new LinkedList();
    private final Object LOCK = new Object();
    private int size;

    public MyBlockingQueue(int size) {
      this.size = size;
    }

    public void put(Object v) throws InterruptedException {
      synchronized (LOCK) {
        if (queue.size() >= size) {
          throw new InterruptedException("队列已满");
        }
        queue.add((T) v);
      }
    }

    public T take() throws InterruptedException {
      synchronized (LOCK) {
        if (queue.isEmpty()) {
          throw new InterruptedException("队列为空");
        }
        return queue.poll();
      }
    }

    public int size() {
      synchronized (LOCK) {
        return queue.size();
      }
    }
  }


  public static void main(String[] args) {
    new Thread(new Producer("生产者1", queue)).start();
    new Thread(new Producer("生产者2", queue)).start();
    new Thread(new Producer("生产者3", queue)).start();
    new Thread(new Consumer("消费者1", queue)).start();
    new Thread(new Consumer("消费者2", queue)).start();
    new Thread(new Consumer("消费者3", queue)).start();
    new Thread(new Producer("生产者4", queue)).start();
    new Thread(new Producer("生产者5", queue)).start();
    new Thread(new Producer("生产者6", queue)).start();
  }
}

package com.demo.test.ll;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
  
  Map<String, Integer> pathMap;
  Map<String, Runnable> callbackMap;
  
  public FileSystem() {
    this.pathMap = new HashMap<>();
    this.callbackMap = new HashMap<>();
    this.pathMap.put("", 0); // 解决空指针 !pathMap.containsKey(path.substring(0, lastSlashIndex))
  }
  
  public boolean create(String path, int value) {
    if (pathMap.containsKey(path)) {
      return false;
    }
    int lastSlashIndex = path.lastIndexOf("/");
    if (!pathMap.containsKey(path.substring(0, lastSlashIndex))) {
      return false;
    }
    pathMap.put(path, value);
    return true;
  }
  
  public Integer get(String path) {
    return pathMap.get(path);
  }
  
  public boolean set(String path, int value) {
    if (!pathMap.containsKey(path)) {
      return false;
    }
    pathMap.put(path, value);
    
    // Trigger callbacks
    String curPath = path;
//    if (callbackMap.containsKey(curPath)) {
//      callbackMap.get(curPath).run();
//    }
    while (curPath.length() > 0) {
      if (callbackMap.containsKey(curPath)) {
        callbackMap.get(curPath).run();
      }
      int lastSlashIndex = path.lastIndexOf("/");
      curPath = curPath.substring(0, lastSlashIndex);
    }
    return true;
  }
  
  public boolean watch(String path, Runnable callback) {
    if (!pathMap.containsKey(path)) {
      return false;
    }
    callbackMap.put(path, callback);
    return true;
  }
  
  
  public static void main(String[] args) {
    FileSystem sol = new FileSystem();
    sol.create("/a", 1);
    sol.create("/a/b", 2);
    System.out.println("===2===" + (int) sol.get("/a/b"));
//    sol.set("/a/b", 3);
    System.out.println("===3===" + (int) sol.get("/a/b"));
    System.out.println("===3===" + (int) sol.get("/a/b"));
    sol.create("/c", 4);
    sol.create("/c/d", 4);
    sol.create("/c/d", 5);
    System.out.println("===4===" + (int) sol.get("/c/d"));

    FileSystem finalSol = sol;
    finalSol.set("/c", 500);
    sol.watch("/c/d", new Runnable() {
      @Override
      public void run() {
//        finalSol.set("/c/d", 100);
        System.out.println("===run===" + finalSol.get("/c/d"));
      }
    });


    finalSol.set("/c/d", 100);
  }
}

package com.demo.test.airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IpToCIDR {

  public static List<String> ipToCIDR(String ip, int n) {
    long start = ipToLong(ip);
    List<String> ans = new ArrayList();
    while (n > 0) {
      int mask = Math.max(33 - bitLength(Long.lowestOneBit(start)),
          33 - bitLength(n));
      ans.add(longToIP(start) + "/" + mask);
      start += 1 << (32 - mask);
      n -= 1 << (32 - mask);
    }
    return ans;
  }

  private static long ipToLong(String ip) {
    long ans = 0;
    for (String x : ip.split("\\.")) {
      ans = 256 * ans + Integer.valueOf(x);
    }
    return ans;
  }

  private static String longToIP(long x) {
    return String.format("%s.%s.%s.%s",
        x >> 24, (x >> 16) % 256, (x >> 8) % 256, x % 256);
  }

  private static int bitLength(long x) {
    if (x == 0) {
      return 1;
    }
    int ans = 0;
    while (x > 0) {
      x >>= 1;
      ans++;
    }
    return ans;
  }

  /**
   * https://zhuanlan.zhihu.com/p/35541808
   */
  public static void main(String[] args) {
//    Collections.shuffle(null);
    List<String> result = ipToCIDR("255.0.0.7", 10);
    for (String s : result) {
      System.out.println(s);
    }
  }
}

package com.demo.test.airbnb;

import java.util.*;

public class FlightTicketList {
  public static int findCheapestPrice(int[][] flights, int src, int dst, int k) {
    Map<Integer, Map<Integer, Integer>> prices = new HashMap<Integer, Map<Integer, Integer>>();
    for (int[] f : flights) {
      if (!prices.containsKey(f[0])) {
        prices.put(f[0], new HashMap<>());
      }
      prices.get(f[0]).put(f[1], f[2]);
    }
    
    Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
    pq.add(new int[]{0, src, k + 1});
    while (!pq.isEmpty()) {
      int[] top = pq.remove();
      int price = top[0];
      int city = top[1];
      int stops = top[2];
      if (city == dst) {
        return price;
      }
      if (stops > 0) {
        Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
        for (int a : adj.keySet()) {
          pq.add(new int[]{price + adj.get(a), a, stops - 1});
        }
      }
    }
    return -1;
  }

//  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//    int notFound = -1;
//    if (src > n || dst > n) {
//      return notFound;
//    }
//    int inf = Integer.MAX_VALUE / 2;
//    int[] ds = new int[n];
//    Arrays.fill(ds, inf);
//    ds[src] = 0;
//
//    int price = ds[dst];
//    for (int k = 0; k <= K; k++) {
//      int[] nds = new int[n];
//      Arrays.fill(nds, inf);
//      for (int[] e : flights) {
//        nds[e[1]] = Math.min(nds[e[1]], ds[e[0]] + e[2]);
//      }
//      ds = nds;
//      price = Math.min(price, ds[dst]);
//    }
//    return (price == inf) ? notFound : price;
//  }
  
  /**
   * There are n cities connected by m flights.
   * Each fight starts from city u and arrives at v with a price w.
   * <p>
   * Now given all the cities and flights, together with starting city src and the destination dst,
   * your task is to find the cheapest price from src to dst with up to k stops.
   * If there is no such route, output -1.
   * <p>
   * Example 1:
   * Input:
   * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
   * src = 0, dst = 2, k = 1
   * Output: 200
   * <p>
   * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
   * The size of flights will be in range [0, n * (n - 1) / 2].
   * The format of each flight will be (src, dst, price).
   * The price of each flight will be in the range [1, 10000].
   * k is in the range of [0, n - 1].
   * There will not be any duplicated flights or self cycles.
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
    int result = findCheapestPrice(3, flights, 0, 2, 1);
    System.out.println("reuslt=" + result);
  }
  
  public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    
    int notFound = -1;
    if (src > n || dst > n) {
      return notFound;
    }
    
    int fill = Integer.MAX_VALUE / 2;
    int[] prices = new int[n];
    Arrays.fill(prices, fill);
    prices[src] = 0;
    int cheapestPrice = prices[dst];
    
    for (int i = 0; i <= K; i++) {
      int[] tmpPrice = new int[n];
      Arrays.fill(tmpPrice, fill);
      for (int[] flight : flights) {
        tmpPrice[flight[1]] = Math.min(tmpPrice[flight[1]], prices[flight[0]] + flight[2]);
      }
      prices = tmpPrice;
      cheapestPrice = Math.min(cheapestPrice, prices[dst]);
    }
    return cheapestPrice == fill ? notFound : cheapestPrice;
  }
}

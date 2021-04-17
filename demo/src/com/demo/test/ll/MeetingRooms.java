package com.demo.test.ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRooms {
  private static List<Interval> getAvailableIntervals(Interval[] intervals) {
    int min = Integer.MAX_VALUE;
    int max = 0;
    for (Interval interval : intervals) {
      min = Math.min(min, interval.start);
      max = Math.max(max, interval.end);
    }
    int[] times = new int[max];
    Arrays.fill(times, 1);
    Arrays.fill(times, 0, min, -1);
    for (Interval interval : intervals) {
      Arrays.fill(times, interval.start, interval.end, -1);
    }
    
    List<Interval> result = new ArrayList<>();
    for (int i = min; i < times.length; i++) {
      if (times[i] == 1) {
        Interval interval = new Interval();
        interval.start = i;
        for (int j = i + 1; j < times.length; j++) {
          if (times[j] == 1) {
            continue;
          } else {
            interval.end = j;
            result.add(interval);
            Arrays.fill(times, i, j, -1);
            break;
          }
        }
      }
    }
    
    return result;
  }
  
  public static class Interval {
    int start;
    int end;
    
    public Interval() {
    }
    
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
  
  /**
   * Input is a number of meetings (start_time, end_time)。
   * Output is a number of time intervals (start_time, end_time), where there is no meetings.
   * <p>
   * For exmaple, input is [[1, 3], [6, 7]], [[2, 4]], [[2, 3], [9, 12]] ]
   * <p>
   * output [[4, 6], [7, 9]]
   *
   * @param args
   */
  public static void main(String[] args) {
    Interval[] intervals = new Interval[]{new Interval(1, 3), new Interval(6, 7), new Interval(2, 4), new Interval(2, 3), new Interval(9, 12)};
    List<Interval> result = getAvailableIntervals(intervals);
    for (Interval interval : result) {
      System.out.println(interval.start + " " + interval.end);
    }
  }
}

package com.demo.test.airbnb;

import java.util.ArrayList;
import java.util.List;

public class CSVParse {

  public static String parseCSV(String str) {
    if (str == null || str.isEmpty()) {
      return null;
    }
    List<String> res = new ArrayList<>();
    StringBuilder curr = new StringBuilder();
    boolean inQuote = false;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (inQuote) {
        if (c == '\"') {
          if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {
            curr.append("\"");
            i++;
          } else {
            inQuote = false;
          }
        } else {
          curr.append(c);
        }
      } else {
        if (c == '\"') {
          inQuote = true;
        } else if (c == ',') {
          res.add(curr.toString());
          curr.setLength(0);
        } else {
          curr.append(c);
        }
      }
    }
    if (curr.length() > 0) {
      res.add(curr.toString());
    }
    return String.join("|", res);
  }


  public static void main(String[] args) {
//    System.out.println(parseCSV("John,Smith,john.smith@gmail.com,Los Angeles,1"));
//    System.out.println(parseCSV("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"));
//    System.out
//        .println(parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
//    System.out.println(parseCSV("\"\"\"Alexandra Alex\"\"\""));
//    System.out.println(
//        parseCSV("\"Jane \"\"Mo\"\"\",Roberts,janer@msn.com,\"San Francisco, CA\",,BeiJing,20"));
//    String arr[] = ",,,".split(",");
//    System.out.println(arr.length);
    System.out
        .println("\"Jane \"\"Mo\"\"\",Roberts,janer@msn.com,\"San Francisco, CA\",,BeiJing,20");
    try {

      CSVRecord record1 = new CSVRecord(
          "John,Smith,john.smith@gmail.com,\"PingPong, FootBall\",notes1,BeiJing,1");
      CSVRecord record2 = new CSVRecord(
          "Jane,Roberts,janer@msn.com,music,notes2,BeiJing,20");
      CSVRecord record3 = new CSVRecord(
          "\"Jane \"\"Mo\"\"\",Roberts,janer@msn.com,\"San Francisco, CA\",,BeiJing,20");
      CSVRecord record4 = new CSVRecord(
          "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",,BeiJing,20");
      System.out.println(record1.formatOutput());
      System.out.println(record2.formatOutput());
      System.out.println(record3.formatOutput());
      System.out.println(record4.formatOutput());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static class CSVRecord {

    private String firstName;
    private String lastName;
    private String email;
    private String interests;
    private String notes;
    private String city;
    private String age;

    private String csvStr;
    private int curStart = 0;

    public CSVRecord(String str) {
      this.csvStr = str;
      this.firstName = parseNext();
      this.lastName = parseNext();
      this.email = parseNext();
      this.interests = parseNext();
      this.notes = parseNext();
      this.city = parseNext();
      this.age = parseNext();
    }

    public String formatOutput() {
      StringBuilder sb = new StringBuilder();
      sb.append(firstName)
          .append(", ")
          .append(age)
          .append(" years old, ")
          .append("is from ")
          .append(city)
          .append(" and is interested in ")
          .append(interests)
          .append(".");
      return sb.toString();
    }

    public String parseNext() {
      int nextEnd = findNextEnd();
      String curStr = csvStr.substring(curStart, curStart + nextEnd);
      curStart += nextEnd + 1;
      return process(curStr);
    }

    private int findNextEnd() {
      String curStr = csvStr.substring(curStart);
      int index = curStr.indexOf(",");

      if (index == -1) {
        return curStr.length();
      }

      String case1 = "Jane,Roberts,janer@msn.com,music,notes2,BeiJing,20";
      boolean b1 = curStr.charAt(0) != '\"';

      String case2 = "John,,john.smith@gmail.com,PingPong,notes1,BeiJing,1";
      boolean b2 = curStr.length() >= index + 1 && curStr.charAt(index + 1) == ',';

      String case3 = "\"John\",Smith,john.smith@gmail.com,PingPong,notes1,BeiJing,1";
      boolean b3 = curStr.charAt(0) == '\"' && curStr.charAt(index - 1) == '\"';

      if (b1 || b2 || b3) {
        return index;
      }

      String case4 = "\"PingPong,FootBall\",John,Smith,john.smith@gmail.com,,notes1,BeiJing,1";
      String newStr = curStr.substring(index + 1);
      return index + newStr.indexOf('\"') + 1 + 1; // index从0开始，再往后挪一位
    }

    private String process(String str) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < str.length(); i++) {

        boolean b1 = str.charAt(i) != '\"';
        // "Jane ""Mo""",Roberts,janer@msn.com,"San Francisco, CA",,BeiJing,20
        String case2 = "\"Jane \"\"Mo\"\"\",Roberts,janer@msn.com,\"San Francisco, CA\",,BeiJing,20";
        boolean b2 = str.charAt(i) == '\"' && i + 1 < str.length() && str.charAt(i + 1) == '\"';
        // b3同case2
        boolean b3 = str.charAt(i) == '\"' && i + 2 < str.length() && str.charAt(i + 1) == '\"'
            && str.charAt(i + 2) == '\"';

        if (b1 || b2 && !b3) {
          sb.append(str.charAt(i));
        }
      }

      return sb.toString();
    }
  }
}

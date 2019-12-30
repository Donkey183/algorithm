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
//    String arr[] = ",,,".split(",");
//    System.out.println(arr.length);
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

  public static String parseCSV2(String str) {
    if (str == null || str.length() == 0) {
      return "";
    }
    int index = 0;
    return "";
  }

  public static int findEnd(String str) {
    return 0;
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
    private int start = 0;

    public CSVRecord(String str) {
      this.csvStr = str;
      this.firstName = parseOne();
      this.lastName = parseOne();
      this.email = parseOne();
      this.interests = parseOne();
      this.notes = parseOne();
      this.city = parseOne();
      this.age = parseOne();
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

    public String parseOne() {
      int end = findEnd();
      String curStr = csvStr.substring(start, start + end);
      start += end + 1;
      return process(curStr);
    }

    public int findEnd() {
      String curStr = csvStr.substring(start);
      int index = curStr.indexOf(",");
      if (index == -1) {
        return curStr.length();
      }
      if (curStr.charAt(index + 1) == ',') {
        return index;
      }
      if (curStr.charAt(0) == '\"' && curStr.charAt(index - 1) == '\"'
          || curStr.charAt(0) != '\"') {
        return index;
      } else {
        String newStr = curStr.substring(index +1);
        return index + newStr.indexOf('\"') + 2;
      }
    }

    public String process(String str) {
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < str.length(); i++) {
        if(str.charAt(i) == '\"') {
          if( i + 1 < str.length() && str.charAt(i+1) == '\"') {
            sb.append(str.charAt(i+1));
          }
        }else {
          sb.append(str.charAt(i));
        }
      }
      String result = sb.toString();
      if(result.length() > 2 && result.charAt(result.length()-1) == '\"' && result.charAt(result.length()-2) == '\"') {
        return result.substring(0, result.length() -1);
      }
      return result;
    }
  }
}

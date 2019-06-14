package com.demo.test.airbnb;

import java.util.ArrayList;
import java.util.List;

public class CSVParse {
  
  public static String parseCSV(String str) {
    if (str == null || str.isEmpty()) {return null;}
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
        if (c == '\"') { inQuote = true; }
        else if (c == ',') {
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
    System.out.println(parseCSV("John,Smith,john.smith@gmail.com,Los Angeles,1"));
    System.out.println(parseCSV("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"));
    System.out.println(parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
    System.out.println(parseCSV("\"\"\"Alexandra Alex\"\"\""));
  }
}

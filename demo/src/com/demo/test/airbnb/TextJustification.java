package com.demo.test.airbnb;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
  
  public static List<String> fullJustify(String[] words, int maxWidth) {
    int left = 0;
    List<String> result = new ArrayList<>();
    
    while (left < words.length) {
      int right = findRight(left, words, maxWidth);
      result.add(justify(left, right, words, maxWidth));
      left = right + 1;
    }
    
    return result;
  }
  
  private static int findRight(int left, String[] words, int maxWidth) {
    int right = left;
    int sum = words[right++].length();
    
    while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth) {
      sum += 1 + words[right++].length();
    }
    return right - 1;
  }
  
  private static String justify(int left, int right, String[] words, int maxWidth) {
    if (right - left == 0) return padResult(words[left], maxWidth);
    
    boolean isLastLine = right == words.length - 1;
    int numSpaces = right - left;
    int totalSpace = maxWidth - wordsLength(left, right, words);
    
    String space = isLastLine ? " " : new String(new char[totalSpace / numSpaces]).replace('\0', ' ');
    int remainder = isLastLine ? 0 : totalSpace % numSpaces;
    
    StringBuilder result = new StringBuilder();
    for (int i = left; i <= right; i++) {
      result.append(words[i])
          .append(space)
          .append(remainder-- > 0 ? " " : "");
    }
    return padResult(result.toString().trim(), maxWidth);
  }
  
  private static int wordsLength(int left, int right, String[] words) {
    int wordsLength = 0;
    for (int i = left; i <= right; i++) wordsLength += words[i].length();
    return wordsLength;
  }
  
  private static String padResult(String result, int maxWidth) {
    return result + new String(new char[maxWidth - result.length()]).replace('\0', ' ');
  }
  
  /**
   * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
   * <p>
   * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
   * <p>
   * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
   * <p>
   * For the last line of text, it should be left justified and no extra space is inserted between words.
   * <p>
   * For example,
   * words: ["This", "is", "an", "example", "of", "text", "justification."]
   * L: 16.
   * <p>
   * Return the formatted lines as:
   * [
   * "it is is an",
   * "example of text",
   * "justification. "
   * ]
   * Note: Each word is guaranteed not to exceed L in length.
   * <p>
   * click to show corner cases.
   * <p>
   * Corner Cases:
   * A line other than the last line might contain only one word. What should you do in this case?
   * In this case, that line should be left-justified.
   *
   * @param args
   */
//  public static void main(String[] args) {
//    List<String> result = new ArrayList<>();
//    result = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
//    for (String s : result) {
//      System.out.println(s);
//    }
//  }

  public static void main(String[] args) {
    String[] strs = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    fullJustify(strs);
    char[] chars = new char[16];
    System.out.println("success" + String.valueOf(chars) + "end");
  }

  private static List<String> fullJustify(String[] strs) {
    // Step1: 查找分割点
    List<Integer> lineList = findEnd(strs, 16);
    for(Integer i : lineList) {
      System.out.println(i);
    }

    // Step2: 填充字符串
    return null;
  }

  private static List<Integer> findEnd(String[] strs, int L) {
    List<Integer> result = new ArrayList<Integer>();
    int count = 0;
    for(int i = 0; i < strs.length; i++) {
      if(count + strs[i].length() <= L) {
        count += strs[i].length() + 1;
      } else {
        result.add(i - 1);
        count = strs[i].length();
      }
    }
   return result;
  }

  private static String fillLine(String[] strs, int L) {
    char[] line = new char[L];
    return "";
  }
}

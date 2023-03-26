package com.demo.test.其他;

public class 颜色转换 {
    public static String rgb2Hex(int r,int g,int b){
        return String.format("#%02X%02X%02X", r,g,b);
    }

    public int[] hex2RGB(String hexStr){
        if(hexStr != null && !"".equals(hexStr) && hexStr.length() == 7){
            int[] rgb = new int[3];
            rgb[0] = Integer.valueOf(hexStr.substring( 1, 3 ), 16);
            rgb[1] = Integer.valueOf(hexStr.substring( 3, 5 ), 16);
            rgb[2] = Integer.valueOf(hexStr.substring( 5, 7 ), 16);
            return rgb;
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(rgb2Hex(251, 255, 255));
    }
}

package com.demo.test.其他;

public class 二进制中1的个数 {
    /**
     * 输入一个整数 n ，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     * <p>
     * 知识点：位运算
     * 计算机的数字由二进制表示，我们平常的运算是对整个数字进行运算，但是还可以按照二进制的每一位分别进行运算。常见运算有位与、位或、移位、位异或等。
     * <p>
     * 思路：
     * 我们可以检查该数字的二进制每一位是否为1，如果遍历二进制每一位呢？可以考虑移位运算，每次移动一位就可以。至于怎么统计到1呢？我们都只知道数字1与数字相位与运算，其实只是最后一位为1就是1，最后一位为0就是0，这样我们只需要将数字1移位运算，就可以遍历二进制的每一位，再去做位与运算，结果为1的就是二进制中为1的。
     * <p>
     * 具体做法：
     * step 1：遍历二进制的32位，通过移位0-31次实现。
     * step 2：将移位后的1与数字进行位与运算，结果为1就记录一次。
     * <p>
     * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=117&tqId=37771&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj&difficulty=undefined&judgeStatus=undefined&tags=&title=
     */
    public int NumberOf1(int n) {
        int res = 0;
        //遍历32位
        for (int i = 0; i < 32; i++) {
            //按位比较
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }
}

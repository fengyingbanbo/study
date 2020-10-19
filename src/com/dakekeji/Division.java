package com.dakekeji;

/**
 * 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */

public class Division {
    /**
     *  减法超时
     * @param dividend
     * @param divisor
     * @return
     */
    public static  int divide(int dividend, int divisor) {

        boolean bellowZero=false;
        if(dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(dividend<0&&divisor>0){
            dividend=-dividend;           bellowZero=true;
        }
        else if(dividend>0&&divisor<0){
            divisor=-divisor;
            bellowZero=true;
        }
       else if(dividend<0&&divisor<0){
            bellowZero=false;
            dividend=-dividend;
            divisor=-divisor;
        }
        else {
            bellowZero=false;
        }
        boolean flag=true;
        int result=0;
        if(dividend==Integer.MIN_VALUE){
            if(divisor<0){
                divisor=-divisor;
            }
                if(bellowZero&&divisor>0){
                    while(flag){
                        if(dividend+divisor>0){
                            flag=false;
                        }else{
                            dividend=dividend+divisor;
                            result++;
                        }
                    }
                }
        }else {
                while (flag) {
                    if (dividend < divisor) {
                        flag = false;

                    } else {
                        dividend = dividend - divisor;
                        result++;
                    }
                }
            }
        if(bellowZero){
            return -result;
        }else {
            return result;
        }
    }

    public int divide2(int dividend, int divisor) {
        int ans = -1;
        int sign = 1;
        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }

        int origin_dividend = dividend;
        int origin_divisor = divisor;
        if (dividend > divisor) {
            return 0;
        }

        dividend -= divisor;
        while (divisor >= dividend) {
            ans = ans + ans;
            divisor += divisor;
            dividend -= divisor;
        }
        //此时我们传进的是两个负数，正常情况下，它就返回正数，但我们是在用负数累加，所以要取相反数
        int a = ans + opposite(divide(origin_dividend - divisor, origin_divisor));
        if(a == Integer.MIN_VALUE){
            if( sign > 0){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }else{
            if(sign > 0){
                return opposite(a);
            }else{
                return a;
            }
        }
    }
    public int opposite(int x) {
        return ~x + 1;
    }
    public static int divide3(int dividend, int divisor) {

        boolean negative=!((dividend>0&&divisor>0)||(dividend<0&&divisor<0));
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int result=0;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while (dividend<=divisor){
            int temp=divisor;
            int c=1;
            while(dividend-temp<=temp) {
                temp=temp<<1;
                c=c<<1;
            }
            dividend-=temp;
            result+=c;
        }
        return negative?(0-result):result;
    }
    public static void main(String[] args) {
        int result =divide3(-1,-1);
        System.out.println(result);
    }
}

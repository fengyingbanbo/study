package com.dakekeji;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstrWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        int result=0;
        HashMap<Character,Integer> tempMap =new HashMap<>();
        int temp=0;
        for(int i=0;i<s.length();i++){
                int j =tempMap.getOrDefault(s.charAt(i),-1);
                tempMap.put(s.charAt(i),i);
                temp= (temp<i-j)?(temp+1):(i-j);
                result= temp>result?temp:result;
        }
        return result;
    }

    public static void main(String[] args) {
        String inputStr ="pwaswkew";
        System.out.println(lengthOfLongestSubstring(inputStr));
    }

}

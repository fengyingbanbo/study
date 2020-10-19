package com.dakekeji;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        List<String> arrs= new ArrayList<String>();
        arrs.add("");
        arrs.add("abc");
        arrs.add("def");
        arrs.add("ghi");
        arrs.add("jkl");
        arrs.add("mno");
        arrs.add("pqrs");
        arrs.add("tuv");
        arrs.add("wxyz");
        List results= new ArrayList();
        int length =digits.length();
        List<String> newArrs= new ArrayList<>();
        if(length==0){
            return results;
        }
        backtrack(results, arrs, digits, 0, new StringBuffer());

        return results;
    }
    public void backtrack(List<String> combinations,List<String> arrs, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            Integer digit = Integer.parseInt(digits.charAt(index)+"");
            String letters = arrs.get(digit-1);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, arrs, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
    public static void main(String[] args) {
        List<String> result= new LetterCombination().letterCombinations("234");
        System.out.println(result.toString());
    }
}

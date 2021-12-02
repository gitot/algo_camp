package com.github.algo.base.solution.base;

public class S58 {

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        //find the index of the last letter of the last word in the string
        int rig = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                break;
            }else {
                rig--;
                continue;
            }
        }

        //find the index of the first letter of the last word in the string
        int left = rig;
        for (int i = left; i >= 0; i--) {
            if (chars[i] != ' ') {
                left--;
                continue;
            }else {
                break;
            }
        }
        return rig - left;
    }


    public static void main(String[] args) {
        System.out.println(new S58().lengthOfLastWord("Hello World"));
    }
}

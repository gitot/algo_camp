package com.github.algo.base.solution.base;

public class SOffer05 {
    public String replaceSpace(String s) {
        char[] charArray = s.toCharArray();
        int cnt = 0;
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == ' ') cnt++;
        }

        char[] chars = new char[cnt * 2 + len];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == ' ') {
                chars[idx++] = '%';
                chars[idx++] = '2';
                chars[idx++] = '0';
            } else {
                chars[idx++] = charArray[i];
            }
        }
        return new String(chars);
    }


    public static void main(String[] args) {
        SOffer05 s = new SOffer05();
        System.out.println(s.replaceSpace(""));
        System.out.println(s.replaceSpace(" "));
        System.out.println(s.replaceSpace("  "));
        System.out.println(s.replaceSpace("We are happy."));
        System.out.println(s.replaceSpace("We  are happy."));
    }
}

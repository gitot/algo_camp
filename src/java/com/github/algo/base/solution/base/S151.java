package com.github.algo.base.solution.base;

public class S151 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        //remove redundant space
        int len = trim(chars);

        //reverse whole valid array
        reverse(chars, 0, len - 1);

        //reverse every single word
        int p = 0;
        while (p < len) {
            int r = p;
            while (r < len && chars[r] != ' '){
                r++;
            }
            reverse(chars, p, r- 1);
            p = r + 1;
        }

        return new String(chars, 0, len);
    }

    private void reverse(char[]chars,int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }

    private int trim(char[] chars) {
        int length = chars.length;
        //skip space forward
        int left = 0;
        while (left < length && chars[left] == ' ') left++;

        //skip space backward
        int right = length - 1;
        while ( right > 0 && chars[right] == ' ') right--;

        int k = 0;
        while (left < length) {
            if (chars[left] == ' ') {
                if (left+ 1 <= right && chars[left + 1] != ' ') {
                    chars[k++] = ' ';
                }
            } else {
                chars[k++] = chars[left];
            }
            left++;
        }

        return k;
    }

    public static void main(String[] args) {
        System.out.println("S" + new S151().reverseWords(" ") + "E");
        System.out.println("S" + new S151().reverseWords("  ") + "E");
        System.out.println("S" + new S151().reverseWords("a") + "E");
        System.out.println("S" + new S151().reverseWords("ab cd") + "E");
        System.out.println("S" + new S151().reverseWords(" ab cd ") + "E");
        System.out.println(new S151().reverseWords("abcde  fghij"));

//        System.out.println(new S151().trim(new char[]{}));
//        System.out.println(new S151().trim(new char[]{ ' '}));
//        System.out.println(new S151().trim(new char[]{' ',' '}));
//        System.out.println(new S151().trim(new char[]{' ','a','b',' '}));

    }

}

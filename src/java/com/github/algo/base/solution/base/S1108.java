package com.github.algo.base.solution.base;

public class S1108 {
    public String defangIPaddr(String address) {
        String[] fras = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String fra : fras) {
            sb.append(fra);
            sb.append("[.]");
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }


    public static void main(String[] args) {
        //1.1.1.1
        new S1108().defangIPaddr("1.1.1.1");
    }
}

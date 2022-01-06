package com.github.algo.base.everyday;

import java.util.LinkedList;

public class S71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for (String s : split) {
            if (".".equals(s) || "".equals(s)) {
                continue;
            }
            if ("..".equals(s)) {
                list.pollLast();
                continue;
            }
            list.offerLast(s);
        }

        StringBuilder sb = new StringBuilder();
        do {
            sb.append("/");
            String s = list.pollFirst();
            if (null != s) {
                sb.append(s);
            }
        } while (list.size() > 0);

        return sb.toString();
    }
}

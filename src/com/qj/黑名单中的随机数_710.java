package com.qj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author qinjian
 */
public class 黑名单中的随机数_710 {

    Random ran = new Random();
    private List<Integer> whitelist;

    public 黑名单中的随机数_710(int n, int[] blacklist) {

        int length = n - blacklist.length;

        whitelist = new ArrayList<>(length);

        for (int i = 0; i < n; i++) {
            boolean falg = true;
            for (int j = 0; j < blacklist.length; j++) {
                if (blacklist[j] == i) {
                    falg = false;
                    break;
                }
            }
            if (falg) {
                whitelist.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] blacklist = {4, 8, 9};
        黑名单中的随机数_710 solution = new 黑名单中的随机数_710(10, blacklist);

        int pick = solution.pick();
        System.out.println(pick);

    }

    public int pick() {
        return whitelist.get(ran.nextInt(whitelist.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
package com.qj.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {

    Random ran = new Random();
    private List<Integer> whitelist;

    public Solution(int n, int[] blacklist) {

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
        Solution solution = new Solution(10, blacklist);

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
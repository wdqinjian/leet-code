package com.qj.top;

/**
 * @author qinjian
 */
public class 实现strStr_28 {
    
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }

        return -1;
    }
}
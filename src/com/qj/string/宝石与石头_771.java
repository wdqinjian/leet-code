package com.qj.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 771. 宝石与石头
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 *
 * @author qinjian
 */
public class 宝石与石头_771 {

    public int numJewelsInStones(String jewels, String stones) {
        int len = jewels.length();
        int[] type = new int[256];
        for (int i = 0; i < len; i++) {
            // 记录宝石类型小标对应的值是 1，  不是宝石的就是0
            type[jewels.charAt(i)] = 1;
        }
        int ans = 0;
        len = stones.length();
        for (int i = 0; i < len; i++) {
            ans += type[stones.charAt(i)];
        }
        return ans;
    }

    public int numJewelsInStones2(String jewels, String stones) {

        int jLength = jewels.length();
        List<Character> list = new ArrayList<>(jLength);
        for (int i = 0; i < jLength; i++) {
            list.add(jewels.charAt(i));
        }

        int length = stones.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (list.contains(stones.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}
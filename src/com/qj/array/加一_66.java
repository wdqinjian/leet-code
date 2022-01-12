package com.qj.array;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author qinjian
 */
public class 加一_66 {

    public static void main(String[] args) {
        加一_66 solution = new 加一_66();
        int[] digits = {9, 9, 9, 9};
        int[] ints = solution.plusOne(digits);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }

    }

    public int[] plusOne(int[] digits) {

        /**
         * 当我们对数组 digits 加一时，我们只需要关注 digits 的末尾出现了多少个 99 即可。我们可以考虑如下的三种情况：
         *
         * 如果 digits 的末尾没有 9，例如 [1, 2, 3]，那么我们直接将末尾的数加一，得到 [1, 2, 4] 并返回；
         *
         * 如果 digits 的末尾有若干个 9，例如 [1, 2, 3, 9, 9]，那么我们只需要找出从末尾开始的第一个不为 99 的元素，即 3，将该元素加一，得到 [1, 2, 4, 9, 9]
         * 。随后将末尾的 99 全部置零，得到 [1, 2, 4, 0, 0]并返回。
         *
         * 如果 digits 的所有元素都是 9，例如 [9, 9, 9, 9, 9]，那么答案为 [1, 0, 0, 0, 0, 0]。我们只需要构造一个长度比 digits 多 1 的新数组，
         * 将首元素置为 1，其余元素置为 0 即可。
         *
         */
        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                // 将第一个不为9的下标+1
                ++digits[i];
                // 将之后的位置全部改为0
                for (int j = i + 1; j < length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // 如果所有的元素均为9， 没走上面的逻辑
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}
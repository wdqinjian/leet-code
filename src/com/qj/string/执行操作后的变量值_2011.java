package com.qj.string;

/**
 * 2011. 执行操作后的变量值
 * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
 * <p>
 * ++X 和 X++ 使变量 X 的值 加 1
 * --X 和 X-- 使变量 X 的值 减 1
 * 最初，X 的值是 0
 * <p>
 * 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：operations = ["--X","X++","X++"]
 * 输出：1
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * --X：X 减 1 ，X =  0 - 1 = -1
 * X++：X 加 1 ，X = -1 + 1 =  0
 * X++：X 加 1 ，X =  0 + 1 =  1
 * 示例 2：
 * <p>
 * 输入：operations = ["++X","++X","X++"]
 * 输出：3
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * ++X：X 加 1 ，X = 0 + 1 = 1
 * ++X：X 加 1 ，X = 1 + 1 = 2
 * X++：X 加 1 ，X = 2 + 1 = 3
 * 示例 3：
 * <p>
 * 输入：operations = ["X++","++X","--X","X--"]
 * 输出：0
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * X++：X 加 1 ，X = 0 + 1 = 1
 * ++X：X 加 1 ，X = 1 + 1 = 2
 * --X：X 减 1 ，X = 2 - 1 = 1
 * X--：X 减 1 ，X = 1 - 1 = 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= operations.length <= 100
 * operations[i] 将会是 "++X"、"X++"、"--X" 或 "X--"
 *
 * @author qinjian
 */
public class 执行操作后的变量值_2011 {

    public int finalValueAfterOperations(String[] operations) {

        int length = operations.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (operations[i].equals("X++") || operations[i].equals("++X")) {
                sum++;
            } else {
                sum--;
            }
        }
        return sum;
    }

    public int finalValueAfterOperations2(String[] operations) {

        int length = operations.length;

        int num = 0;
        for (int i = 0; i < length; i++) {
            if (operations[i].contains("++")) {
                num++;
            }
        }

        return num - (length - num);
    }
}
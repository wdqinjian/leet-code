package com.qj.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qinjian
 */
public class 寻找重复的子树_652 {

    // 用来存放所有子树的内容，及其出现的子树
    Map<String, Integer> map;
    // 记录重复的子树的根节点
    List<TreeNode> count;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        count = new ArrayList<>();
        find(root);
        return count;
    }

    private String find(TreeNode root) {

        if (null == root) {
            return "@";
        }

        // 依次扫描左右子树
        String left = find(root.left);
        String right = find(root.right);
        String key = left + "" + right + "" + root.val;

        int num = map.getOrDefault(key, 0) + 1;
        // 加完存储进去
        map.put(key, num);

        if (2 == map.get(key)) {
            count.add(root);
        }

        return key;
    }

}
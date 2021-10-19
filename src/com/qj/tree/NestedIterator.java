package com.qj.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qinjian
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> cur;
    private List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>();
        build(nestedList);
        cur = list.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }


    private void build(List<NestedInteger> nestedList) {

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                // 如果不是则说明是列表， 此处也不用判空
                build(nestedInteger.getList());
            }
        }
    }

}
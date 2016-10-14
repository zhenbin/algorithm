package com.zhenbin.lzb.leetcode;

import java.util.*;

/**
 * Created by melon on 16/10/9.
 */
public class L381 {
    private Map<Integer, Integer> map;
    private List<Integer> vals;
    private Random random;

    /** Initialize your data structure here. */
    public L381() {
        map = new HashMap<Integer, Integer>();
        vals = new ArrayList<Integer>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            vals.add(val);
            map.put(val, vals.size()-1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int position = map.get(val);
            map.remove(val);
            //remove from arraylist
            //bug: didn't update the position of the last val.
            if (position != vals.size() - 1) {
                vals.set(position, vals.get(vals.size()-1));
                map.put(vals.get(position), position);
            }
            vals.remove(vals.size()-1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}

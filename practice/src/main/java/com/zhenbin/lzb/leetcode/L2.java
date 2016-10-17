package com.zhenbin.lzb.leetcode;

/**
 * Created by zhenbin.lzb on 2016/10/15.
 */
public class L2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addOther = 0;
        ListNode result = new ListNode(0), rear = result;
        while (l1 != null || l2 != null || addOther > 0) {
            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + addOther;
            if (sum > 9) {
                rear.next = new ListNode(sum - 10);
                addOther = 1;
            } else {
                rear.next = new ListNode(sum);
                addOther = 0;
            }
            rear = rear.next;
        }
        return result.next;
    }
}

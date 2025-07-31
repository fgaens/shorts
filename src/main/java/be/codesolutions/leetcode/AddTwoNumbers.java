package be.codesolutions.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        var result = AddTwoNumbers.addTwoNumbers(
//                new ListNode(9, new ListNode(4, new ListNode(3, null))),
//                new ListNode(5, new ListNode(6, new ListNode(4, null))));
                new ListNode(9, null),
                new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))))))));
        AddTwoNumbers.printListNode(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calculateRecursive(l1, l2, 0);
    }

    private static ListNode calculateRecursive(ListNode l1, ListNode l2, int carry) {
        if (l1 != null || l2 != null || carry != 0) {
            int l1v = l1 == null ? 0 : l1.val;
            int l2v = l2 == null ? 0 : l2.val;

            int sum = l1v + l2v + carry;
            carry = sum / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            return new ListNode(sum % 10, calculateRecursive(l1, l2, carry));
        }
        return null;
    }

    private static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {this.val = val;}

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


/*

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 */

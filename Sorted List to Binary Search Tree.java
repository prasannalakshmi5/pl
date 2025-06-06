class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

// Definition for binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode mid = findMiddle(head);

        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head == mid ? null : head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }

    // Helper method to print the tree (level-order) with nulls
    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
    }

    public static void main(String[] args) {
        // Build linked list: -10 -> -3 -> 0 -> 5 -> 9
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        Solution sol = new Solution();
        TreeNode root = sol.sortedListToBST(head);

        System.out.print("BST (level order including nulls): ");
        sol.printTree(root);
    }
}
What does this print?
The tree nodes will be printed level-by-le
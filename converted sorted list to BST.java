class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        TreeNode root = new TreeNode(slow.val);
        if (head == slow) return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Empty list
        ListNode head1 = null;
        TreeNode bst1 = sol.sortedListToBST(head1);
        System.out.print("BST from empty list: ");
        sol.printTree(bst1);
        System.out.println();

        // Single element
        ListNode head2 = sol.createLinkedList(new int[]{10});
        TreeNode bst2 = sol.sortedListToBST(head2);
        System.out.print("BST from single element list: ");
        sol.printTree(bst2);
        System.out.println();

        // Multiple elements
        ListNode head3 = sol.createLinkedList(new int[]{-10, -3, 0, 5, 9});
        TreeNode bst3 = sol.sortedListToBST(head3);
        System.out.print("BST from multiple elements list: ");
        sol.printTree(bst3);
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

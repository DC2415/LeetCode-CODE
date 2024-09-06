class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Convert array to a set for faster lookup
        HashSet<Integer> numSet = new HashSet<>();
        for (int a : nums) {
            numSet.add(a);
        }

        // Dummy node to handle edge cases easily (e.g., removing the head node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy; // prev starts at dummy node

        // Traverse the list
        while (current != null) {
            if (numSet.contains(current.val)) {
                // Skip the current node by adjusting pointers
                prev.next = current.next;
            } else {
                // Move prev pointer if we don't skip the current node
                prev = current;
            }
            // Move to the next node
            current = current.next;
        }

        // Return the modified list, starting from the dummy's next node
        return dummy.next;
    }
}

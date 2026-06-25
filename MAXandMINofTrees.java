class Solution {
    public static int findMax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int findMin(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
}

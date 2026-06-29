class Solution {

    int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(sb.toString());
        }

        dfs(root.left, sb);
        dfs(root.right, sb);

        sb.deleteCharAt(sb.length() - 1); // backtracking
    }
}

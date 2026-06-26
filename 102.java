class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();                  // Number of nodes in current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode temp = q.poll();
                level.add(temp.val);

                if (temp.left != null)
                    q.offer(temp.left);

                if (temp.right != null)
                    q.offer(temp.right);
            }

            result.add(level);    // Add the completed level
        }

        return result;
    }
}

class Solution {

    HashMap<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        buildParent(root);

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (level == k)
                break;

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                // parent
                TreeNode par = parent.get(curr);

                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    q.offer(par);
                }
            }

            level++;
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }

    void buildParent(TreeNode root) {

        if (root == null)
            return;

        if (root.left != null) {
            parent.put(root.left, root);
            buildParent(root.left);
        }

        if (root.right != null) {
            parent.put(root.right, root);
            buildParent(root.right);
        }
    }
}

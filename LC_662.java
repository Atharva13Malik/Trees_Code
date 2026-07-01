class Solution {
    class Pair{
        TreeNode node;
        int value;
        Pair(TreeNode node,int value){
            this.node=node;
            this.value=value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
      Queue<Pair> q = new LinkedList<>();
q.offer(new Pair(root, 0));
int max=0;

while (!q.isEmpty()) {
    int size = q.size();

    int start = q.peek().value;
    int last = ((LinkedList<Pair>) q).peekLast().value;
    max=Math.max(max,last-start+1);

    for (int i = 0; i < size; i++) {
        Pair p = q.poll();

        TreeNode curr = p.node;
        int idx = p.value;

        if (curr.left != null)
            q.offer(new Pair(curr.left, 2 * idx + 1));

        if (curr.right != null)
            q.offer(new Pair(curr.right, 2 * idx + 2));
    }
}
return max;
    }
}

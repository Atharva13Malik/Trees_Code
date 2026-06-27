class Solution {
    List<Integer> result=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

    inorder(root);          // Build complete list

    return result.get(k-1); // Return answer once
}
private void inorder(TreeNode root){

    if(root==null) return;

    inorder(root.left);

    result.add(root.val);

    inorder(root.right);
}
}

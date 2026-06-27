class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null) q.add(root);

        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(i==size-1){
                    result.add(temp.val);
                }

                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }


        }
        return result;
    }
}

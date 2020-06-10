
public class KthSmallest {
    private int result = 0;
    private int count = 0;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void dfs(TreeNode root, int k)
    {
        if(root == null) return;

        dfs(root.left, k);

        if(++count ==k)
        {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new KthSmallest().kthSmallest(root, 2));
    }
}

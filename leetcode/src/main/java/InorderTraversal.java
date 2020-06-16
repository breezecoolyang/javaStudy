import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
    public void  dfs(TreeNode root, List<Integer> res) {
        if(root == null)
        {
            return;
        }
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right, res);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(root, res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;
        System.out.println(new InorderTraversal().inorderTraversal(one));

    }
}

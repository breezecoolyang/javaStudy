import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }
        queue.add(root);
        while (true) {
            ArrayList<Integer> temp = new ArrayList<>();
            LinkedList<TreeNode> levelNode = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    levelNode.add(node.left);
                }
                if (node.right != null) {
                    levelNode.add(node.right);
                }

            }
            res.add(temp);
            if(!levelNode.isEmpty()) {
                queue = levelNode;
            }else {
                break;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        root.right = twenty;
        root.left = nine;
        twenty.left = fifteen;
        twenty.right = seven;
        System.out.println(new LevelOrder().levelOrder(root));
    }
}

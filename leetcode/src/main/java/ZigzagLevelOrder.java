import java.util.*;

public class ZigzagLevelOrder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();

        if (root == null) {
            return res;
        }
        queue.add(root);
        int level = 0;
        while (true) {
            ArrayList<Integer> temp = new ArrayList<>();
            ArrayDeque<TreeNode> levelNode = new ArrayDeque<>();
            level++;
            while (!queue.isEmpty()) {
                TreeNode node;
                node = queue.pollFirst();
                temp.add(node.val);
                if (node.left != null) {
                    levelNode.add(node.left);
                }
                if (node.right != null) {
                    levelNode.add(node.right);
                }

            }
            if(level%2 == 0)
            {
                Collections.reverse(temp);
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
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }
}

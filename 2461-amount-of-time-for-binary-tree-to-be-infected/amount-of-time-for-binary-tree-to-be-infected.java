import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public TreeNode getNode(TreeNode root, int start) {
        if (root == null) return null;
        if (root.val == start) return root;
        TreeNode left = getNode(root.left, start);
        TreeNode right = getNode(root.right, start);
        return (left == null) ? right : left;
    }

    public void preorder(TreeNode root, Map<TreeNode, TreeNode> p) {
        if (root == null) return;
        if (root.left != null) p.put(root.left, root);
        if (root.right != null) p.put(root.right, root);
        preorder(root.left, p);
        preorder(root.right, p);
    }

    public int amountOfTime(TreeNode root, int start) {
        TreeNode node = getNode(root, start);
        Map<TreeNode, TreeNode> p = new HashMap<>();
        preorder(root, p);

        // BFS
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> v = new HashMap<>();
        q.add(node);
        v.put(node, 0);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            int level = v.get(temp);

            if (temp.left != null && !v.containsKey(temp.left)) {
                q.add(temp.left);
                v.put(temp.left, level + 1);
            }
            if (temp.right != null && !v.containsKey(temp.right)) {
                q.add(temp.right);
                v.put(temp.right, level + 1);
            }
            if (p.containsKey(temp) && !v.containsKey(p.get(temp))) {
                q.add(p.get(temp));
                v.put(p.get(temp), level + 1);
            }
        }

        int maxTime = -1;
        for (int level : v.values()) {
            maxTime = Math.max(maxTime, level);
        }

        return maxTime;
    }
}

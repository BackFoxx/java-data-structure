package src.index.node;

public class TreeNode {
    public Comparable key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Comparable newKey) {
        this.key = newKey;
        left = right = null;
    }

    public TreeNode(Comparable key, TreeNode left, TreeNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

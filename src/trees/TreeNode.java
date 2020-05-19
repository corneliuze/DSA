package trees;

public class TreeNode {
    int val;
    int height;
    TreeNode left;
    TreeNode right;

    public static TreeNode newInstance(int val) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = val;
        treeNode.height = 1;
        treeNode.left = null;
        treeNode.right = null;
        return treeNode;
    }
}

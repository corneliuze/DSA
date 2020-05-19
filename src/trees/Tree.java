package trees;

import java.util.*;

public class Tree {
    //1,2,2,3,4,4,3]
    List<Integer> values = new ArrayList<>();

    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = null;
        root = tree.insert(1, root);
        root = tree.insert(2, root);
        root = tree.insert(2, root);
        root = tree.insert(3, root);
        root = tree.insert(4, root);
        root = tree.insert(4, root);
        root = tree.insert(3, root);
        System.out.println("the maximum height of the tree is : " + tree.maxHeight(root));
        System.out.println("is the tree symmetric : " + tree.isSymmetric(root));




    }

    public Tree() {

    }

    //insert
    public TreeNode insert(int val, TreeNode root) {
        TreeNode newTree = TreeNode.newInstance(val);
        TreeNode tempRoot = root;
        if (root == null) {
            root = newTree;
            return root;
        }
        TreeNode current = root, parent = null;

        while (current != null) {
            parent = current;
            if (newTree.val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        // if the value of the parent is less than the value of the new node push to the right
        if (parent.val < newTree.val) {
            parent.right = newTree;
        } else {
            parent.left = newTree;
        }
        //why are we returning tempRoot? because root will be null cos of the while loop.
        return tempRoot;
    }

    //find
    public TreeNode find(int key, TreeNode root) {
        TreeNode current = root;
        while (current.val != key) {
            if (current.val < key) {
                current = current.right;
            } else {
                current = current.left;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    //height
    public int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1 ;
    }


    //pre order --node left right
    public List<Integer> preOrder(TreeNode root) {
        if (root == null) return null;
        values.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return values;
    }

    //inorder --left node right
    public List<Integer> inOrder (TreeNode root) {
        if (root == null) return null;
        inOrder(root.left);
        values.add(root.val);
        inOrder(root.right);
        return values;
    }

    //post order -- left right node
    public List<Integer> postOrder(TreeNode root) {
        if (root == null) return null;
        postOrder(root.left);
        postOrder(root.right);
        values.add(root.val);
        return values;
    }

    //level order
    public List<Integer> levelOrder(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            values.add(current.val);
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
        return values;
    }

    //symmetric

    public boolean isSymmetric(TreeNode root) {
       return isMirror(root, root);
    }
        public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
         return (node1.val == node2.val) &&
                 isMirror(node1.left, node2.right)
                 && isMirror(node1.right, node2.left);
    }

    //path sum
    public boolean isPathSum(TreeNode root, int sum) {
          return  false;
    }
    //lowest common ancestor
    public TreeNode lca(TreeNode root) {

        return null;
    }
}

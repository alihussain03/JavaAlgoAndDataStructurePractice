package Grokking.Recursion.Medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/* covers two problems, first related to the insertNode and second is Inorder traversal (left tree first)*/
public class InsertTreeNode {
    TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.val) root.left = insert(root.left, value);
        else if (value > root.val) root.right = insert(root.right, value);
        return root;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorder(node.left, result);
            result.add(node.val);
            inorder(node.right, result);
        }
    }

    public static void main(String[] args) {
        // Example inputs
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int[] values = {5, 4, 2};

        InsertTreeNode bstInsertion = new InsertTreeNode();

        // Insert nodes into the BST
        for (int value : values) {
            root = bstInsertion.insert(root, value);
        }

        // Print the updated BST
        System.out.println("BST After Insertion:");
        TreeNode.printBST(root);

        List<Integer> result = bstInsertion.inorderTraversal(root);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
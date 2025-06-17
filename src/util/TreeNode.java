package util;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public static void printBST(TreeNode node) {
    if (node == null) {
      return;
    }
    printBST(node.left);
    System.out.print(node.val + " ");
    printBST(node.right);
  }
}
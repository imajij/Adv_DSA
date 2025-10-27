import java.util.*;

public class BinaryTreeRev {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    System.out.println(isMirror(root.left, root.right));
    System.out.println("Total nodes: " + NoOfNodes(root));
    System.out.println("Leaf nodes: " + NoOfLeafNodes(root));
    System.out.println("Full nodes: " + NoOfFullNodes(root));

    // additional test cases for TreeHeight
    System.out.println("Tree height: " + TreeHeight(root));
  //   System.out.println("Left subtree height: " + TreeHeight(root.left));
  //   System.out.println("Single node height: " + TreeHeight(new TreeNode(10)));
  //   System.out.println("Null tree height: " + TreeHeight(null));
  // }
  }

  public static boolean isMirror(TreeNode A, TreeNode B) {
    if (A == null && B == null) return true;
    if (A == null || B == null) return false;
    return (
      A.val == B.val && isMirror(A.left, B.right) && isMirror(A.right, B.left)
    );
  }

  public static int NoOfNodes(TreeNode root) {
    if (root == null) return 0;
    return 1 + NoOfNodes(root.left) + NoOfNodes(root.right);
  }

  public static int NoOfLeafNodes(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    return NoOfLeafNodes(root.left) + NoOfLeafNodes(root.right);
  }

  public static int NoOfFullNodes(TreeNode root) {
    if (root == null) return 0;
    int count = (root.left != null && root.right != null) ? 1 : 0;
    return count + NoOfFullNodes(root.left) + NoOfFullNodes(root.right);
  }

  public static int TreeHeight(TreeNode root) {
    if (root == null) return 0;
    int leftH = TreeHeight(root.left);
    int rightH = TreeHeight(root.right);
    return 1 + Math.max(leftH, rightH);
  }

  // simple nested TreeNode class
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
  }
}

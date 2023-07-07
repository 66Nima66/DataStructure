/**
 * NIMA BAHRAMI
 * not the best way , but different than other solutions, the goal was trying to initiate Array List inside the method!
 * This is answer to LeetCOde problem for inorderTraversal
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class SolutionInorderTraverse {
    public List<Integer> inorderTraversal(TreeNode root) {
    
    List<Integer> lists = new ArrayList<>();
        if (root != null){
   
            if(root.left != null){
                lists.addAll(inorderTraversal(root.left));
                lists.add(root.val);
                lists.addAll(inorderTraversal(root.right));
            }
            else if (root.left == null && root.right == null){
                lists.add(root.val);
            }

            else if (root.left == null && root.right != null){
                lists.add(root.val);
                lists.addAll(inorderTraversal(root.right));
            }

        }

    return lists;

        }
}

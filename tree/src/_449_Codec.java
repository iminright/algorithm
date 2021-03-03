/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _449_Codec.java, v 0.1 2021年03月03日 11:38 PM wanhaofan
 */
public class _449_Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        String preorder = preorderTraversal(root);
        String inorder = inorderTraversal(root);
        return preorder + ":" + inorder;
    }

    private String inorderTraversal(TreeNode node){
        if(node == null){
            return null;
        }
        String left = inorderTraversal(node.left);
        String right = inorderTraversal(node.right);
        String str = "";
        if(left != null){
            str += left + ",";
        }
        str += node.val;
        if(right != null){
            str += "," + right;
        }
        return str;
    }

    private String preorderTraversal(TreeNode node){
        if(node == null){
            return null;
        }
        String left = preorderTraversal(node.left);
        String right = preorderTraversal(node.right);
        String str = node.val + "";
        if(left != null){
            str += "," + left ;
        }
        if(right != null){
            str += "," + right;
        }
        return str;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] strArray = data.split(":");
        String[] preorder = strArray[0].split(",");
        String[] inorder = strArray[1].split(",");
        Map<String, Integer> inorderMemo = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMemo.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1, inorderMemo);
    }

    private TreeNode buildTree(String[] preorder, int preorderRootIndex, String[] inorder, int inorderBeginIndex, int inorderEndIndex, Map<String, Integer> inorderMemo){
        if(inorderBeginIndex >= inorderEndIndex){
            return new TreeNode(Integer.valueOf(inorder[inorderBeginIndex]));
        }
        TreeNode root = new TreeNode(Integer.valueOf(preorder[preorderRootIndex]));
        int inorderRootIndex = inorderMemo.get(preorder[preorderRootIndex]);

        int leftSubTreeInorderBeginIndex = inorderBeginIndex;
        int leftSubTreeInorderEndIndex = inorderRootIndex - 1;
        int rightSubTreeInorderBeginIndex = inorderRootIndex + 1;
        int rightSubTreeInorderEndIndex = inorderEndIndex;

        int leftChildIndex = -1;
        if(inorderRootIndex - 1 >= inorderBeginIndex){
            // 说明存在左子树
            // 那 preorder[preorderRootIndex + 1]一定是左子树的root节点
            leftChildIndex = preorderRootIndex + 1;
        }

        int rightChildIndex = -1;
        if(inorderRootIndex + 1 <= inorderEndIndex){
            // 说明存在左子树
            // 那 preorder[preorderRootIndex + leftTreeNodeSize + 1]一定是右子树的root节点
            rightChildIndex = preorderRootIndex + (inorderRootIndex - inorderBeginIndex) + 1;
        }

        if(leftChildIndex != -1){
            TreeNode leftSubTree = buildTree(preorder, leftChildIndex, inorder, leftSubTreeInorderBeginIndex, leftSubTreeInorderEndIndex, inorderMemo);
            root.left = leftSubTree;
        }
        if(rightChildIndex != -1){
            TreeNode rightSubTree = buildTree(preorder, rightChildIndex, inorder, rightSubTreeInorderBeginIndex, rightSubTreeInorderEndIndex, inorderMemo);
            root.right = rightSubTree;
        }
        return root;
    }

    public static void main(String[] args) {
        _449_Codec codec = new _449_Codec();
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        TreeNode _4 = new TreeNode(4);
        _3.left = _2;
        _3.right = _4;
        _2.left = _1;
        String data = codec.serialize(_3);
        System.out.println(data);
        TreeNode root = codec.deserialize(data);
        System.out.println(root);
    }

}
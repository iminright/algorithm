/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

/**
 * @author wanhaofan
 * @version _437_PathSum.java, v 0.1 2021年03月03日 8:52 PM wanhaofan
 */
public class _437_PathSum {

    public static int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int result = 0;
        result += traverse(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return result;
    }

    private static int traverse(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count++;
        }
        int r1 = traverse(root.left, sum - root.val);
        int r2 = traverse(root.right, sum - root.val);
        return count + r1 + r2;
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _m2 = new TreeNode(-2);
        TreeNode _m3 = new TreeNode(-3);
        TreeNode _1_1 = new TreeNode(1);
        TreeNode _3 = new TreeNode(3);
        TreeNode _m2_1 = new TreeNode(-2);
        TreeNode _m1 = new TreeNode(-1);

        _1.left = _m2;
        _1.right = _m3;
        _m2.left = _1_1;
        _m2.right = _3;
        _m3.left = _m2_1;
        _1_1.left = _m1;
        System.out.println(pathSum(_1, 3));
    }

}
/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _337_Rob.java, v 0.1 2021年03月01日 9:17 PM wanhaofan
 */
public class _337_Rob {

    static Map<String, Integer> memo = new HashMap<>();

    public static int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(rob(root, true), rob(root, false));
    }

    private static int rob(TreeNode node, boolean canRob){
        if(node == null){
            return 0;
        }
        if(canRob){
            return node.val + robWithCache(node.left, false) + robWithCache(node.right, false);
        }else{
            int robLeft = robWithCache(node.left, true);
            int notRobLeft = robWithCache(node.left, false);
            int robRight = robWithCache(node.right, true);
            int notRobRight = robWithCache(node.right, false);
            return Math.max(Math.max(robLeft + robRight, robLeft + notRobRight), Math.max(notRobLeft + robRight, notRobLeft + notRobRight));
        }
    }

    private static int robWithCache(TreeNode node, boolean canRob){
        if(node != null){
            String cacheKey = node.toString() + canRob;
            if(memo.get(cacheKey) != null){
                return memo.get(cacheKey);
            }else{
                int robAmount = rob(node, canRob);
                memo.put(cacheKey, robAmount);
                return robAmount;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3_1 = new TreeNode(3);
        TreeNode _3_2 = new TreeNode(3);
        TreeNode _1 = new TreeNode(1);

        _3.left = _2;
        _3.right = _3_1;
        _3_1.right = _1;
        _2.right = _3_2;


        System.out.println(rob(_3));
    }

}
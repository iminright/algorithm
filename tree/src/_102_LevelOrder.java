/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _102_LevelOrder.java, v 0.1 2021年02月21日 1:01 PM wanhaofan
 */
public class _102_LevelOrder {

    static Map<Integer, List<Integer>> levelListMemo = new HashMap<>();
    static Map<Integer, Boolean> levelAlreadyAddToResult = new HashMap<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        preOrder(root, result, 0);
        return result;
    }

    /**
     * 前序遍历解决,使用集合存储
     * _102_LevelOrder_BFS 使用BFS解决,层序遍历是BFS的一个使用场景,树也是图,在遍历的时候不要忘记使用BFS
     * @param node
     * @param list
     * @param level
     */
    public static void preOrder(TreeNode node, List<List<Integer>> list, Integer level){
        if(node == null){
            return;
        }
        List<Integer> currentLevelList = null;
        if(levelListMemo.get(level) == null){
            currentLevelList = new ArrayList<>();
            levelListMemo.put(level, currentLevelList);
        }else{
            currentLevelList = levelListMemo.get(level);
        }
        currentLevelList.add(node.val);
        if(levelAlreadyAddToResult.get(level) == null){
            list.add(currentLevelList);
            levelAlreadyAddToResult.put(level, true);
        }
        preOrder(node.left, list, level + 1);
        preOrder(node.right, list,level + 1);
    }

    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _9 = new TreeNode(9);
        TreeNode _20 = new TreeNode(20);
        TreeNode _15 = new TreeNode(15);
        TreeNode _7 = new TreeNode(7);
        _3.left = _9;
        _3.right = _20;
        _20.left = _15;
        _20.right = _7;
        levelOrder(_3);
    }


}
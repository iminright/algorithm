/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _971_FlipMatchVoyage.java, v 0.1 2021Äê03ÔÂ31ÈÕ 9:22 PM wanhaofan
 */
public class _971_FlipMatchVoyage {

    int index = -1;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> flipNodeList = new ArrayList<>();
        if(!flipMatch(root, voyage, flipNodeList)){
            flipNodeList.clear();
            flipNodeList.add(-1);
        }
        return flipNodeList;
    }

    private boolean flipMatch(TreeNode node, int[] voyage,  List<Integer> flipNodeList){
        if(node == null){
            return true;
        }
        index++;
        if(node.val == voyage[index]){
            //match
            if(flipMatch(node.left, voyage, flipNodeList)){
                return flipMatch(node.right, voyage, flipNodeList);
            }else{
                TreeNode leftTemp = node.left;
                node.left = node.right;
                node.right = leftTemp;
                flipNodeList.add(node.val);
                index--;
                if(flipMatch(node.left, voyage, flipNodeList)){
                    return flipMatch(node.right, voyage, flipNodeList);
                }
            }
        }
        return false;
    }



}
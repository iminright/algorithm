/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _46_Permute_1.java, v 0.1 2021年04月10日 8:37 PM wanhaofan
 */
public class _46_Permute_1 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return result;
        }
        boolean[] used = new boolean[length];
        backtrack(nums, used, 0, new LinkedList<>());
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, int depth, List<Integer> pathList){
        if(depth == nums.length){
            result.add(new ArrayList<>(pathList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            // 设置状态 pathList & used
            pathList.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, depth + 1, pathList);
            // 重置状态
            pathList.remove(depth);
            used[i] = false;
        }

    }

}
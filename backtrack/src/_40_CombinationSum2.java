/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.*;

/**
 * @author wanhaofan
 * @version _40_CombinationSum2.java, v 0.1 2021Äê04ÔÂ11ÈÕ 8:16 PM wanhaofan
 */
public class _40_CombinationSum2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, target, 0, used, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int begin, boolean[] used, ArrayDeque<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, used, path);
            path.removeLast();
            used[i] = false;
        }

    }

}
/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wanhaofan
 * @version _39_CombinationSum.java, v 0.1 2021��04��11�� 7:19 PM wanhaofan
 */
public class _39_CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int begin, ArrayDeque<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        // ���path������˳����� 2->2->3 �� 2->3->2 ����ͬһ������Ҫ�á�begin��������֦��
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }

}
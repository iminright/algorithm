/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * �������п��ܵĽ��˵���Ǹ������е����У�����������Ҫ��used��������ʾ�Ѿ�ʹ������ЩԪ��
 *
 * @author wanhaofan
 * @version _46_Permute_1.java, v 0.1 2021��04��10�� 8:37 PM wanhaofan
 */
public class _46_Permute_2 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, 0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int nums[], boolean[] used, int depth, ArrayDeque<Integer> path){
        if(nums.length == depth){
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, depth + 1, path);
            used[i] = false;
            path.removeLast();
        }
    }

}
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
 * @version _47_PermuteUnique.java, v 0.1 2021��04��11�� 6:12 PM wanhaofan
 */
public class _47_PermuteUnique {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return result;
        }
        Arrays.sort(nums);
        boolean[] usedInPath = new boolean[length];
        backtrack(nums, usedInPath, 0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int nums[], boolean[] usedInPath, int depth, ArrayDeque<Integer> pathList){
        if(nums.length == depth){
            result.add(new ArrayList<>(pathList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(usedInPath[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !usedInPath[i - 1]) {
                // ����usedInPath��������Ϊ���ǰһ���ڵ�û����·����ʹ�ù����������ֿ���
                // 1.i-1�ڵ�ոձ������ˣ�����i==i-1��˵��i�ڵ�Ľ������i-1һ�£���Ҫ����֦��
                // 2.i-1�ڵ���ȫû��ʹ�ù���Ҳ������֦����
                // 3.i�ڵ�û�б�ʹ�ù�������i!=i-1����������Ҫ����֦��
                continue;
            }
            pathList.add(nums[i]);
            usedInPath[i] = true;
            backtrack(nums, usedInPath, depth + 1, pathList);
            pathList.removeLast();
            usedInPath[i] = false;
        }
    }

    public static void main(String[] args) {
        _47_PermuteUnique main = new _47_PermuteUnique();
        int[] nums = new int[]{1,2,1};
        System.out.println(main.permuteUnique(nums));
        //[[1, 2, 1], [1, 1, 2], [2, 1, 1]]
    }

}
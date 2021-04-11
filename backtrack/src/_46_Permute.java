/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _46_Permute.java, v 0.1 2021��04��10�� 8:37 PM wanhaofan
 */
public class _46_Permute {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());
        return result;
    }

    private void backtrack(int[] nums, List<Integer> pathList){
        if(pathList.size() == nums.length){
            // ����Ҷ�ӽڵ�
            result.add(new ArrayList<>(pathList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(pathList.contains(nums[i])){
                // nums���������Ѿ��еĽڵ㣬Ϊ�˱����ظ������Ҫ�ų���
                continue;
            }
            // ����ӵ�pathList�У���Ϊ·����һ����
            pathList.add(nums[i]);
            backtrack(nums, pathList);
            pathList.remove(pathList.size() - 1);
        }
    }

}
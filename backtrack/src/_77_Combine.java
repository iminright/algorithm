/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanhaofan
 * @version _77_Combine.java, v 0.1 2021Äê04ÔÂ12ÈÕ 10:31 PM wanhaofan
 */
public class _77_Combine {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n , 0, k ,0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int n, int depth, int k, int begin, ArrayDeque<Integer> path){
        if(depth == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            backtrack(n, depth + 1, k, i + 1, path);
            path.removeLast();
        }
    }

}
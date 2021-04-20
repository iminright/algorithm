/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _96_NumTrees_1.java, v 0.1 2021Äê04ÔÂ20ÈÕ 10:46 PM wanhaofan
 */
public class _96_NumTrees_1 {

    Map<Integer, Integer> memo = new HashMap<>();

    public int numTrees(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        if(memo.get(n) != null){
            return memo.get(n);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += numTrees(i) * numTrees(n - i - 1);
        }
        memo.put(n, result);
        return result;
    }

}
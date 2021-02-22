/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanhaofan
 * @version _96_NumTrees.java, v 0.1 2021年02月16日 9:54 AM wanhaofan
 */
public class _96_NumTrees {
    static Map<Integer, Integer> memo = new HashMap<>();

    /**
     * f(i, n)代表以i为root,max为n最多能组成的BST数量
     * f(i, n) = f(i - 1) * f(n - i - 1)
     * f(i - 1) 代表左子树能组成的不同形式BST个数
     * f(n - i - 1) 代表右子树能组成的不同形式BST个数
     *
     * basecase 当n=0时是空树,n=1时只有一种可能
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int result = 0;
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        for (int i = 0; i < n; i++) {
            result += numTrees(i) * numTrees(n - i - 1);
        }
        memo.put(n, result);
        return result;
    }

    public static int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees2(3));
    }

}
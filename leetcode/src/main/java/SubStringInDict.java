public class SubStringInDict {

    public int minDistance(int[] prices) {
        int max_k = 2;
                    int n  = prices.length;
                    int[][][] dp = new int[n][max_k + 1][2];
                    for (int i = 0; i < n; i++) {
                        for (int k = max_k; k >= 1; k--) {
                            if (i - 1 == -1) { /*处理 base case */
                    dp[0][k][0] = 0;
                    dp[0][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
// 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        System.out.println(new SubStringInDict().minDistance(new int[]{3,3,5,0,0,3,1,4}));

    }
}

public class coins {
    public static int getCoins(int n) {
        int coin[] = {1, 2, 5, 10, 20, 50, 100};

        // dp[i][j]表示用前i种硬币凑成j元的组合数
        int[][] dp = new int[8][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0; // 用0种硬币凑成i元的组合数为0
        }

        for (int i = 0; i <= 6; i++) {
            dp[i][0] = 1; // 用i种硬币凑成0元的组合数为1,所有硬币均为0个即可
        }

        for (int i = 1; i <= 7; i++) {

            for (int j = 1; j <= n; j++) {

                dp[i][j] = 0;
                for (int k = 0; k <= j / coin[i - 1]; k++) {

                    dp[i][j] += dp[i - 1][j - k * coin[i - 1]];
                }
            }
        }

        return dp[6][n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("coin numbers is " + getCoins(i));
        }

    }
}

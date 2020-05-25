public class LongSub {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxval = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                   dp[i] = dp[j] + 1;
                }
            }
            maxval = Math.max(maxval, dp[i]);
        }
        return maxval;
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {10,9,2,5,3,7,101,18 };
        System.out.println(lengthOfLIS(numbers));
    }
}

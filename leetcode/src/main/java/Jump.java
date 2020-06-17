public class Jump {
    public int jump(int[] nums) {

      int[] dp = new int[nums.length];
      for(int i=0; i< nums.length;i++)
      {
          dp[i] = Integer.MAX_VALUE;
      }
      dp[0] = 0;
      for (int i=0;i<nums.length;i++)
      {
          for (int j=0;j<i;j++)
          {
              if(nums[j] +j >=i)
              {
                  dp[i] = Math.min(dp[i], dp[j] + 1);
              }
          }
      }
      return dp[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new Jump().jump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(new Jump().jump(new int[]{3, 2, 1, 0, 4}));

    }
}

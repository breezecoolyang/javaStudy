import java.util.Map;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean increasingTripletTwo(int[] nums) {
        int a1 = Integer.MAX_VALUE, a2 = Integer.MAX_VALUE;
        for (int value : nums) {
            if (value <= a1) {
                a1 = value;
            } else if (value <= a2) {
                a2 = value;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean increasingTripletThree(int[] nums) {
        int[] f = new int[nums.length];
        int[] b = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            b[i] = nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.min(f[i - 1], nums[i]);
        }
        for (int i = nums.length - 2; i > 0; i--) {
            b[i] = Math.max(b[i + 1], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (f[i] < nums[i] && nums[i] < b[i]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{6, 4, 5, 7}));
        System.out.println(new IncreasingTriplet().increasingTripletTwo(new int[]{6, 4, 5, 7}));
        System.out.println(new IncreasingTriplet().increasingTripletThree(new int[]{6, 4, 5, 7}));
    }
}

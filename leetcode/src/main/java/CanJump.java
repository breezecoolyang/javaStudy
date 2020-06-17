public class CanJump {
    public boolean canJump(int[] nums) {
        int rightmost = nums[0];
        if (nums.length == 1) {
            return rightmost >= 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i > rightmost) {
                return false;
            }
            rightmost = Math.max(nums[i] + i, rightmost);
            if (rightmost >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new CanJump().canJump(new int[]{3, 2, 1, 0, 4}));

    }
}

import java.util.Arrays;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length ==1)
            return 0;

        for(int i=1;i< nums.length-1;i++)
        {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
            {
                return i;
            }
        }
        if(nums[0] > nums[1])
        {
            return 0;
        }
        else {
            return nums.length -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}

import java.util.Arrays;
import java.util.stream.IntStream;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int temp = 0;
        boolean found = false;
        for(int index = nums.length-2;index >=0;index--)
        {
            int minValue= Integer.MAX_VALUE;
            int swapIndex = -1;
            for(int start = index + 1; start < nums.length ; start++)
            {
                if(nums[start] > nums[index] && nums[start] < minValue)
                {
                    swapIndex = start;
                    minValue = nums[start];
                }
            }
            if(swapIndex != -1)
            {
                temp = nums[swapIndex];
                nums[swapIndex] = nums[index];
                nums[index] = temp;
                Arrays.sort(nums, index + 1, nums.length);
                found = true;
                break;
            }
        }
        if(!found)
        {
            for (int i= 0;i < nums.length /2; i++)
            {
                temp = nums[i];
                nums[i] = nums[nums.length -i -1];
                nums[nums.length -i -1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{5, 4, 3, 2, 1};
        new NextPermutation().nextPermutation(num);
        IntStream.of(num).forEach(System.out::print);
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsets {
    private List<List<Integer>> res = new ArrayList<>();

    public void swap(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void subset(int[] nums, int start, int number, List<Integer> choice) {
        if (choice.size() == number) {
            res.add(new ArrayList<>(choice));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            choice.add(nums[i]);
            //swap(nums, start, i);
            subset(nums, i + 1, number, choice);
            choice.remove(choice.size()-1);
            //swap(nums, start, i);

        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> choice = new ArrayList<>();
        for(int i=0;i<= nums.length;i++)
        {
            choice.clear();
            subset(nums, 0, i, choice);
        }
//        subset(nums, 0, 3, choice);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    List<List<Integer>> result = new ArrayList<>();
    public void dfs(int[] nums, List<Integer> leftResult, List<Integer> item) {
        if(leftResult.size() == 1)
        {
            item.add(leftResult.get(0));
            List<Integer> another = new ArrayList<>(item);
            result.add(another);
            item.remove(item.size()-1);
            return;

        }
        for(int i= 0;i< leftResult.size();i++)
        {
            if(i !=0 && leftResult.get(i).equals(leftResult.get(i-1)))
            {
                continue;
            }
            item.add(leftResult.get(i));
            int removeNumber = leftResult.get(i);
            leftResult.remove(i);
            dfs(nums, leftResult, item);
            leftResult.add(i, removeNumber);
            item.remove(item.size() -1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> leftResult = new ArrayList<>();
        for(int i=0;i < nums.length;i++)
        {
            leftResult.add(nums[i]);
        }
        dfs(nums, leftResult, new ArrayList<>());
        return result;
    }



    public static void main(String[] args) {
        List<List<Integer>> result = new Permute().permuteUnique(new int[]{1, 1, 3});
        for(List<Integer> item: result)
        {
            System.out.println(item);
        }
    }

}

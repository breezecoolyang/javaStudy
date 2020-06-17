import java.util.ArrayList;
import java.util.List;

public class SubsetsTwo {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            //针对已有的集合添加新元素
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            //将新获得的集合添加到结果集中
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
           String order1 = a + b;
           String order2 = b + a;
           return order2.compareTo(order1);

        }
    }

    public String largestNumber(int[] nums) {

        String[] strNums = new String[nums.length];
        for(int i=0;i< nums.length;i++)
        {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, new LargerNumberComparator());

        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : strNums) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;

    }


}

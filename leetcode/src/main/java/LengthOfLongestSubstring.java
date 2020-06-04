import java.util.HashSet;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> container = new HashSet<>();
        int maxLength = 0;
        int endIndex = -1;
        for(int i=0;i < s.length(); i++)
        {
            if(i !=0)
            {
                container.remove(s.charAt(i-1));
            }

            while (endIndex + 1 < s.length() && !container.contains(s.charAt(endIndex + 1)))
            {
                container.add(s.charAt(endIndex + 1));
                endIndex++;
            }
            maxLength = Math.max(container.size(), maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}

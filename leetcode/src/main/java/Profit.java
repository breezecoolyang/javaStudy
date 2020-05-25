public class Profit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maxProfit) {
                maxProfit = price - min;
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(new Profit().maxProfit(new int[]{7,1,5,3,6,4}) );
    }
}

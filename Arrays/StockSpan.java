import java.util.Stack;

public class StockSpan {
    static class Pair {
        int value;
        int consecutiveDays;

        public Pair(int v, int i) {
            value = v;
            consecutiveDays = i;
        }
    }

    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        int[] ans = new int[n];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < price.length; i++) {
            int sum = 1;
            while (!stack.isEmpty() && price[i] >= stack.peek().value)
                sum += stack.pop().consecutiveDays;

            Pair p = new Pair(price[i], sum);
            stack.push(p);
            ans[i] = sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        int price[] = { 100, 80, 60, 70, 60, 75, 85 };
        int res[] = calculateSpan(price, price.length);
        for (int i : res)
            System.out.print(i + " ");
    }
}

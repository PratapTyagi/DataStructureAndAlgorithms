import java.util.Stack;

public class ReverseAStack {

    private static void insert(Stack<Integer> stack, int val) {
        if (stack.size() == 0) {
            stack.push(val);
            return;
        }

        int temp = stack.pop();
        insert(stack, val);
        stack.push(temp);
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] input = { 0, 10, 3, 2, 1 };
        for (int i : input)
            stack.push(i);

        reverse(stack);
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");

    }
}

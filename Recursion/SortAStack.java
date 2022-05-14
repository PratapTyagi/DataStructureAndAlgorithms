import java.util.Stack;

public class SortAStack {
    static void solve(Stack<Integer> s) {
        if (s.size() == 1)
            return;

        int peekEle = s.pop();
        solve(s);
        insert(s, peekEle);
        return;
    }

    static void insert(Stack<Integer> s, int peekEle) {
        if (s.size() == 0 || s.peek() <= peekEle) {
            s.push(peekEle);
            return;
        }

        int upperBound = s.pop();
        insert(s, peekEle);
        s.push(upperBound);
        return;
    }

    static Stack<Integer> sort(Stack<Integer> s) {
        solve(s);
        return s;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 2, 32, 3, 41 };
        Stack<Integer> s = new Stack<>();

        for (int ele : arr)
            s.add(ele);

        Stack<Integer> temp = sort(s);
        for (int ele : temp)
            System.out.print(ele + " ");
    }
}

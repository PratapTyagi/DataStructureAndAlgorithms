import java.util.Stack;

public class DeleteMidElementOfStack {
    static int m = 0;

    static void solve(Stack<Integer> s, int k) {
        if (m == k) {
            s.pop();
            return;
        } else {
            int temp = s.pop();
            m += 1;
            solve(s, k);
            s.push(temp);
            return;
        }
    }

    static void deleteMid(Stack<Integer> s, int sizeOfStack) {
        int k = sizeOfStack / 2;
        solve(s, k);
    }

    public static void main(String[] args) {
        int[] ipt = { 1, 2, 3, 4, 5 };
        Stack<Integer> s = new Stack<>();

        for (int ele : ipt)
            s.push(ele);
        deleteMid(s, s.size());

        for (int ele : s)
            System.out.print(ele + " ");
    }

}
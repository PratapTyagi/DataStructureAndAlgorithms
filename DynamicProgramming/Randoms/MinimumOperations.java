public class MinimumOperations {
    static class Count {
        private int a;

        public Count(int x) {
            a = x;
        }

        public void update(int x) {
            a = x;
        }

        public int get() {
            return a;
        }
    }

    static int find(int n, Count c) {
        if (n == 0)
            return 0;
        if (n == 1) {
            c.update(c.get() + 1);
            return 1;
        }

        if (n % 2 == 0)
            n = n / 2;
        else
            n = n - 1;

        c.update(c.get() + 1);

        return find(n, c);
    }

    static int minOperation(int n) {
        Count c = new Count(0);
        find(n, c);
        return c.get();
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(minOperation(n));
    }
}
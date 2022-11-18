public class CopySetBitsInRange {
    static int setSetBit(int x, int y, int l, int r) {
        int temp;
        if (r - l + 1 == 32)
            temp = (1 << (r - l + 1)) - 1;
        else
            temp = (1 << (r - l + 1));
        temp--;
        temp = (temp << (l - 1));
        temp = temp & y;

        return x | temp;
    }

    public static void main(String[] args) {
        System.out.println(setSetBit(44, 3, 1, 5));
    }
}
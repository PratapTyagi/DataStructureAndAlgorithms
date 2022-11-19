public class ReverseBits {
    static Long reversedBits(Long n) {
        Long ans = 0L;

        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) | ((n >> i) & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reversedBits(1L));
    }
}

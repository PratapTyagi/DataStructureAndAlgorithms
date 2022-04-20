import java.util.Arrays;

public class BoxStacking {
    static class Box implements Comparable<Box> {
        int h;
        int w;
        int l;

        public Box(int ht, int wd, int len) {
            h = ht;
            w = wd;
            l = len;
        }

        @Override
        public int compareTo(Box other) {
            return other.l * other.w - this.w * this.l;
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        Box[] boxes = new Box[n * 3];
        for (int i = 0; i < n; i++) {
            boxes[3 * i] = new Box(height[i], Math.max(width[i], length[i]), Math.min(width[i], length[i]));
            boxes[3 * i + 1] = new Box(width[i], Math.max(height[i], length[i]), Math.min(height[i], length[i]));
            boxes[3 * i + 2] = new Box(length[i], Math.max(height[i], width[i]), Math.min(height[i], width[i]));
        }

        Arrays.sort(boxes);

        int[] msh = new int[3 * n];
        msh[0] = boxes[0].h;

        int max = msh[0];
        for (int i = 1; i < 3 * n; i++) {
            msh[i] = boxes[i].h;
            for (int j = 0; j < i; j++) {
                if (boxes[j].l > boxes[i].l && boxes[j].w > boxes[i].w)
                    msh[i] = Math.max(msh[i], msh[j] + boxes[i].h);
            }
            max = Math.max(max, msh[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int n = 4;
        int height[] = { 4, 1, 4, 10 };
        int width[] = { 6, 2, 5, 12 };
        int length[] = { 7, 3, 6, 32 };

        System.out.println(maxHeight(height, width, length, n));
    }
}

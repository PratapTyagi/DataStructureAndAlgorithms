// Majority Element
public class MooresVotingAlgo {
    static int majorityElement(int arr[], int n) {
        int count = 0;
        int candidate = 0;
        for (int ele : arr) {
            if (count == 0)
                candidate = ele;
            if (ele == candidate)
                count++;
            else
                count--;
        }

        count = 0;
        for (int ele : arr)
            if (ele == candidate)
                count++;

        return count > n / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        int A[] = { 3, 1, 3, 3, 2 };
        System.out.println(majorityElement(A, A.length));
    }

}
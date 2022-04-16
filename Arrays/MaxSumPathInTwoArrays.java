/*
{2,3,7,10,12}
{1,5,7,8}
Path => 1-5-7-10-12
*/
public class MaxSumPathInTwoArrays {
    static int maxPathSum(int arr1[], int arr2[]) {
        int sum1 = 0, sum2 = 0;
        int i = 0, j = 0;
        int m = arr1.length, n = arr2.length;
        int result = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                sum1 += arr1[i++];
            else if (arr1[i] > arr2[j])
                sum2 += arr2[j++];
            else {
                result += Math.max(sum1, sum2) + arr1[i];
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }

        while (i < m)
            sum1 += arr1[i++];
        while (j < n)
            sum2 += arr2[j++];

        result += Math.max(sum1, sum2);
        return result;
    }

    public static void main(String[] args) {
        int A[] = { 2, 3, 7, 10, 12 };
        int B[] = { 1, 5, 7, 8 };

        System.out.println(maxPathSum(A, B));
    }
}

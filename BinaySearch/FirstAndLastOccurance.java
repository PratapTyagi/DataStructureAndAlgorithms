public class FirstAndLastOccurance {
    private static int findLast(int[] arr, int val) {
        int n=arr.length;
        if(n == 0)
            return -1;
        if(n == 1)
            return arr[0] == val ? 0: -1;

        int low = 0, high=n-1;
        int res = -1;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] == val) {
                res = mid;
                low = mid+1;
            }
            else if (arr[mid] > val) 
                high = mid-1;
            else  
                low = mid+1;
        }

        return res;        
    }

    private static int findFirst(int[] arr, int val) {
        int n=arr.length;
        if(n == 0)
            return -1;
        if(n == 1)
            return arr[0] == val ? 0: -1;

        int low = 0, high=n-1;
        int res = -1;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] == val) {
                res = mid;
                high = mid-1;
            }
            else if (arr[mid] > val) 
                high = mid-1;
            else  
                low = mid+1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 5, 10, 10, 10, 15, 20, 20};
        int firstOccurance = findFirst(arr, 10);
        int lastOccurance = findLast(arr, 10);
        System.out.println("firstOccurance: "+firstOccurance+"");
        System.out.println("lastOccurance: "+lastOccurance+"");
    }
}

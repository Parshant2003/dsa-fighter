import java.util.Arrays;

public class MinPlatform {

    // Function to find the minimum number of platforms required at the railway station
    private static int findPlatform(int[] arr, int[] dep, int n) {
        int i = 0; // pointer for arrival array
        int j = 0; // pointer for departure array
        int maxi = Integer.MIN_VALUE; // to store the result (maximum platforms needed at any time)
        int count = 0; // keeps track of platforms needed at current time

        // Traverse both arrays until we process all arrival and departure times
        while (i < n && j < n) {
            // If next event in sorted order is arrival, increase platform count
            if (arr[i] <= dep[j]) {
                count++;   // one more platform needed
                i++;
            } else {
                count--;   // one train departed, so one less platform needed
                j++;
            }
            // Update maximum platforms needed
            maxi = Math.max(count, maxi);
        }
        return maxi;
    }

    public static void main(String[] args) {
        // Sample train arrival and departure times
        int arr[] = { 10, 12, 20 };
        int dep[] = { 20, 25, 30 };
        int n = arr.length;

        // Sort both arrays to process events in chronological order
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Print the result
        System.out.println("Minimum number of platforms required: " + findPlatform(arr, dep, n));
    }
}

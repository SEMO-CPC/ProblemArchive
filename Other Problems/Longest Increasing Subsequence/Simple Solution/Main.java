import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    // While there is still input, keep running
    while(input.hasNextInt()) {
      // Read in n and the array of numbers
      int n = input.nextInt();
      int[] arr = new int[n];
      
      for(int i = 0; i < n; i++) {
        arr[i] = input.nextInt();  
      }

      // Find the Longest Increasing
      //  Subsequence (LIS)
      System.out.println(LIS(arr, n));
    }
  }

  public static int LIS(int[] arr, int n) {
    // Start by making an array of longest lengths
    // Every value in here is the longest
    //  path that *ENDS* at that specific node
    // We also keep track of the max
    //  value to not have to check for it later
    int[] longestLengths = new int[n];
    int maxLen = -1;

    // Working from the first element to the last, we
    //  keep finding the maximum length. For the first
    //  element, this must be 1, since no other element
    //  can point to the first element. For all other
    //  elements, it is the max length for all values
    //  less than the current element's value + 1 for
    //  this element.
    for(int i = 0; i < n; i++) {
      longestLengths[i] = maxPrev(arr, i, arr[i], longestLengths) + 1;
      if(longestLengths[i] > maxLen) {
        maxLen = longestLengths[i];
      }
    }

    return maxLen;
  }

  public static int maxPrev(int[] arr, int curIndex, int val, int[] longestLengths) {
    // This function returns the maximum length value from all the previous elements.
    // Note that for a length to be considered, the value of the element must be
    //  less than the value of the current element (val)
    int max = 0;
    for(int i = 0; i < curIndex; i++) {
      if(arr[i] < val && longestLengths[i] > max) {
        max = longestLengths[i];
      }
    }
    return max;
  }
}
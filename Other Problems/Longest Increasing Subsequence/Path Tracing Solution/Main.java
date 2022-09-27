import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // This problem requires us to keep reading data
    //  until all test cases are done
    while(input.hasNextInt()) {
      // Get the number of items
      int len = input.nextInt();

      // Handle a length of 1
      if(len == 1) {
        System.out.println(1);
        System.out.println(0);
        input.nextInt();
        continue;
      }
 
      // Create an array and fill it
      int nums[] = new int[len];

      for(int i = 0; i < len; i++) {
        nums[i] = input.nextInt();
      }

      // Run the LongestIncreasingSubsequence function
      LIS(len, nums);
    }
  }

  public static void LIS(int len, int[] nums) {
    // Create two arrays, one to store best length, and
    //  one to store the previous used value
    int bestLength[] = new int[len];
    int prevUsed[] = new int[len];
    
    // Perform subproblems for all subsequences from 0 to (len-1)
    for(int i = 0; i < len; i++) {
      // Get the index of the best length from previous data
      //  that also has a value smaller than the current value
      int currVal = nums[i];
      int maxLenVal = 0;
      int maxLenIndex = -1;
  
      // Test if the number is smaller than current
      //  and if its length is better than what we have
      for(int j = 0; j < i; j++) {
        if(nums[j] < currVal && bestLength[j] > maxLenVal) {
          maxLenVal = bestLength[j];
          maxLenIndex = j;
        }
      }

      // Set the best length to bestIndex length + 1
      //  (essentially sticking this num at the end)
      // Also mark the prev index for tracing the path later
      if(maxLenIndex != -1) {
        bestLength[i] = bestLength[maxLenIndex] + 1;
      }
      else {
        bestLength[i] = 1;
      }
      prevUsed[i] = maxLenIndex;
    }

    // Now that we have the array, find the max value (by index)
    int maxLength = bestLength[0];
    int maxLengthIndex = 0;
    for(int i = 1; i < len; i++) {
      if(bestLength[i] > maxLength) {
        maxLength = bestLength[i];
        maxLengthIndex = i;
      }
    }

    // Print out the chain of corresponding number
    printChain(prevUsed, maxLengthIndex);
  }

  public static void printChain(int prevUsed[], int maxIndex) {
    // Keep track of length while working backwards, pushing
    //  each element into a stack (so we can reverse it)
    Stack<Integer> s = new Stack<>();
    int chainLength = 1;
    int currIndex = maxIndex;

    s.push(currIndex);
    
    while(prevUsed[currIndex] != -1) {
      chainLength++;
      currIndex = prevUsed[currIndex];
      s.push(currIndex);
    }

    // Print the length and chain of numbers
    System.out.println(chainLength);
    while(!s.isEmpty()) {
      System.out.printf("%d ", s.pop());
    }
    System.out.println();
  }
}
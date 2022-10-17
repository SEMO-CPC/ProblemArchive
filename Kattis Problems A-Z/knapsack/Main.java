import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    while (input.hasNextInt()) {
      int cap = input.nextInt();
      int n = input.nextInt();
      int[] vals = new int[n];
      int[] weights = new int[n];

      for (int i = 0; i < n; i++) {
        vals[i] = input.nextInt();
        weights[i] = input.nextInt();
      }

      int[][] dp = new int[n + 1][cap + 1];

      for (int curItem = 1; curItem < n + 1; curItem++) {
        for (int curCap = 1; curCap <= cap; curCap++) {
          // Start by not adding this item
          dp[curItem][curCap] = dp[curItem - 1][curCap];

          // If we can take it, see if it is better to take it
          if (curCap >= weights[curItem - 1] &&
              dp[curItem - 1][curCap - weights[curItem - 1]] + vals[curItem - 1] > dp[curItem - 1][curCap]) {
            dp[curItem][curCap] = dp[curItem - 1][curCap - weights[curItem - 1]] + vals[curItem - 1];
          }
        }
      }

      // Print the dp table

      for (int[] r : dp) {
        for (int c : r) {
          System.out.printf("%d ", c);
        }
        System.out.println();
      }

      ArrayList<Integer> elements = new ArrayList<>();
      int curItem = n;
      int curCap = cap;
      while (curItem > 0 && curCap > 0 && dp[curItem][curCap] != 0) {
        if (dp[curItem - 1][curCap] != dp[curItem][curCap]) {
          elements.add(curItem - 1);
          curCap -= weights[curItem - 1];
        }
        curItem--;
      }

      if (dp[curItem][curCap] > 1) {
        elements.add(curItem);
      }

      System.out.println(elements.size());
      for (int i : elements) {
        System.out.printf("%d ", i);
      }
      System.out.println();
    }
  }
}
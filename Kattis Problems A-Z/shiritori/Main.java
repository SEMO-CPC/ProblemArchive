// Shiritori
// Blake Bleem
// 9-19-21

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    HashSet<String> values = new HashSet<>();
    int n = input.nextInt();
    boolean player1 = false;
    String s = input.next();
    char prev_letter = s.charAt(s.length() - 1);
    values.add(s);
    for (int i = 0; i < n - 1; i++) {
      s = input.next();
      if (s.charAt(0) != prev_letter) {
        printLoser(player1);
        return;
      } else if (values.contains(s)) {
        printLoser(player1);
        return;
      } else {
        prev_letter = s.charAt(s.length() - 1);
        player1 = !player1;
        values.add(s);
      }
    }

    System.out.println("Fair Game");
  }

  public static void printLoser(boolean b) {
    if (b) {
      System.out.println("Player 1 lost");
    } else {
      System.out.println("Player 2 lost");
    }
  }
}
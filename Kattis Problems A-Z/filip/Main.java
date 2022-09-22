// Filip
// Blake Bleem
// 9-19-22


import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String a = reverse(input.next());
    String b = reverse(input.next());
    int ia = Integer.parseInt(a);
    int ib = Integer.parseInt(b);
    System.out.println(Math.max(ia, ib));
  }

  public static String reverse(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      stack.push(s.charAt(i));
    }
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }
}
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a, b;
    a = input.nextInt();
    b = input.nextInt();
    System.out.println(a > b ? "1" : "0");
  }
}
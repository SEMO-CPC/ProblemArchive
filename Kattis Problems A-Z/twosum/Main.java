import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // The Scanner is the most-used method for reading in data
    //  from the console into our program. In this case
    //  we make a Scanner object named 'input,' and tell that
    //  Scanner to read anything that comes from the console (keyboard)
    Scanner input = new Scanner(System.in);


    int a, b;
    // When reading data from the Scanner object, you can choose
    //  to read by line, or by 'token.' In our case, the token
    //  we are wanting to read is an integer, so the Scanner
    //  will keep reading until it finishes reading the integer.
    // All tokens are separated by a space character ' ', or a
    //  newline character '\n'. The Scanner will then leave the
    //  cursor at the very end of the token that it read in.
    // EXAMPLE:
    //  If the console shows: "12 33 45\n", and you read
    //   'input.nextInt()', the Scanner will return the integer 12,
    //   and the position of the Scanner will be after the 12:
    //   "12| 33 45\n"
    //      ^this represents the Scanner position, calling 'input.nextInt()'
    //       again will return 33, and the console would look like:
    //   "12 33| 45\n"

    a = input.nextInt();
    b = input.nextInt();
    System.out.println(a + b);
  }
}
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // Create a Scanner to read input from the console
    Scanner input = new Scanner(System.in);

    // Read in the next String token (it should
    //  be the word 'hey', with some number
    //  of e's in the middle)
    String hey = input.next();

    // Instead of constructing a string, we will just
    //  print out character-by-character the output
    //  of our program. To do this, we print the 'h'
    //  and print 2 'ee' for every 'e' that is in our
    //  input. The number of 'e's in the input is
    //  the [length of the string - 2] (so that we
    //  ignore the 'h' and the 'y')
    // Afterwards, we print the 'y' (and using println
    //  we also print the newline character)
    System.out.printf("h");
    for (int i = 0; i < hey.length() - 2; i++)    {
      System.out.printf("ee");
    }
    System.out.println("y");
  }
}
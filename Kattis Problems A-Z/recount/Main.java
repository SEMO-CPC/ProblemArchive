// Recount
// Blake Bleem
// 9-19-22

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    HashMap<String, Integer> hm = new HashMap<>();
    while(true) {
      String s = input.nextLine();
      if(s.equals("***")) {
        break;
      }
      else if(hm.containsKey(s)) {
        hm.replace(s, hm.get(s) + 1);
      }
      else {
        hm.put(s, 1);
      }
    }

    int max_val = 0;
    int max_count = 0;
    String max_str = "";
    for(String s : hm.keySet()) {
      if(hm.get(s) > max_val) {
        max_str = s;
        max_val = hm.get(s);
        max_count = 1;
      }
      else if(hm.get(s) == max_val) {
        max_count++;
      }
    }

    if(max_count > 1) {
      System.out.println("Runoff!");
    }
    else {
      System.out.println(max_str);
    }
  }
}
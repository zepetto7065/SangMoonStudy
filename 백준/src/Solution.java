import java.util.Scanner;

public class Solution {

    public void sol9656(int n) {
        int count = 0;

        while (n > 0) {
            if (n > 3) {
                n -= 3;
            } else {
                n -= 1;
            }
            count++;
        }

        if (count % 2 == 1) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }


}

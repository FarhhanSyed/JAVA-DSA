import java.util.*;

public class lemonadeChange {
    public static boolean lemonade(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                ten++;
                if (five == 0) {
                    return false;
                } else {
                    five--;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int[] bills = { 5, 5, 10, 10, 20 };
        System.out.println(lemonade(bills));
    }
}

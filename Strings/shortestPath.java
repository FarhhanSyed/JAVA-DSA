import java.util.*;

public class shortestPath {
    public static float getshortestPath(String str) {
        int x = 0, y = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'N')
                y++;
            else if (c == 'S')
                y--;
            else if (c == 'W')
                x--;
            else
                x++;
        }
        int X = x * x;
        int Y = y * y;
        return (float) Math.sqrt(X + Y);

    }

    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(getshortestPath(str));
    }
}
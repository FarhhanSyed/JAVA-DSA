import java.util.*;

public class sortCharac {
    public static void sort(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> it : freq.entrySet()) {
            pq.add(it);
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char ch = pq.peek().getKey();
            int fq = pq.peek().getValue();
            pq.remove();
            while (fq > 0) {
                sb.append(ch);
                fq--;
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str = "syyyeeeeyyyyddd";
        sort(str);
    }
}

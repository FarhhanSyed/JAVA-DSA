import java.util.ArrayList;

public class heap {
    static class Heapp {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1) / 2;
            while (x > 0 && arr.get(par) > arr.get(x)) {
                int tmp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, tmp);
                x = par;
                par = (x - 1) / 2;
            }
        }

        public int delete() {
            if (arr.size() == 0) {
                return -1;
            }

            int data = arr.get(0);
            int lastIdx = arr.size() - 1;

            arr.set(0, arr.get(lastIdx));
            arr.remove(lastIdx);

            heapify(0);
            return data;
        }

        public void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                int tmp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, tmp);
                heapify(minIdx);
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public void display() {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Heapp hp = new Heapp();
        hp.add(3);
        hp.add(1);
        hp.add(0);
        hp.add(7);
        hp.add(5);
        hp.display();
        hp.delete();
        hp.display();
        System.out.println(hp.peek());
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        try (ForkJoinPool forkJoinPool = ForkJoinPool.commonPool()) {
            List<Integer> list = new ArrayList<>();
            int size = 100000; // Adjust the size as needed
            for (int i = 0; i < size; i++) {
                list.add((int) (Math.random() * size)); // Random integers from 0 to size-1
            }

            System.out.println("Unsorted List:");
            System.out.println(list);

            QuickSortTask task = new QuickSortTask(list, 0, list.size() - 1);
            forkJoinPool.invoke(task);

            System.out.println("Sorted List:");
            System.out.println(list);
        }
    }
}

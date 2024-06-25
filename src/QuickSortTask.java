import java.util.List;
import java.util.concurrent.RecursiveAction;

public class QuickSortTask extends RecursiveAction {
    private final List<Integer> list;
    private int left;
    private int right;

    public QuickSortTask(List<Integer> list, int left, int right) {
        this.list = list;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int pivot = partition(list, left, right);
            QuickSortTask leftTask = new QuickSortTask(list, left, pivot - 1);
            QuickSortTask rightTask = new QuickSortTask(list, pivot + 1, right);
            invokeAll(leftTask, rightTask);
            leftTask.join();
            rightTask.join();
        }

    }

    private int partition(List<Integer> list, int left, int right) {
        int p = list.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (list.get(j) < p) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, right);
        return i + 1;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}

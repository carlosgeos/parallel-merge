public class Helper implements Runnable {
    private int arr[];
    private int start;
    private int end;
    private int thread;

    public Helper (int[] arr, int start, int end, int thread) {
	this.arr = arr;
	this.start = start;
	this.end = end;
	this.thread = thread;
    }

    public void run() {
	ParallelMergeSort.sort(arr, start, end, thread);
    }
}

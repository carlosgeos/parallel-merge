public class Helper implements Runnable {
    private int arr[];
    private int start;
    private int end;
    private int threads;

    public Helper (int[] arr, int start, int end, int threads) {
	this.arr = arr;
	this.start = start;
	this.end = end;
	this.threads = threads;
    }

    public void run() {
	ParallelMergeSort.sort(arr, start, end, threads);
    }
}

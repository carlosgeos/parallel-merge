/**
 * Carlos Requena López - 410031
 * INFO-F202. BA2
 * Projet Java
 */

import java.lang.*;
import java.util.*;
import java.util.concurrent.*;

public class ParallelMergeSort extends MergeSort {

    private static StopWatch sw = new StopWatch();

    public static void main(String args[]) {
	int maxThreads = Runtime.getRuntime().availableProcessors();
	int size = INIT_SIZE;

	System.out.println("Sequential sorting:");
	System.out.println("-------------------");
	for (int i = 0; i < 7; ++i) {
	    int[] arr = generateArray(size);
	    sw.keepTime(i);
	    MergeSort.sort(arr, 0, size - 1);
	    System.out.println("Elements: \t" + size+ "\telapsed time: " + sw.elapsedTime(i) + "\tms");
	    size *= 2;
	}

	size = INIT_SIZE;
	System.out.println("\n\nParallel sorting:");
	System.out.println("-----------------");
	for (int i = 0; i < 7; ++i) {
	    int[] arr = generateArray(size);
	    sw.keepTime(i);
	    sort(arr, 0, size - 1, maxThreads);
	    System.out.println("Elements: \t" + size+ "\telapsed time: " + sw.elapsedTime(i) + "\tms");
	    size *= 2;
	}

    }

    public static void sort(int[] arr, int start, int end, int threads) {
	// Divide and conquer, with number of processors
	// available. Algorithm structure from Cormen.
    	if (start < end) {
    	    int middle = (start + end) / 2;
	    if (threads > 1) {
		// Threaded version
		Thread leftT = new Thread(new Helper(arr, start, middle, threads / 2));
		Thread rightT = new Thread(new Helper(arr, middle + 1, end, threads / 2));
		leftT.start();
		rightT.start();
		try {
		    leftT.join();
		    rightT.join();
		} catch (InterruptedException e) {}
	    } else {
		// Sequential version
		MergeSort.sort(arr, start, middle);
		MergeSort.sort(arr, middle + 1, end);
	    }
	    // Merge everything
	    merge(arr, start, middle, end);
    	}
    }
}

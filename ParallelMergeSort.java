/**
 * Carlos Requena López - 410031
 * INFO-F202. BA2
 * Projet Java
 */

import java.lang.*;
import java.lang.reflect.Array;import java.util.*;
import java.util.concurrent.*;
import java.util.Arrays;


public class ParallelMergeSort<T extends Comparable> {

    protected static final int ORDER = 1000;
    protected static final int INIT_SIZE = 60000;

    public static void main(String args[]) {
	int size = INIT_SIZE;
	ParallelMergeSort<Integer> instance = new ParallelMergeSort<>();
	System.out.println("\n\nParallel sorting:");
	System.out.println("-----------------");

	Integer[] arr = {5, 2, 4, 3, 6, 1};
	instance.seq_merge(arr, arr.length);
	instance.display(arr);
    }

    public void seq_merge(T[] v, int size) {
	if (v.length > 1) {
	    final int half_point = size / 2;
	    T[] left = Arrays.copyOfRange(v, 0, half_point);
	    T[] right = Arrays.copyOfRange(v, half_point, size);

	    seq_merge(left, half_point);
            seq_merge(right, size - half_point);

	    System.out.println("------------------------");
	    System.out.print("I've got: ");
	    display(v);
	    System.out.println("");


	    T[] working_list = (T[]) Array.newInstance(v.getClass().getComponentType(), half_point);
	    int i = 0, j = 0, k = 0;

	    for (; i < half_point; ++i) {
		working_list[i] = v[i];
		System.out.print("w vector is: ");
		display(working_list);
	    }

            while (j < half_point && i < size) {
		//v[k++] = v[i].compareTo(working_list[j]) < 0 ? v[i++] : working_list[j++];
		if (v[i].compareTo(working_list[j]) < 0) {
		    System.out.println("Operate in v ! " + v[k] + " should equal " + v[i]);

		    v[k++] = v[i++];
		} else {
		    System.out.println("Operate with both ! " + v[k] + " in v, should equal " + working_list[j] + " in w ");
		    v[k++] = working_list[j++];
		}
		System.out.print("v: ");
		display(v);
            }

	    while (j < half_point) {
		System.out.println("Some extra work: ");
		System.out.println(v[k] + " should be " + working_list[j]);
		v[k++] = working_list[j++];
	    }
        }
    }

    public static Integer[] generateArray(int size) {
	Random randomNumber = new Random();
	Integer[] arr = new Integer[size];

	for (int i = 0; i < size; ++i) {
	    arr[i] = randomNumber.nextInt(ORDER);
	}
	//display(arr);
	return arr;
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
	    //merge(arr, start, middle, end);
    	}
    }

    public static <T> void display(T[] arr) {
    	System.out.print("[ ");
    	for (int i = 0; i < arr.length; ++i) {
    	    System.out.print(arr[i] + " ");
    	}
    	System.out.println("]");
    }
}

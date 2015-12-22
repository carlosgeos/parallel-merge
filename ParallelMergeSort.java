/**
 * Carlos Requena López - 410031
 * INFO-F202. BA2
 * Projet Java
 */

import java.util.*;
import java.lang.*;

public class ParallelMergeSort
{
    private static final int SIZE = 100;
    private static final int ORDER = 10;
    private static final int SENTINEL = ORDER + 1;

    public static void main(String args[])
    {
	int[] arr = generateArray();
	sort(arr, 0, SIZE - 1);
	System.out.println("Sorted array:");
	System.out.println("---------------");
	display(arr);
    }

    public static int[] generateArray() {
	Random randomNumber = new Random();
	int[] arr = new int[SIZE];

	for (int i = 0; i < SIZE; ++i) {
	    arr[i] = randomNumber.nextInt(ORDER);
	}

	System.out.println("Unsorted array:");
	System.out.println("---------------");
	display(arr);
	return arr;
    }

    public static void display(int[] arr) {
	System.out.print("[ ");
	for (int i = 0; i < SIZE; ++i) {
	    System.out.print(arr[i] + " ");
	}
	System.out.println("]\n");
    }

    public static void displayTemp(int[] arr, int start, int end) {
	System.out.println("temp array:\n------------\n");
	System.out.print("[ ");
	for (int i = start; i < end + 1; ++i) {
	    System.out.print(arr[i] + " ");
	}
	System.out.println("]\n");

    }

    public static void merge(int arr[], int start, int middle, int end) {
	int size1 = middle - start + 1;
	int size2 = end - middle;
	int[] left = new int[size1 + 1];
	int[] right = new int[size2 + 1];

	for (int i = 0; i < size1; ++i) left[i] = arr[start + i];
	for (int j = 0; j < size2; ++j) right[j] = arr[middle + j + 1];
	left[size1] = SENTINEL;
	right[size2] = SENTINEL;

	int i = 0; int j = 0;
	for (int k = start; k < end + 1; ++k) {
	    if (left[i] <= right[j]) {
		arr[k] = left[i]; ++i;
	    } else {
		arr[k] = right[j]; ++j;
	    }
	}
    }

    public static void sort(int[] arr, int start, int end) {
    	if (start < end) {
    	    int middle = (start + end) / 2;
    	    sort(arr, start, middle);
    	    sort(arr, middle + 1, end);
	    merge(arr, start, middle, end);
    	}
    }
}

/**
 * Carlos Requena López - 410031
 * INFO-F202. BA2
 * Projet Java
 */

import java.util.*;

public class ParallelMerge
{
    public static void main(String args[])
    {
	List<Integer> arr;
	arr = generateArray(10);
	sort(arr);

    }

    public static List<Integer> generateArray(int size) {
	Random randomNumber = new Random();
	List<Integer> arr = new ArrayList();

	for (int i = 0; i < size; ++i) {
	    arr.add(randomNumber.nextInt(100));
	}

	System.out.println("Unsorted array:");
	System.out.println("---------------");
	display(arr);
	return arr;
    }

    public static void display(List<Integer> arr) {
	ListIterator itr = arr.listIterator();
	System.out.print("[ ");
	while (itr.hasNext()) {
	    System.out.print(itr.next() + " ");
	}
	System.out.println("]\n");

    }

    // public static int[] sort(int[] arr, long size) {
    // 	if (size > 1) {
    // 	    long middle = size / 2;
    // 	    sort(arr, middle);
    // 	    sort();
    // 	}
    // }
}

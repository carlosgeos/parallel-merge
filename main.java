/**
 * Carlos Requena López - 410031
 * INFO-F202. BA2
 * Projet Java
 *
 */

import java.util.*;

public class main
{
    public static void main(String args[])
    {
	//int[] firstArray = generateArray(100);
	for (int i = 0; i < 5; i++) {
	    generateArray(50);
	}
    }

    public static ArrayList<Integer> generateArray(int size) {
	Random randomNumber = new Random();
	ArrayList<Integer> arr = new ArrayList<Integer>(50);
	ListIterator itr = arr.listIterator();

	// for (ListIterator<E> iter = list.listIterator(); iter.hasNext(); ) {
	//     E element = iter.next();
	//     // 1 - can call methods of element
	//     // 2 - can use iter.return emove() to remove the current element from the list
	//     // 3 - can use iter.add(...) to insert a new element into the list
	//     //     between element and iter->next()
	//     // 4 - can use iter.set(...) to replace the current element

	//     // ...
	// }

	for (Integer i : arr) {
	    System.out.println("asdf");

	}


	while(itr.hasNext()) {
	    itr.set(randomNumber.nextInt(100));
	    System.out.println("esaaaaaaaa");

	}
	System.out.println("Unsorted array:");
	System.out.println("---------------");
	display(arr);
	return arr;
    }

    public static void display(ArrayList<Integer> arr) {
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

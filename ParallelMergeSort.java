/**
 * Carlos Requena López - 410031
 * INFO-F202. BA2
 * Projet Java
 */

import java.lang.*;
import java.lang.reflect.Array;import java.util.*;
import java.util.concurrent.*;
import java.util.Arrays;
import java.lang.reflect.ParameterizedType;

public class ParallelMergeSort<T> {

    protected static final int ORDER = 1000;
    protected static final int INIT_SIZE = 60000;

    static Class<Integer> esetipo ;

    public static void main(String args[]) {
	int size = INIT_SIZE;
	System.out.println("\n\nParallel sorting:");
	System.out.println("-----------------");

	List<Integer> arr = new ArrayList<>(Arrays.asList(5,2,4,3,6,1));
	esetipo = Integer.class;

	seq_merge(arr, arr.size());
	display(arr);
    }

    public static <T extends Comparable<? super T>> void seq_merge(List<T> v, int size) {
	if (v.size() > 1) {
	    final int half_point = size / 2;
	    List<T> left = v.subList(0, half_point);
	    List<T> right = v.subList(half_point, size);

	    seq_merge(left, half_point);
            seq_merge(right, size - half_point);

	    System.out.println("------------------------");
	    System.out.print("I've got: ");
	    display(v);
	    System.out.println("");

	    T[] working_list = (T[]) Array.newInstance(esetipo, half_point);

	    int i = 0, j = 0, k = 0;

	    for (; i < half_point; ++i) {
		working_list[i] = v.get(i);
	    }

            while (j < half_point && i < size) {
		v.set(k++, v.get(i).compareTo(working_list[j]) < 0 ? v.get(i++) : working_list[j++]);
		// if (v.get(i).compareTo(working_list[j]) < 0) {
		//     v.set(k++, v.get(i++));
		// } else {
		//     v.set(k++, working_list[j++]);
		// }
		display(v);
            }

	    while (j < half_point) {
		v.set(k++, working_list[j++]);
	    }
        }
    }

    public static <T extends Comparable<? super T>> void display(List<T> arr) {
    	System.out.print("[ ");
	for (T number : arr)
	    System.out.print(number + " ");
    	System.out.println("]");
    }
}

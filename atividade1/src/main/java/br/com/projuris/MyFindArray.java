package br.com.projuris;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {

		if (array == null || subArray == null) {
			return -1;
		}

		int arrayLength = array.length;
		int subArrayLength = subArray.length;

		if (subArrayLength > arrayLength) {
			return -1;
		}

		if (arrayLength == 0 || subArrayLength == 0) {
			return -1;
		}

		// Solution 1
		next: for (int index = arrayLength - subArrayLength; index >= 0; index--) {
			for (int i = 0, j = index; i < subArrayLength; i++, j++) {
				if (subArray[i] != array[j]) {
					continue next;
				}
			}
			return index;
		}
		return -1;

		// Solution 2 using Collections
//		List<Integer> arrayList = IntStream.of(array).boxed().collect(Collectors.toList());
//		List<Integer> subArrayList = IntStream.of(subArray).boxed().collect(Collectors.toList());
//		return Collections.lastIndexOfSubList(arrayList, subArrayList);
	}

}

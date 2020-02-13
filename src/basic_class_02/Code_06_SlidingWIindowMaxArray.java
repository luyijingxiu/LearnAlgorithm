package basic_class_02;

import java.util.LinkedList;

public class Code_06_SlidingWIindowMaxArray {
	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<>();
		int[] res = new int[arr.length - w + 1];
		int index=0;
		for(int i=0;i<arr.length;i++) {
			while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w) {
				qmax.pollFirst();
			}
		}
		return res;
	}
}

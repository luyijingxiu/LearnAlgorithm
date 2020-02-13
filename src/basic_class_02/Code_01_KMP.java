package basic_class_02;

import java.util.Arrays;

public class Code_01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}
	
	public static int[] getNextArray_practice(char[] ms) {
		if(ms.length==1) {
			return new int[] {-1};
		}
		
		int[] next=new int[ms.length];
		next[0]=-1;
		next[1]=0;
		for(int i=2;i<next.length;i++) {
			int pre=i-1;
			while(pre>0) {
				int preNext=next[pre];
				if(ms[preNext]==ms[pre])
				{
					next[i]=preNext+1;
					break;
				}
				else
					pre=preNext;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));
		
		System.out.println(Arrays.toString(getNextArray(str.toCharArray())));
		System.out.println(Arrays.toString(getNextArray_practice(str.toCharArray())));
	}

}

package basic_class_08;

import java.util.ArrayList;
import java.util.List;

public class Utility {
	public static ListNode createListNode(int[] values){
		ListNode head=new ListNode(-1),tail=head;
		for(int i=0;i<values.length;i++){
			ListNode p=new ListNode(values[i]);
			tail.next=p;
			p.next=null;
			tail=p;
		}
		return head.next;
	}

	public static List<Integer> linkedListToList(ListNode head){
		List<Integer> array=new ArrayList<>();
		ListNode p=head;
		while(p!=null){
			array.add(p.val);
			p=p.next;
		}
		return array;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
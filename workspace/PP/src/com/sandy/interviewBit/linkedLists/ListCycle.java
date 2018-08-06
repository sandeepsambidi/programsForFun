package com.sandy.interviewBit.linkedLists;

public class ListCycle {

	public ListNode detectCycle(ListNode a) {
		ListNode slow = a;
		ListNode fast = a;
		
		while (fast!= null && fast.next != null && slow!= null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		
		if (fast == null || fast.next == null) {
			return null;
		}
		
		ListNode curr = fast.next;
		int i = 0;
		while(curr != fast) {
			i++;
			curr = curr.next;
		}
		
		while (i>0) {
			a = a.next;
			i--;
		}
		
		while (a != fast) {
			a = a.next;
			fast = fast.next;
		}
		
		return a;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListCycle is = new ListCycle();
		System.out.println(is.detectCycle(node1));
	}

}

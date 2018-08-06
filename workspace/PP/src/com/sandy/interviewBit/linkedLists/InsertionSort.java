package com.sandy.interviewBit.linkedLists;

public class InsertionSort {

	public ListNode insertionSortList(ListNode A) {
		ListNode newList = null;
		

		while (A != null) {
		    ListNode temp = A.next;
		    A.next = null;
			newList = sortedInsert(newList, A);
			A = temp;
		}
		return newList;
    }
	
	ListNode sortedInsert(ListNode start, ListNode newNode) {
		if (start == null) {
			newNode.next = null;
			return newNode;
		}
		ListNode curr = start;
		ListNode prev = null;
		while(curr != null) {
			if (newNode.val < curr.val) {
				if (prev == null) {
					newNode.next = start;
					return newNode;
				} else {
					prev.next = newNode;
					newNode.next = curr;
					return start;
				}
			}
			prev = curr;
			curr = curr.next;
		}
		prev.next = newNode;
		newNode.next = null;
		return start;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(7);
//		ListNode node4 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		//node3.next = node4;
		InsertionSort is = new InsertionSort();
		System.out.println(is.insertionSortList(node1));

	}

}

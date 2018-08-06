package com.sandy.interviewBit.linkedLists;

public class MergeSortedLists {

	ListNode merge(ListNode a, ListNode b) {
		ListNode start = null;
		ListNode currA = a;
		ListNode currB = b;
		ListNode curr = null;
		if (a == null && b== null) {
			return null;
		} else if (a == null) {
			return b;
		} else if (b == null){
			return a;
		} else {
			if (a.val <= b.val) {
				curr = a;
				start = a;
				currA = currA.next;
			} else if (b.val < a.val) {
				start = b;
				curr = b;
				currB = currB.next;
			}
			
			while (currA != null && currB != null) {
				if (currA.val <= currB.val) {
					curr.next = currA;
					curr = curr.next;
					currA = currA.next;
				} else {
					curr.next = currB;
					curr = curr.next;
					currB = currB.next;
				}
		}
		
		if(currB!= null) {
			curr.next = currB;
		} else if (currA!= null) {
			curr.next = currA;
		}
		return start;
	}
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(5);
//		ListNode node2 = new ListNode(8);
//		ListNode node3 = new ListNode(20);
		//ListNode node4 = new ListNode(4);
		//ListNode node5 = new ListNode(5);		
//		node1.next = node2;
//		node2.next = node3;
		//node3.next = node4;
		//node4.next = node5;
		
		ListNode node6 = new ListNode(4);
//		ListNode node7 = new ListNode(11);
//		ListNode node8 = new ListNode(15);
		//ListNode node9 = new ListNode(4);
//		node6.next = node7;
//		node7.next = node8;
		//node8.next = node9;
		
		MergeSortedLists mergeSortedLists = new MergeSortedLists();
		ListNode result = mergeSortedLists.merge(node1, node6);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}

package com.sandy.finals.ms;

import com.sandy.interviewBit.linkedLists.ListNode;

public class GroupSortLinkedList {

	ListNode kSort(ListNode start, int k) {
		ListNode curr = start;
		ListNode res = null;
		ListNode prevGroupEnd = null;
		while (curr != null) {
			ListNode localStart = curr;
			ListNode localEnd = null;
			int i = 0;
			while (i < k && curr != null) {
				localEnd = curr;
				curr = curr.next;
				i++;
			}
			if (localEnd != null) {
				localEnd.next = null;
			}
			
			ListNode sortedList = sort(localStart);
			if(prevGroupEnd == null) {
				res = sortedList;
				while (sortedList.next != null) {
					sortedList = sortedList.next;
				}
				prevGroupEnd = sortedList;
			} else {
				prevGroupEnd.next = sortedList;
				while (prevGroupEnd.next != null) {
					prevGroupEnd = prevGroupEnd.next;
				}
			}
		}		
		return res;
	}
	
	ListNode sort(ListNode start) {
		
		if(start == null) {
			return null;
		} 
		
		if (start.next == null) {
			return start;
		}
		ListNode slowP = start;
		ListNode fastP = start;
		
		ListNode midPrev = null;
		while (slowP != null && fastP != null && fastP.next != null) {
			midPrev = slowP;
			slowP = slowP.next;
			fastP = fastP.next.next;
		}
		
		ListNode first = start;
		ListNode second = slowP;
		if ( midPrev != null) {
			midPrev.next = null;
		}
		
		ListNode firstSorted = sort (first);
		ListNode secondSorted = sort (second);
		ListNode res = merge(firstSorted, secondSorted);
		
		return res;
	}
	
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
		GroupSortLinkedList obj = new GroupSortLinkedList();
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(8);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(9);
		ListNode node5 = new ListNode(1);	
//		ListNode node6 = new ListNode(3);
//		ListNode node7 = new ListNode(6);
//		ListNode node8 = new ListNode(7);
//		ListNode node9 = new ListNode(5);	
//		ListNode node10 = new ListNode(2);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
//		node7.next = node8;
//		node8.next = node9;
//		node9.next = node10;
		ListNode res = obj.kSort(node1,1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}

}

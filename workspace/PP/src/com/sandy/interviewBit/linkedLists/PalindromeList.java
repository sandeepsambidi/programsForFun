package com.sandy.interviewBit.linkedLists;

public class PalindromeList {

	ListNode start;
	public int lPalin(ListNode A) {
   
		start = A;
		return find(A);		
	}
	
	
	int find(ListNode curr) {
		if (curr == null) {
			return 1;
		}
		if (find(curr.next) == 1) {
			if (curr.val == start.val) {
				start = start.next;
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
		
		
	}
	
	public int lPalin1(ListNode A) {
		   
		ListNode curr = A;
		ListNode mid = A;
		ListNode prev = null;
		while (curr!= null && curr.next!= null) {
			curr = curr.next.next;
			prev = mid;
			mid = mid.next;
		}
		ListNode halfStart = mid;
		if(prev != null) {
			prev.next = null;
		}
		
		
		ListNode midRev = reverse(halfStart);
		
		while (A!= null) {
			if(A.val != midRev.val) {
				return 0;
			}
			A = A.next;
			midRev = midRev.next;
		}
		return 1;
			
	}
	
	ListNode reverse(ListNode curr) {
		ListNode prev = null;
		while (curr!= null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		//ListNode node2 = new ListNode(2);
		//ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(3);
		
		//node1.next = node2;
		//node2.next = node3;
//		node3.next = node4;

		PalindromeList palindromeList = new PalindromeList();
		System.out.println(palindromeList.lPalin1(node1));
	}

}


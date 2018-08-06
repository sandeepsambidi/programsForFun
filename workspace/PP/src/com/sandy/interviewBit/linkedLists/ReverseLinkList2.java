package com.sandy.interviewBit.linkedLists;

public class ReverseLinkList2 {

	public ListNode reverseBetween(ListNode A, int B, int C) {
		if(B == C) {
			return A;
		}
		
		ListNode mFront;
		ListNode mLast = null;
		int i = 1;
		ListNode prev = null;
		ListNode curr = A;
		
		while (curr != null) {
			if (B == i) {
				ListNode lPrev = null;
				ListNode temp;
				while (B <= C) {
					if(lPrev == null) {
						mLast = curr;
					}
					temp = curr.next;
					curr.next = lPrev;
					lPrev = curr;
					curr = temp;
					B++;
				}
				mFront = lPrev;
				mLast.next = curr;
				if (prev == null) {
					return mFront;
				}
				prev.next = mFront;
				return A;
			}
			
			prev = curr;
			curr = curr.next;
			i++;
		}
		return A;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);

		
		node1.next = node2;
		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
		ReverseLinkList2 is = new ReverseLinkList2();
		System.out.println(is.reverseBetween(node1, 1, 2));
	}

}

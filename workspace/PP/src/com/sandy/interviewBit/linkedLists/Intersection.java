package com.sandy.interviewBit.linkedLists;

public class Intersection {

	static public ListNode getIntersectionNode(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return null;
		}
		int lengthA = 0;
		int lengthB = 0;
		ListNode aTemp = a;
		ListNode bTemp = b;
		
		while (aTemp!= null) {
			aTemp = aTemp.next;
			lengthA++;
		}
		
		while (bTemp!= null) {
			bTemp = bTemp.next;
			lengthB++;
		}
		
		ListNode aStart = a;
		ListNode bStart = b;
		if (lengthA > lengthB) {
			int diff = lengthA - lengthB;
			while (diff > 0) {
				aStart = aStart.next;
			}
		} else if (lengthB > lengthA) {
			int diff = lengthB - lengthA;
			while (diff > 0) {
				bStart = bStart.next;
			}
		}
		
		while (aStart != bStart) {
			aStart = aStart.next;
			bStart = bStart.next;
		}
		
		return aStart;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
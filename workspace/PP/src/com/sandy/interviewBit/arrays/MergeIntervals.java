package com.sandy.interviewBit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	static public class Interval {
		     int start;
		     int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
		     @Override
		    public String toString() {
		    // TODO Auto-generated method stub
		    	 return "["+start+ ", "+end+"]";
		    }
		 }
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if(intervals.size() == 1) {
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start) {
					return -1;
				} else if(o1.start > o2.start) {
					return 1;
				}
				return 0;
			}
		});
		//System.out.println("sorted ="+ intervals);
		result.add(new Interval(intervals.get(0).start, intervals.get(0).end));
		for(int i=1; i< intervals.size(); i++) {
			int currResIndex = result.size()-1;
			if(intervals.get(i).start <= result.get(currResIndex).end) {
				int a = result.get(currResIndex).start;
				int b = Math.max(intervals.get(i).end, result.get(currResIndex).end);
				result.remove(currResIndex);
				result.add(new Interval(a, b));
			} else {
				result.add(new Interval(intervals.get(i).start, intervals.get(i).end));
			}
		}
		return result;
    }
	
	public static void main(String[] args) {

		MergeIntervals mergeIntervals = new MergeIntervals();
		ArrayList<Interval> a = new ArrayList<Interval>();
		a.add(new Interval(1, 10));
		a.add(new Interval(2, 9));
		a.add(new Interval(3, 8));
		a.add(new Interval(4, 7));
		a.add(new Interval(5, 6));
		a.add(new Interval(6, 6));
		//System.out.println("unsorted = "+a);
		System.out.println(mergeIntervals.merge(a));


	}

}

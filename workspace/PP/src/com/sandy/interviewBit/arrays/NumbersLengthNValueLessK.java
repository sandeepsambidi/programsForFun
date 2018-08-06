package com.sandy.interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumbersLengthNValueLessK {
	
	public int solveMy(int[] A, int B, int C) {
		int[] pos = new int[10];
		for(int i = 0; i<pos.length; i++) {
			pos[i] = -1;
		}
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i< A.length; i++) {
			hm.put(A[i], 0);
		}
				
		String Cstr = Integer.toString(C);
		int len = Cstr.length();
		int digit[] = new int[len];
		for(int i=0; i<len; i++) {
			digit[i] = Integer.parseInt(String.valueOf(Cstr.charAt(i)));
		}
		System.out.println("digit = "+Arrays.toString(digit));
		HashMap<Integer, Integer> available = new HashMap<Integer, Integer>();
		
		for(int i = 0; i<A.length; i++) {
			pos[A[i]] = i;
			available.put(A[i], 0);
		}
		
		for(int i = 1; i<pos.length; i++) {
			if(pos[i] == -1) {
				int k = pos[i-1];
				while(i<pos.length && pos[i]==-1) {
					pos[i] = k+1;
					i++;
				}
			}
		}
		
		boolean zeroAvailable = pos[0]==-1?false:true;
		pos[0] = 0;
		System.out.println("pos = "+Arrays.toString(pos));
		
		if(B > digit.length || B==0) {
			return 0;
		} else if(B< len) {
			if(B==1) {
				return A.length;
			} else {
				if(A[0]==0) {
					return (int) ((A.length-1)*Math.pow(A.length, digit.length-1));
				}
			}
		}
		
		
		int dp[] = new int[len+1];
		
		for(int i = 1; i< dp.length; i++) {
			dp[i] += dp[i-1]*A.length;
			
			boolean check = true;
			check = checkAvailable(digit, available, 0, i-1);
			
			if(check) {
				if(i==1) {
					if(zeroAvailable) {
						if(B==1) {
							dp[i] += pos[digit[i-1]];
						} else {
							dp[i] += (pos[digit[i-1]]-1);
						}
					} else {
						dp[i] += pos[digit[i-1]];
					}
				} else {
					dp[i] += pos[digit[i-1]];
				}
			} 
		}
		
		return dp[B];
    }
	
	boolean checkAvailable(int[] digit, HashMap<Integer, Integer> available, int start, int end) {
		if(end==0) {
			return true;
		}
		while(start <= end) {
			if(!available.containsKey(digit[start])) {
				return false;
			}
			start++;
		}
		return true;
	}
	
	int firstI(int i, int[] digit) {
		int res = 0;
		for(int k = 0; k<i; k++) {
			res = res*10 + digit[k];
		}
		return res;
	}
	
	public int solve(int[] a, int B, int C) {
		List<Integer> A = new ArrayList<Integer>();
		for(int x: a) {
			A.add(x);
		}
        String str=Integer.toString(C);
        int cl=str.length();
        int size=A.size();
        int d=size,d2;
        if(B>cl || C==0 || size==0)
            return 0;
        int zeros=A.lastIndexOf(0)-A.indexOf(0)+1;
        boolean zero=A.contains(0);
        int ans=0;
        if(B<cl){
            if(zero && B!=1)
                ans += size-1;
            else
                ans=size;
            for(int i=1;i<B;i++)
                ans *= size;
            return ans;
        }
        
        int dp[]=new int[B+1];
        int lower[]=new int[11];
        
        if(B==cl){
            
            for(int i = 0; i <= B; i++)
              dp[i] = 0;
            for(int i = 0; i <= 10; i++)
              lower[i] = 0;
            for(int i = 0; i < d; i++)
              lower[A.get(i) + 1] = 1;

            for(int i = 1; i <= 10; i++)
              lower[i] = lower[i-1] + lower[i]; 

                boolean flag = true;
                dp[0] = 0;
                for(int i = 1; i <= B; i++) {
                    int digit=str.charAt(i-1)-'0';
                  d2 = lower[digit];
                  dp[i] = dp[i-1] * d;
    
                  // For first index we can't use 0
                if(i == 1 &&  A.get(0) == 0 && B != 1)
                     d2 = d2 - 1;
    
                 //Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
                 if(flag)
                     dp[i] += d2;
             //Is digit[i - 1] present in A ?
                flag = flag & (lower[digit + 1] == lower[digit] + 1);
            }
            return dp[B];          
        
        }
        return 0;
        
    }
	


	public static void main(String[] args) {
		NumbersLengthNValueLessK obj = new NumbersLengthNValueLessK();
//		System.out.println(obj.solve(new int[]{2, 3, 5, 6, 7, 9}, 5, 42950));
//		System.out.println(obj.solve(new int[]{0, 1, 5}, 1, 2));
//		System.out.println(obj.solve(new int[]{0, 1,2, 5}, 2, 21)); //5
//		System.out.println(obj.solve(new int[]{0, 1,2, 5}, 2, 40)); //8
//		System.out.println(obj.solve(new int[]{0, 1,2, 5}, 1, 123)); //4
//		//{2, 9}, 5, 17015 Ans: 0
//		System.out.println(obj.solve(new int[]{2, 9}, 5, 17015));
//		System.out.println(obj.solve(new int[]{0}, 1, 5));



	}
}

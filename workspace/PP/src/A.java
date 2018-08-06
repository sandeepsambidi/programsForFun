import java.util.HashMap;

public class A {
	
	static String whichSweetShouldIBring(String[] votes) {
        HashMap<String, Integer> sweetCount = new HashMap<String,Integer>();
        int maxCount = 0;
        String maxCountSweet = "";
        for(int i=0; i< votes.length; i++) {
            if(sweetCount.containsKey(votes[i])) {
                sweetCount.put(votes[i], sweetCount.get(votes[i])+1);
                if(maxCount < sweetCount.get(votes[i])) {
                	maxCount = sweetCount.get(votes[i]);
                	maxCountSweet = votes[i];
                }
                else if(maxCount == sweetCount.get(votes[i])) {
                	if(votes[i].compareTo(maxCountSweet) <= 0) {
                		maxCount = sweetCount.get(votes[i]);
                    	maxCountSweet = votes[i];
                	}
                }
            } else {
            	sweetCount.put(votes[i], 1);
            	if(maxCount < 1) {
                	maxCount = 1;
                	maxCountSweet = votes[i];
                }
            }
        }
        
        return maxCountSweet;
    }
	
	static int countBits(long num) {
		int count = 0;
		while(num > 0) {
			num = num&(num-1);
			count++;
		}
		return count;
	}
	
	static void toBinary(long n)
	{
		StringBuilder sb = new StringBuilder();
		  for (int i = 0; i < 64; i++){
			  if((n & (1<<i)) == 1) {
		        	sb.append("1");
		        } else 
		        	sb.append("0"); 
		  }
		        //((n & i)==1)? printf("1"): printf("0");
		  System.out.println(sb.toString());    
	}
	
	public static void main(String[] args) {
		//System.out.println(1<<16);
		//System.out.println(Math.pow(2, 15));
		//System.out.println(countBits(100000000000000L));
		//toBinary(100000000000000L);
		//long k = (((long)1<<30) + ((long)1<<30) );
		//System.out.println(Long.toString(k));
		
		long k = 0;
		long num = 100000000000000L;
		long n = 1;
		k = (n*(n+1)/2);
		while(k<num) {
			n++;
			k = n*(n+1)/2;
		}
		long firstBitPos = n;
		System.out.println("find num = "+n);
		System.out.println("get after find = "+((long)14142135*(long)14142134)/(long)2);
		
	}
}

package leetcode;

public class ReverseInteger {
	public int reverse(int x) {
        boolean positive = (x >= 0);
        long x1 = (long)x;
        if(x1 <0){
            x1= 0-x1;
        }else if(x1 > 0){
            x1= x1;
        }else{
            return 0;
        }
        String outStr = "";
        System.out.println(x1);
        while(x1>=1){
            outStr += x1%10;
            x1= x1/10;
        }
        if(!positive){
            outStr = "-"+outStr;
        }
        System.out.println(outStr);
        
        long outLong = Long.parseLong(outStr);
        if(outLong > Integer.MAX_VALUE || outLong < Integer.MIN_VALUE){
        	return 0;
        }
        
        return Integer.parseInt(outStr);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(0-(-2147483648) );
		
		ReverseInteger r = new ReverseInteger();
		r.reverse(-2147483648);
	}

}

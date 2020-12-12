package conversions;

import java.util.HashMap;
import java.util.Scanner; 

public class RomanToInt {
	
	public static void main(String[] args) {
		Scanner roman = new Scanner(System.in);
		IntToRoman validation = new IntToRoman();

	    while(true) {
	    	System.out.println("Enter Roman Numerals (enter 0 to exit): ");
	    	String input = roman.nextLine();
	    	int intConversion = 0;
	    	if(input.equals("0")) break;
	    	try {
	    		intConversion = romanToInt(input.toUpperCase());
	    		if(!(validation.intToRoman(intConversion).equals(input.toUpperCase()))) throw new NullPointerException();
	    		System.out.println("The Integer representation of " + input.toUpperCase() +" is " + intConversion);
	    	}catch(NullPointerException e) {
	    		System.out.println("Not a valid Roman Numeral, try again.");
	    	}
	    }
	}
	 public static int romanToInt(String s) {
	        HashMap<String, Integer> romans = new HashMap<String, Integer>();
	        int romanInt = 0;
	        romans.put("I", 1);
	        romans.put("V", 5);
	        romans.put("X", 10);
	        romans.put("L", 50);
	        romans.put("C", 100);
	        romans.put("D", 500);
	        romans.put("M", 1000);
	        for(int i=0; i<s.length(); i++){
	            String curr = String.valueOf(s.charAt(i));
	            int currNum = romans.get(curr);
	            if(i!=s.length()-1){
	                String nextVal = String.valueOf(s.charAt(i+1));
	                if(curr.equals("I") && (nextVal.equals("V") || nextVal.equals("X"))){
	                    currNum = romans.get(nextVal) - romans.get(curr);
	                    i++;
	                }
	                else if(curr.equals("X") && (nextVal.equals("L") || nextVal.equals("C"))){
	                    currNum = romans.get(nextVal) - romans.get(curr);
	                    i++;
	                }
	                else if(curr.equals("C") && (nextVal.equals("D") || nextVal.equals("M"))){
	                    currNum = romans.get(nextVal) - romans.get(curr);
	                    i++;
	                }
	            }
	            romanInt += currNum;
	        }
	        return romanInt;
	    }

}

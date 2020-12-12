package conversions;

import java.util.Scanner;

public class IntToRoman {
	
	public static void main(String[] args) {
		Scanner myInt = new Scanner(System.in);

	    while(true) {
	    	System.out.println("Enter a positive integer (enter 0 to exit): ");
	    	String input = myInt.nextLine(); 
	    	if(input.equals("0")) break;
	    	try {
	    		int intInput = Integer.parseInt(input);
	    		if(intInput<0) throw new NumberFormatException();
	    		String romanConversion = intToRoman(intInput);
	    		System.out.println("The roman numeral representation of " + input +" is " + romanConversion);
	    	}catch(NumberFormatException e) {
	    		System.out.println("Not a valid positive integer, try again.");
	    	}
	    }
	}
	 public static String intToRoman(int num) {
	        String one = "I";
	        String five = "V";
	        String ten = "X";
	        String fifty = "L";
	        String hundred = "C";
	        String fiveHundred = "D";
	        String thousand = "M";
	        StringBuilder str = new StringBuilder(); 
	        if(num>=1000){
	            int divi = num/1000;
	            while(divi>0){
	                str.append(thousand);
	                divi--;
	            }
	            num = num%1000;
	        }
	        if(num>=100){
	          int divi = num/100;
	            while(divi>0){
	                if(divi == 9){
	                    str.append("CM");
	                    divi = 0;
	                    break;
	                }
	                if(divi>5 && divi<9){
	                    str.append(fiveHundred);
	                    divi = divi-5;
	                }
	                if(divi == 5){
	                    str.append(fiveHundred);
	                    divi = 0;
	                    break;
	                }
	                if(divi == 4){
	                    str.append("CD");
	                    divi = 0;
	                    break;
	                }
	                if(divi < 4){
	                    str.append(hundred);
	                    divi--;
	                }
	            }
	            num = num%100;
	        }
	        if(num>=10){
	          int divi = num/10;
	            while(divi>0){
	                if(divi == 9){
	                    str.append("XC");
	                    divi = 0;
	                    break;
	                }
	                if(divi>5 && divi<9){
	                    str.append(fifty);
	                    divi = divi-5;
	                }
	                if(divi == 5){
	                    str.append(fifty);
	                    divi = 0;
	                    break;
	                }
	                if(divi == 4){
	                    str.append("XL");
	                    divi = 0;
	                    break;
	                }
	                if(divi < 4){
	                    str.append(ten);
	                    divi--;
	                }
	            }
	            num = num%10;
	        }
	        if(num>=1){
	          int divi = num;
	            while(divi>0){
	                if(divi == 9){
	                    str.append("IX");
	                    divi = 0;
	                    break;
	                }
	                if(divi>5 && divi<9){
	                    str.append(five);
	                    divi = divi-5;
	                }
	                if(divi == 5){
	                    str.append(five);
	                    divi = 0;
	                    break;
	                }
	                if(divi == 4){
	                    str.append("IV");
	                    divi = 0;
	                    break;
	                }
	                if(divi < 4){
	                    str.append(one);
	                    divi--;
	                }
	            }
	        }
	        return str.toString();
	    }

}

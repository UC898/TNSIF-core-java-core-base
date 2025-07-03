package day2;


public class Operators {
      public static void main(String[] args) {
    	  
    	  
    		    // declare variables
    		    int a2 = 12, b2 = 5;

    		    // addition operator
    		    System.out.println("a + b = " + (a2 + b2));

    		    // subtraction operator
    		    System.out.println("a - b = " + (a2 - b2));

    		    // multiplication operator
    		    System.out.println("a * b = " + (a2 * b2));

    		    // division operator
    		    System.out.println("a / b = " + (a2 / b2));

    		    // modulo operator
    		    System.out.println("a % b = " + (a2 %b2));
    		    
    		    
    		    
    		    // create variables
    		    int a1 = 4;
    		    int var;

    		    // assign value using =
    		    var = a1;
    		    System.out.println("var using =: " + var);

    		    // assign value using =+
    		    var += a1;
    		    System.out.println("var using +=: " + var);

    		    // assign value using =*
    		    var *= a1;
    		    System.out.println("var using *=: " + var);
    		 
		int a=10;
		int b=20;
		int c=30;
		
		int d= c++ + a + b--;
		System.out.println(d);
		
		int val1=5;
		int val2=6;
		int val3=8;
		
		int val4=(val1++) +(val2-- )+(--val3);
		System.out.println(val4);
		
	}
}
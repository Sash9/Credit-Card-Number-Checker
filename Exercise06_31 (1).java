/******************************************************************************

- pseudocode 
		- prompt user to enter credit card number 
		- store credit card number in a variable number of type long 
		
		- IF number is Valid THEN <call isValid() method 
			Display mumber "is valid"
		  ELSE 
			Display number "is not valid" 
			
		isValid method 
			- calls getSize, prefixMatched, sumOfDoubleEvenPlace, sumOfOddPlace methods
			
		sumofDoubleEvenPlace 
			- calls getDigit method
			
		- prefixMatched 
			- calls getPrefix 
			
		- getPrefix 
			- calls getSize 

*******************************************************************************/
import java.util.*;

public class Exercise06_31
{
    
    
    
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long cardNum)
	{
	    // convert card number to string to check all numbers
	    String numString = cardNum + " ";
	    int numLength = numString.length()-1;
	    int index = 1;
	    int place;
	    int total;
	    int sum = 0;
	    int converterOne;
	    int converterTwo;
	    
	    // for loop to run through full card number
	    for (int i = 0; i < numLength; i++)
	    {
	        // > 0 to get all even numbers
	        if (index % 2 > 0)
	        {
	            // call getDigit to check if it is double digit or not
	            sum += getDigit(numString.charAt(numLength - index -1) - '0');
	            
	            
	            
	        }
	        // increase index to check different numbers in card number
	        index++;

	    }
	    return sum;
	    
	    
	    
	}
	
	
    /** Return this number if it is a single digit, otherwise,
    * return the sum of the two digits */
    public static int getDigit(int number)
    {
        int total = number * 2;
        int sum = 0;
	    int converterOne;
	    int converterTwo;
	            
	   // if it is oduble digit
	    if (total >= 10)
	    {
	        String thing = total + " ";
	        // Add two numbers if it is double digit        
	        converterOne = thing.charAt(1) - '0';
	        converterTwo = thing.charAt(0) - '0';
	                
	        sum = (converterOne + converterTwo);
	        return sum;
	        
	                
	                
	    }
	    else // else return number
	    {
	        return total;
	                
	    }
	            
	    
    }
	
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long cardNum)
    {
        String numString = cardNum + " ";
	    int numLength = numString.length()-1;
	    int index = 0;
	    int place;
	    int total;
	    int sum = 0;
	    int converterOne;
	    int converterTwo;
	    
	    // go through all numbers in card number
	    for (int i = 0; i < numLength; i++)
	    {
	        // == 0 to get odd numbers
	        if (index % 2 == 0)
	        {
	            // add all odd numbers
	            total = numString.charAt(numLength - index -1) - '0';
	            sum += total;
	
	        }
	        index++;

	    }
	    return sum;
	    
    }
    
    /** Return true if the card number is valid */
    public static boolean isValid(long number)
    {
        
        
        if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    /** Return the number of digits in d */
    public static int getSize(long d)
    {
        String numString = d + " ";
	    int numLength = numString.length()-1;
	    return numLength;
    }
    
    /** Return the first k number of digits from number. If the
    * number of digits in number is less than k, return number. */
    public static long getPrefix(long cardNum, int k)
    {
        String numString = cardNum + " ";
        String kAmount = " ";
        if (numString.length()-1 <= k) {
            return cardNum;
        } 
        else 
        {
            for (int i = 0; i < k; i++)
            {
                kAmount += numString.charAt(i);
            }
            long number = Long.parseLong(kAmount);
            return number;
        }
    }
    
    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d) 
    {
        return getPrefix(number, getSize(d)) == d;
    }

    
    
	
	
    
	public static void main(String[] args) {
		
		// Create a scanner object
		Scanner input = new Scanner(System.in);
		
		long cardNum;
		
		System.out.print("Enter a credit card number as a long integer: ");
		
		cardNum = input.nextLong();
		
		
		
		if (isValid(cardNum) == true)
		{
		    System.out.println(cardNum + " is valid");
		}
		else
		{
		    System.out.println(cardNum + " is invalid");
		}
		
		
		
		
	
		
		
		
	}
}

import java.util.Scanner;

/**
 * 
 * @author karthik
 *
 *Given a string, , of lowercase letters, determine the index of the character whose removal will make  a palindrome. If  is already a palindrome or no such character exists, then print . There will always be a valid solution, and any correct answer is acceptable. For example, if  "bcbc", we can either remove 'b' at index  or 'c' at index .

Input Format

The first line contains an integer, , denoting the number of test cases. 
Each line  of the  subsequent lines (where ) describes a test case in the form of a single string, .

Constraints

All characters are lowercase English letters.
Output Format

Print an integer denoting the zero-indexed position of the character that makes  not a palindrome; if  is already a palindrome or no such character exists, print .
Explanation

Test Case 1: "aaab" 
Removing 'b' at index  results in a palindrome, so we print  on a new line.

Test Case 2: "baa" 
Removing 'b' at index  results in a palindrome, so we print  on a new line.

Test Case 3: "aaa" 
This string is already a palindrome, so we print ; however, , , and  are also all acceptable answers, as the string will still be a palindrome if any one of the characters at those indices are removed.

Note: The custom checker logic for this challenge is available here.
 */

public class Palindrome {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in);
        int numberOfString = Integer.parseInt(scanner.nextLine());
        for(int k=0; k<numberOfString; k++) {
            String s = scanner.nextLine();
            if(isPalindrome(s)) {
                System.out.println("-1");
            }
            else {
                for(int i=0, j=s.length() - 1; i< s.length()/2 && j>s.length()/2; i++, j--){
                    if(s.charAt(i) == s.charAt(j)) {
                        continue;
                    }
                    else{
                        if(s.charAt(i+1) == s.charAt(j)) {
                            System.out.println(i);
                        }
                        else {
                            System.out.println(j);
                        }
                    }
                } 
            }
        }
    }
    
    public static boolean isPalindrome(String s) {
        for(int i=0, j=s.length() - 1; i< s.length()/2 && j>s.length()/2; i++, j--){
			if(s.charAt(i) == s.charAt(j)) {
				continue;
			}
			else{
                return false;
  			}
		}          
    return true;
    }
}

//Given two arrays,  and , of size  that both contain permutations of the same set of unique integers, find and print the number having the absolute minimum index difference between the two arrays. In the event of a tie, choose the smallest number.
//
//Input Format
//
//The first line contains an integer, , denoting the size of the array. 
//The second line contains  space-separated integers describing array  (i.e., ). 
//The third line contains  space-separated integers describing array  (i.e., ).
//
//Constraints
//
// where  and  correspond to elements in  and , respectively.
//Output Format
//
//Print the number having the absolute minimum index difference between the two arrays. In the event of a tie, choose the smallest number.
//
//Sample Input
//
//6
//9 5 1 21 32 8
//21 32 9 8 5 1
//Sample Output
//
//8
//Explanation
//
//The absolute difference between the indices for each number are as follows:
//
//As you can see, the minimum index difference is  and there are two numbers,  and , having this minimum index difference. As  is the smaller of the two numbers, we print  as our answer.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumIndexDifference {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String[] aArray = first.split(" ");
        String[] bArray = second.split(" ");
        // Value and its index
        Map<String, Integer> aMap = new HashMap<>();
        Map<String, Integer> bMap = new HashMap<>();
        for(int i=0; i<size; i++) {
            aMap.put(aArray[i], i);
        }
        
        for(int i=0;i<size; i++) {
            bMap.put(bArray[i], i);
        }
        
        // Calculating the minimum index difference
        int minimumDifference = Integer.MAX_VALUE;        
        int minimumAValue = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : aMap.entrySet()) {
            int aIndex = entry.getValue();
            int bIndex = bMap.get(entry.getKey());
            int exactIndexDifference = aIndex - bIndex;
            
            if(minimumDifference > Math.abs(exactIndexDifference)) {
                minimumDifference = Math.abs(exactIndexDifference);
                minimumAValue = Integer.parseInt(entry.getKey());
            }
            
            else if(minimumDifference == Math.abs(exactIndexDifference)) {
                if(minimumAValue > Integer.parseInt(entry.getKey())) {
                    minimumAValue = Integer.parseInt(entry.getKey());
                }
            }
        }
    System.out.println(minimumAValue);
    }
}
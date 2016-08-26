import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UniqueCharacters {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> characterMap = new HashMap<>();
        
        boolean containsDuplicate = false;
        for(int i =0;i< input.length(); i++) {
            if(Character.isLetter(input.charAt(i))){
                if(characterMap.get(input.charAt(i)) == null) {
                    characterMap.put(input.charAt(i), 1);
                }
                else {
                    containsDuplicate = true;
                    break;
                }
                
            }
            
        }
     if(containsDuplicate) {
         System.out.println("Yes");
     }
     else{
          System.out.println("No");            
     }
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReverseString {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        StringBuffer reversedSentence = new StringBuffer("");
        String[] words  = sentence.split(" ");
        for(int i = words.length - 1; i>=0; i--) {
            reversedSentence.append(words[i]);
            if(i != 0){
                reversedSentence.append(" ");                
            }
        }

        System.out.println(reversedSentence.toString());    
    }
}
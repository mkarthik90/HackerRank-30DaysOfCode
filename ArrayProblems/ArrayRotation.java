import java.io.*;
import java.util.*;

public class ArrayRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        String[] arraySizeAndRotation = values.split(" ");
        int[] a = new int[Integer.parseInt(arraySizeAndRotation[0])];
        for (int i=0; i< Integer.parseInt(arraySizeAndRotation[0]); i++) {
            a[i] = Integer.parseInt(scanner.next());
        }

        int rotateSize = Integer.parseInt(arraySizeAndRotation[1]);

        if(rotateSize > a.length) {
            rotateSize = rotateSize % a.length;
        }
        
        for(int i =0 ; i< rotateSize; i++){
            a = rotate(a);
        }
    
        
        for( int i =0;i < a.length; i++){
            System.out.print(a[i]);
            System.out.print(" ");
        }
        
    }
    
    public static int[] rotate(int[] a){
        int firstElement = a[0];
        for ( int i = 0; i< a.length; i++){
            if(i == a.length -1){
                a[a.length - 1] = firstElement;
            }
            else {
                a[i] = a[i+1];
            }
            
        }
        return a;
    }
}
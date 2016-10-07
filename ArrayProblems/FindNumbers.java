/**
 * Given an array of n number, this program finds the maximum occurence 
 * of a number without using extra space.
 * Hint: Use index values and make those value -1. 
**/

public class FindNumbers {

    public static int findMaximumOccurenceInNNumbers(int[] a) {
        int expectedIndex = 0;
        int i = 0;
        while (i < a.length) {
            expectedIndex = a[i];
            if (expectedIndex < 0) {
                i++;
                continue;
            }
            if (a[expectedIndex] < 0) {
                // Already data loaded add 1
                a[expectedIndex] = a[expectedIndex] - 1;
                i++;
            }
            else if(expectedIndex < i) {
                // Already this data has been loaded
                a[expectedIndex] = -1;
                i++;
            }
            else {
                // swap the data from that position and make that -1
                a[i] = a[expectedIndex];
                a[expectedIndex] = -1;
            }
        }
        
        int minimumValue = Integer.MAX_VALUE;
        int minimumIndex = -1;
        for (int j = 0; j < a.length; j++) {
            if (a[j] < minimumValue) {
                minimumValue = a[j];
                minimumIndex = j;
            }
        }
        return minimumIndex;
    }

    public static void main(String[] args) {
        int[] a = { 4, 4, 3, 3, 4, 5 };
        System.out.println(findMaximumOccurenceInNNumbers(a));
    }

}

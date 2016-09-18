//Consider an array of  integers, . We can perform two types of queries on :
//
//1 k: For query type , find and print an integer denoting the index of the  zero in array  on a new line; if no such index exists (i.e., there is no  zero), print NO instead.
//2 p x: For query type , replace the element positioned at index  with integer  (i.e., set ).
//Given 's initial state and  queries, perform each query in order. For each query of type , print the query's answer on a new line.
//
//Input Format
//
//The first line contains two space-separated integers describing the respective values of  (the size of the array) and  (the number of queries). 
//The second line contains  space-separated integers describing the respective elements of array  (i.e., ).
//
//Each of the  subsequent lines describes a query in one of the following forms:
//
//1 k, where  is the query type and  denotes the  zero you must locate an index for in the array.
//2 p x, where  is the query type,  is the index (position) you must update, and  denotes the new value to store at .
//Note: There is only single space after the type of query.
//
//Constraints
//
//Output Format
//
//For each query of type , print a single integer on a new line denoting the index where the  zero is located in ; if no such index exists (i.e., there is no  zero), print NO instead.
//
//Sample Input
//
//Explanation
//
//Intially, . We perform the following  queries:
//
//1 2: Find and print the index of the second zero () in . The second zero is located at , so we print on a new line.
//2 1 5: Update the value at  to be  so that array .
//1 1: Find and print the index of the first zero (). The first zero is located at  (because the value that was previously the first zero was overwritten in the second query), so we print  on a new line.
//2 3 10: Update the value at  to be  so that array .
//1 1: Find and print the index of the first zero () in . The array doesn't contain any zeroes in its current state as both zeroes were overwritten during previous queries, so we print NO on a new line.
//2 4 0: Update the value at  to be  so that array .
//1 2: Find and print the index of the second zero () in . Array  only contains one zero in its current state, so no such index exists. Thus, we print NO on a new line.

class KZero {

    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] array = a.split(" ");
        int arraySize = Integer.parseInt(array[0]);
        int totalQueries = Integer.parseInt(array[1]);
        
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] c = new int[arraySize];
        int k= 0;
        for(String a1 : inputArray) {
            c[k] = Integer.parseInt(a1);
            k++;
        }
        for(int i=0; i< totalQueries; i++) {

            String query = scanner.nextLine();
            String[] queries = query.split(" ");
            if(queries[0].equalsIgnoreCase("1")){
                handleQuery1(queries, c);
            }
            else {
                c = handleQuery2(queries, c);
            }
        }
        
    }
    
    public static void handleQuery1(String[] query, int[] c) {
        // Find and print the index of the nth zero
        int n = Integer.parseInt(query[1]);
        int i=0;
        boolean found = false;
        while(n != 0 && i < c.length) {
            if(c[i] == 0) {
                n--;
            }
            
            
            if(n == 0) {
                System.out.println(i);
                found = true;
                break;
            }
            i++;
        }
        
        if(!found) {
            System.out.println("NO");
        }
    }
    
    public static int[] handleQuery2(String[] queries, int[] c) {
        int index = Integer.parseInt(queries[1]);
        int value = Integer.parseInt(queries[2]);
        c[index] = value;        
        return c;
    }

}
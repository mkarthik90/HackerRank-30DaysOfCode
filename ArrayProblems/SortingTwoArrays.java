public class SortingTwoArrays {

    /**
     * This method sorts both a and b input a needs to be sorted input b needs
     * to be sorted
     * 
     * @param arr1
     * @param arr2
     */
    public static void sort(int[] arr1, int[] arr2) {

        for (int i = arr2.length - 1; i >= 0; i--) {
            int last = arr1[arr1.length - 1];
            int j = 0;
            for (j = arr1.length - 1; j >= 0 && arr1[j] > arr2[i]; j--) {
                if (j != arr1.length - 1) {
                    arr1[j + 1] = arr1[j];
                }
            }

            if (j != arr1.length - 1) {
                j++;
                arr1[j] = arr2[i];
                arr2[i] = last;
            }

        }

        System.out.println("After sorting");

        for (int i : arr1) {
            System.out.println(i);
        }

        for (int j : arr2) {
            System.out.println(j);
        }

    }

    public static void main(String[] arr) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6 };
        int[] arr2 = { 7, 8, 9, 10 };
        sort(arr1, arr2);
        
        
        int[] arr3 = { 7, 8, 9, 10 };
        int[] arr4 = { 1, 2, 3, 4, 5, 6 };
        sort(arr3, arr4);

        int[] arr5 = { 1, 3, 6, 8, 10 };
        int[] arr6 = { 2, 4, 5, 7, 9 };
        sort(arr5, arr6);
    }
}

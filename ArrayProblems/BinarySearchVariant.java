class BinarySearchVariant {

    /**
    * Finds the first occurence of the number
    * and returns the index
    **/
    public static int binarySearch(int x, int start, int end, int[] a) {
        System.out.println("start index" + start);
        System.out.println("end index" + end);
        if (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] > x) {
                return binarySearch(x, start, mid - 1, a);
            }

            else if (a[mid] < x) {
                return binarySearch(x, mid + 1, end, a);
            }

            else if (a[mid - 1] == x) {
                return binarySearch(x, start, mid - 1, a);
            }

            return mid;
        }
        else {
            return -1;
        }

    }

    public static boolean isMajority(int[] a, int x) {
        int i = binarySearch(x, 0, a.length, a);
        
        if(i == -1) {
            return false;
        }
        
        // Check if there is no out of bounds for i + n/2
        int n = a.length;
        if (i + (n / 2) < n && a[i] == a[i + (n / 2)]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 3, 3, 3, 10 };
        int x = 3;
        System.out.println(isMajority(a, x));
    }


}
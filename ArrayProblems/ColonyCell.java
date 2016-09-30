/**
 * There is a  colony of 8 cells arranged in a straight line where each day every cell competes with its adjacent cells(neighbour).
 * Each day, for each cell, if its neighbours are both active or both inactive, the cell becomes inactive the next day,. otherwise itbecomes active the next day.
 * Assumptions:
 * The two cells on the ends have single adjacent cell, so the other adjacent cell can be assumsed to be always inactive.
 * Even after updating the cell state. consider its pervious state for updating the state of other cells. Update the cell informationof allcells simultaneously.
 * Write a fuction cellCompete which takes takes one 8 element array of integers cells representing the current state of 8 cells and one integer days representing te number of days to simulate.
 * An integer value of 1 represents an active cell and value of 0 represents an inactive cell.
 */
class ColonyCell {
    public static int[] getResult(int[] a, int k) {

        while (k > 0) {
            int temp = 0;
            for (int i = 0; i < a.length; i++) {
                int prev = a[i];
                if (i == a.length - 1) {
                    // Checking for last element
                    int last = 0;
                    if (temp == last) {
                        a[i] = 0;
                    } else {
                        a[i] = 1;
                    }
                } else {
                    // For all other elements
                    if (temp == a[i + 1]) {
                        // Both are same
                        a[i] = 0;
                    } else {
                        a[i] = 1;
                    }
                }

                temp = prev;
            }
            k--;
        }

        return a;
    }

    public static void main(String[] arr) {
        int[] a = { 1, 1, 1, 0, 1, 1, 1, 1 };
        int[] result = getResult(a, 3);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

}
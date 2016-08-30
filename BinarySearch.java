class BinarySearch {

	public int search(int a[], int start, int endIndex , int value) {
		if(endIndex > 1){
			int mid = endIndex/2;
			System.out.println("end index");
			System.out.println(endIndex);
			System.out.println(mid);
			System.out.println("Value"+a[mid]);
			if(a[mid] == value) {
				return mid;
			}
			
			else if(a[mid] > value) {
				System.out.println(a[mid] +" is greater than " + value);
				search(a, 0, mid, value);
			}

			else if(a[mid] < value){
				System.out.println(a[mid] +" is less than " + value);
				search(a, mid, endIndex, value);
			}
		}
		
		return -1;
	}

	public static void main(String arr[]) {
		int a[] = {1,5,6,7,8,86,43,23};

		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.search(a, 0, a.length, 7));

	}
}
class MaximumProductSubArray {

	public int findMaxSubArray(int[] arr, int k) {

		int maximumProduct = 1;
		for(int i=0; i<k; i++) {
			maximumProduct = maximumProduct * arr[i];
		}
		int currentProduct  = 1;
		int previousProduct = maximumProduct;
		for(int i=k; i<arr.length; i++) {
			currentProduct = (previousProduct/ arr[i-k]) * arr[i];
			previousProduct = currentProduct;
			if(maximumProduct < currentProduct) {
				maximumProduct = currentProduct;
			}	
		}
	return maximumProduct;
	}

	public static void main(String[] arr) {
		int[] a = {6, 5, 5, 4, 2};
		MaximumProductSubArray max = new MaximumProductSubArray();
		int result = max.findMaxSubArray(a, 3);
		System.out.println(result);
	}
}
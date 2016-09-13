class PrimeNumber {

	/*
	* This function calculates all the prime numbers less than the given range
	* Sieve of Eratosthenes
	* Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.
	* For example, if n is 10, the output should be “2, 3, 5, 7″. If n is 20, the output should be “2, 3, 5, 7, 11, 13, 17, 19″.
	* The sieve of Eratosthenes is one of the most efficient ways to find all primes smaller than n when n is smaller than 10 million or so (Ref Wiki)
	* http://www.geeksforgeeks.org/sieve-of-eratosthenes/
	*/
	public int[] getPrimeNumber(int n) {

		boolean[] primes = new boolean[n+1];

		for(int i=2;i<primes.length; i++) {
			primes[i] = true;
		}

		for(int p=2; p*p <= n; p++) {
			if(primes[p]) {
				for(int i=p * 2; i<= n; i = i + p) {
					primes[i] = false;
				}
			}
		}

	int totalPrimeNumbers = 0;

	for(boolean prime : primes) {
		if(prime) {
			totalPrimeNumbers++;
		}
	}

	int[] primeNumbers = new int[totalPrimeNumbers];
	int primeIndex = 0;
	for(int i=0; i<primes.length; i++) {
		if(primes[i]) {
			primeNumbers[primeIndex] = i;
			primeIndex++;
		}
	}

	return primeNumbers;
	}


	public static void main(String arr[]) {
		PrimeNumber primeNumber = new PrimeNumber();
		int[] primes = primeNumber.getPrimeNumber(29);
		for(int i : primes) {
			System.out.print(i+" ");
		}
	}
}
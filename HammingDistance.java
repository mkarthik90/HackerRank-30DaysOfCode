
public class HammingDistance {

	public static void main(String[] args) {
		String s1 = "this is a test";
		String s2 = "wokka wokka !!!";
		
		int size  = s1.length();
		int totalCount = 0;
		for(int i=0;i<size;i++){
			int n = s1.charAt(i) ^ s2.charAt(i);
			int count = 0;
			while(n!=0){
				n = n & n-1;
				count ++ ;
			}
			totalCount = totalCount + count;
		}
		System.out.println(totalCount);
	}

}

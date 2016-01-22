import java.awt.font.NumericShaper;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberNames {

		
	static{}
	
	public static void main(String[] args) {

		Map<Object,String> numberNames = new HashMap<Object,String>();
		numberNames.put('0', "");
		numberNames.put('1',"one");
		numberNames.put('2',"two");
		numberNames.put('3',"three");
		numberNames.put('4',"four");
		numberNames.put('5',"five");
		numberNames.put('6',"six");
		numberNames.put('7',"seven");
		numberNames.put('8',"eight");
		numberNames.put('9',"nine");
		
		
		numberNames.put(20, "twenty");
		numberNames.put(30, "thirty");
		numberNames.put(40, "forty");
		numberNames.put(50, "fifty");
		numberNames.put(60, "sixty");
		numberNames.put(70, "seventy");
		numberNames.put(80, "eighty");
		numberNames.put(90, "ninty");
		
		numberNames.put("3d","hundred");
		numberNames.put("4d","thousand");
		
	
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		
		int j = 0;
		int numberOfTerms = 1;
		/*do{
			numberOfTerms++;
			j = value % divisor;l
			if(numberOfTerms!=1)
			divisor = divisor * 10;
		}while(j==0);
		
		
		while(numberOfTerms !=0){
			
			System.out.println(" "+numberNames.get(value%divisor));
			System.out.print(" "+numberNames.get(divisor));
			divisor = divisor/10;
			numberOfTerms --;
		}*/
		
		
		numberOfTerms = String.valueOf(value).length();
		int divisor = (int) Math.pow(10, numberOfTerms-1);
		
		String stringValue = String.valueOf(value);
		
		for(int i=0,k=stringValue.length();i<stringValue.length();i++,k--){
			System.out.print(numberNames.get(stringValue.charAt(i))+" ");
			if(i+1!=stringValue.length())
			System.out.print(numberNames.get(k+"d")+" ");
		}
		
	//	System.out.println(numberOfTerms);
	}

}

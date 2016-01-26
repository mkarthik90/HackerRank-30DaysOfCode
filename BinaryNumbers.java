import java.util.Scanner;

public class BinaryNumbers {


	public static void main(String arrp[]){
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		for(int i=1;i<=n;i++){
			StringBuilder builder = new StringBuilder();
			int number = i;
			while (number != 0) {
				if ((number & 1) == 0) {
					builder.append("0");
				} else {
					builder.append("1");
				}
				number = number >> 1;
			}
			System.out.println(builder.reverse());
		}
	}
	
}

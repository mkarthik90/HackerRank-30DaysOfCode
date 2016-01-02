import java.util.Scanner;

public class Arithmetic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double M = sc.nextDouble(); // original meal price
		int T = sc.nextInt(); // tip percentage
		int X = sc.nextInt(); // tax percentage
		sc.close();

		double tipValue = (M * T) / 100;
		double taxValue = (M * X) / 100;
		double finalPrice = M + tipValue + taxValue;

		int total = (int) Math.round(finalPrice);

		System.out.println("The final price of the meal is $" + total + ".");

	}
}

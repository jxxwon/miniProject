package inputs;


import java.util.Scanner;

public class Exam6 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        
		System.out.print("체중 : ");
		double weight = sc.nextDouble();
		
		System.out.print("키 : ");
		double height = sc.nextFloat();
		
		System.out.println("체중 : " + weight);
		System.out.println("키 : " + height);
		sc.close();
		
	}

}

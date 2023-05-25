package inputs;


import java.util.Scanner;

public class Exam7 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        
		System.out.print("문자 입력 : ");
		
//		String tmp = sc.next();
//		char data = tmp.charAt(0);
		
		char data = sc.next().charAt(0);  // 시행 순서 파악 후 작성하기 
		
		System.out.println("문자 : " + data);
		sc.close();
		
	}

}

package inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int data1 = 0, data2 = 0;
		while(true) {
				System.out.print("정수 입력 : ");
		
		
		try {
			//예외가 발생할 수 있는 코드를 작성.
			 data1 = sc.nextInt();
			 data2 = sc.nextInt();		
		} catch (InputMismatchException e) {
			// try 안에 코드에서 예외가 생겼다면 실행할 코드
			// 예외가 발생하지 않으면 실행안함
			sc.nextLine(); // buffer 청소
			continue;
		}
		break;
		}
		System.out.println("입력받은 데이터 : " + data1 + ", " + data2);
				sc.close();

		 
	}

}

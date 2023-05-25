package inputs;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name1 = sc.next(); //결과값이 돌아와 있다 (정의)
		String name2 = sc.next(); //결과값이 돌아와 있다 (정의)
		System.out.println("성 : " + name1);  // ex)김변수 / 김 변수 뛰어쓰기를 할 경우 println을 한번 더 써준다
		System.out.println("이름 : " + name2); // 그래야만 모든 값을 받을 수 있다.
		

	}

}

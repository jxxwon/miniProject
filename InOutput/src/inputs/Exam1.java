package inputs;

import java.util.Scanner;    // 클래스 추가된 것  // 경로 확인을 잘해야한다

public class Exam1 {

	public static void main(String[] args) {
		//String name;
		// 자료형 변수명;
		Scanner sc; //컨트롤 + 스페이바를 통해 클래스를 가져오는 방법을 써야한다
		
		// sc = 참조 값(주소)
		/*
		 new : 클래스를 실행해줘. 클래스(class)는 실행된 상태를 인스턴스(instance)
		 //Ex) 클래스 : 건물의 설계도, 인스턴스 : 설계도로 만들어진 건물 
		 // 위에 해당되는 클래스 같은경우 중복이 가능하다
		 System.in : 운영체제 입력
		 */
		
//		(sc = 주소를 입력받은 것) 
		sc = new Scanner(System.in); // (window, mac, linux 운영체제)
		//기능을 부여 받을때는 char(유니코드만)가 없다     
		
        System.out.println("문자열 : ");
        sc.next();
        
        System.out.println("문자열 : ");
        sc.nextLine();
        
        System.out.println("정수 : ");
        sc.nextInt();
        sc.nextInt();        
        // 입력받을(정수)는 두번을 사용할때 문자열을 한번더 넣어준다
        System.out.println("실수 : ");
        sc.nextDouble();        
        
        
    //  System.in.read(); 인터넷에 자주 사용됨 

	}

}

package variables;

public class Exam1 {

	public static void main(String[] args) {
		/*
		 자료형 변수명;
		 자료형 변수명 = 데이터;
		 '=' : 대입연산자, 오른쪽의 데이터를 왼쪽 공간에 넣어주겠다.
		  */
		
		
		//두 단어가 조합되는 상황
		// create date = > createDate(메서드 이름을 설정할때도 사용가능) 변수의 이름을 만들려면 대문자 한글자를 이용하기
		// createdate => 에러는 아니지만 개발자들의 약속을 지키지 않음.
		// create_date => 다른언어에서는 사용하지만 자바는 안씀.
		// CreateDate => 다른언어에서는 사용하지만 자바는 안씀.
	    int intData1;
		
		byte data1 = 100;
		short data2 = 100;
		int data3 = 100;
		long data4 = 100;
		
		/*
		 100이라는 상수가 내부에서 저장될 때 선택되는 자료형은 int
		 그래서 주로 int 자료형으로 정수를 저장하는 코드가 많을 것이다.
		 */
		
		//변수는 공간만들기, 데이터 생성, 데이터 분출
		
		intData1 =200;
		System.out.println("intData1 : " + intData1);
		System.out.println("data3 : " + data3);		
		
	}

}

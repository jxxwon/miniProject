package variables;

public class Exam2 {

	public static void main(String[] args) {
		/*
		 실수 상수는 기본 자료형이 double형이다.
		 */
		
		float floatData = 3.14f;
		double doubleData = 3.14;
		
		System.out.println("floatData : " + floatData);
		System.out.println("doubleData : " + doubleData);
		
		char charData1 = '안';
		char charData2 = '녕';
		
		String strData = "문자열데이터";
		char charData3 = strData.charAt(0);
		char charData4 = strData.charAt(5);		
		//String은 기능 제공
		
		System.out.println("strData : " + strData);
		System.out.println("charAt(0) : " + charData3);
		System.out.println("charAt(5) : " + charData4);		
		
		

	}

}

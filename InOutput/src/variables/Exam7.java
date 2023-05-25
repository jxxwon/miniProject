package variables;

public class Exam7 {

	public static void main(String[] args) {
		int data = 123, result;
		
		data = data + 10; // 123 + 10;
		
		char ch = 'D';       // 영어로 입력을하더라두 유니코드 표를 보고 숫자로 기입된다
		ch = (char)(ch + 3);
		result = data + ch; // 133 + 'G'(71);
		
		System.out.println("data : " + data);
		System.out.println("ch : " + ch);
		System.out.println("ch : " + (int)ch); // (자료형) : cast 연산자, casting
		System.out.println("result : " + result);		
		

	}

}

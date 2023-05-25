package outputs;

public class Exam2 {

	public static void main(String[] args) {
		System.out.println(100 + 100);
		System.out.println(200.22 + 200);
		System.out.println(200.11 + 100.22);		
        //소수점에 대한 오차가 발생 할수 있음 소수점 지정필요
		// "" 쌍따옴표로 데이터를 표현하면 문자열 데이터!
		// 쌍따옴표를 사용했을 때 한개의 대상이라도 계산값이 문자열로 나타남 
		System.out.println("100" + 100);
		System.out.println(200.22 + 200);
		System.out.println(200.11 + 100.22);
		
		System.out.println("결과 : " + 10000 + "원");
		System.out.printf("결과 : %d원", 10000);
	}

}

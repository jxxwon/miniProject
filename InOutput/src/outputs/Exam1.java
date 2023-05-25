package outputs;

public class Exam1 {
	// main method : 프로그램을 시작하면 첫번째로 실행되는 메서드
	// 예약어 : 기능을 갖고 있다.
	// 매개변수 : parameter, argument
	// : 메서드를 실행하기 직전에 전달할 데이터를 저장하는 공간.
	public static void main(String[] args) {
		
        System.out.println("println 메서드");	
		System.out.println("System & dot out 클래스");
		System.out.println(". 참조연산자 : 내부에 들어간다.");
		
		
		
		// 코드 실행 : Ctrl + F11
		System.out.print("print 메서드\n");
		System.out.print("이름 : ");
		System.out.print("\n나이 : ");
		
		System.out.printf("printf 메서드\n");
		System.out.printf("%d원\n", 10000);
		System.out.printf("%.1f달러\n", 101.12);		
		
        System.out.println("이름\t주소");						
        //"" 문자열의 데이터의 시작과 끝 화면에 출력하기 위해 \"\" 필요
        // \\을 출력을할려면 두번씩 write 해야한다. " \\이름\\"
        /*
         서식문자열(format string)
         %d : 정수 데이터  //주로많이 쓰는용도
         %f : 실수 데이터  //주로많이 쓰는용도
         ^s : 문자열 데이터
         */
	}

}

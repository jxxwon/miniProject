package variables;

public class Exam9
{
   public static void main(String[] args) {
	byte b = 97;
	short s = 20;
    char c = 'A';
    
    float f = 1.23f;
    
    s = b;
    c = (char)b; // char(0 ~ 65535), byte(-128 ~ 127)
    s = (short)c; // char(0 ~ 65535), short(-32768 ~ 32767)
    
    double d = 5.11;
    f = (float)5.11; 
    f = (float)d;
    f = 1.123456789f; //큰 공간안에 데이터는 작은공간에 들어갈 경우 손실(데이터)이 발생한다
    d = 1.1234567489012345678;
    
    System.out.println("float : " + f);
    System.out.println("double : " + d);    
    
   	}
}

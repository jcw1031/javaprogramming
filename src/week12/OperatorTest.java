package week12;
import java.util.*;

interface Operator{
    double operate(double num1, double num2); //인터페이스는 메소드 선언만 하고 구현 없음
}
//------------------------------------
class Add implements Operator{
    @Override
    public double operate(double num1, double num2){
        return num1+num2;
    } //인터페이스에서 선언한 메소드 구현
}
//------------------------------------
class Sub implements Operator{
    @Override
    public double operate(double num1, double num2){
        return num1-num2;
    } //위와 동일
}
//------------------------------------
class Mul implements Operator{
    @Override
    public double operate(double num1, double num2) {
        return num1*num2;
    } //위와 동일
}
//------------------------------------
class Div implements Operator{
    @Override
    public double operate(double num1, double num2) {
        return num1/num2;
    } //위와 동일
}
//------------------------------------
public class OperatorTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num1, num2;
        num1=s.nextInt();
        num2=s.nextInt();

        Add add=new Add(); //각각의 클래스마다 객체 생성
        Sub sub=new Sub();
        Mul mul=new Mul();
        Div div=new Div();

        System.out.println("Add : "+add.operate(num1, num2)); //각각의 클래스에서 새로 정의된 operate 메소드 호출
        System.out.println("Sub : "+sub.operate(num1, num2));
        System.out.println("Mul : "+mul.operate(num1, num2));
        System.out.println("Div : "+div.operate(num1, num2));
    }
}

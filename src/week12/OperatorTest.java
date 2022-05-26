package week12;
import java.util.*;

interface Operator{
    double operate(double num1, double num2);
}

class Add implements Operator{
    @Override
    public double operate(double num1, double num2){
        return num1+num2;
    }
}
class Sub implements Operator{
    @Override
    public double operate(double num1, double num2){
        return num1-num2;
    }
}
class Mul implements Operator{
    @Override
    public double operate(double num1, double num2) {
        return num1*num2;
    }
}
class Div implements Operator{
    @Override
    public double operate(double num1, double num2) {
        return num1/num2;
    }
}
public class OperatorTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num1, num2;
        num1=s.nextInt();
        num2=s.nextInt();

        Add add=new Add();
        Sub sub=new Sub();
        Mul mul=new Mul();
        Div div=new Div();

        System.out.println("Add : "+add.operate(num1, num2));
        System.out.println("Sub : "+sub.operate(num1, num2));
        System.out.println("Mul : "+mul.operate(num1, num2));
        System.out.println("Div : "+div.operate(num1, num2));
    }
}

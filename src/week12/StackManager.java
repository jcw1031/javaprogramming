package week12;
import java.util.*;

abstract class Stack{
    abstract int length();
    abstract String pop();
    abstract boolean push(String ob);

}

class StackString extends Stack{
    int count=0;
    String[] stack=new String[this.length()];

    @Override
    int length() {
        return 5; //5개의 문자열
    }

    @Override
    String pop() {
        count--;
        return stack[count+1];
    }

    @Override
    boolean push(String ob) {
        this.stack[count]=ob;
        count++;

        return true;
    }
}

public class StackManager {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack ob = new StackString();

        for(int i=0;i<ob.length();i++){
            ob.push(s.next());
        }

        ob= new Stack() {
            @Override
            int length() {
                return 5;
            }

            @Override
            String pop() {
                return null;
            }

            @Override
            boolean push(String ob) {
                return false;
            }
        };


    }
}

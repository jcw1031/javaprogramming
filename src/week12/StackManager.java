package week12;
import java.util.*;

abstract class Stack{
    abstract int length();
    abstract String pop();
    abstract boolean push(String ob);

}

class StackString extends Stack{
    int tos=-1;
    String[] stack = new String[length()];

    @Override
    int length() {
        return 5; //5개의 문자열
    }

    @Override
    String pop() {
        if(tos==-1){
            System.out.println("underflow");
            return "";
        }
        else{
            String tmp=stack[tos];
            stack[tos--]=null;
            return tmp;
        }
    }

    @Override
    boolean push(String ob) {
        if(tos==stack.length){
            System.out.println("overflow");
            return false;
        }
        else{
            stack[++tos]=ob;
            return true;
        }
    }
}

public class StackManager {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stack ob = new StackString();

        System.out.print(">> ");

        for(int i=0;i<ob.length();i++) {
            ob.push(s.next());
        }
        for(int i=0;i<ob.length();i++){
            System.out.print(ob.pop()+" ");
        }
    }
}

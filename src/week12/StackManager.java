package week12;
import java.util.*;

abstract class Stack{
    abstract int length();
    abstract String pop();
    abstract boolean push(String ob);

}

class StackString extends Stack{
    int topOfStack=0;
    String[] stack = new String[length()];

    @Override
    int length() {
        return 5; //5개의 문자열
    }

    @Override
    String pop() {
        if(topOfStack==0){
            System.out.println("underflow");
            return "";
        }
        else{
            topOfStack--;
            return stack[topOfStack];
        }
    }

    @Override
    boolean push(String ob) {
        if(topOfStack>stack.length){
            System.out.println("overflow");
            return false;
        }
        else{
            stack[topOfStack]=ob;
            topOfStack++;
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

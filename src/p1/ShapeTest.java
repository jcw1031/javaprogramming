package p1;

import java.util.*;

class Shape{
    private int a, b, c;

    public Shape(int a){
        this.a=a;
        System.out.println("직선의 길이는 : "+a);
    }

    public Shape(int a, int b){
        this.a=a;
        this.b=b;
        System.out.println("직사각형의 넓이는 : "+a*b);
    }

    public Shape(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
        System.out.println("직육면체의 부피는 : "+a*b*c);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String input;
        Shape ss;

        while (true) {
            System.out.println("수치를 입력하세요 (1개 : 직선, 2개 : 직사각형, 3개 : 직육면체)");
            input = s.nextLine();
            String[] split = (input.split(" "));
            if (split.length == 0 || split.length > 3) {
                System.out.println("1개 ~ 3개의 수치를 입력하세요.");
            } else {
                int[] figure = new int[split.length];
                for (int i = 0; i < figure.length; i++) {
                    figure[i] = Integer.parseInt(split[i]);
                }
                if (figure.length == 1) {
                    ss = new Shape(figure[0]);
                    break;
                } else if (figure.length == 2) {
                    ss = new Shape(figure[0], figure[1]);
                    break;
                } else
                    ss = new Shape(figure[0], figure[1], figure[2]); 
                break;
            }
        }
    }
}

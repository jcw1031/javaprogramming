package p1;
import java.net.spi.URLStreamHandlerProvider;
import java.util.*;

class Shape{
    int a, b, c;
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
        Scanner s=new Scanner(System.in);

        int[] a= new int[] {Integer.parseInt(null)};
        int i;
        Shape ss;

        System.out.println("수치를 입력하세요 (1개 : 직선, 2개 : 직사각형, 3개 : 직육면체)");
        for(i=0;i<3;i++){
            a[i]=s.nextInt();
            if(a[i]==Integer.parseInt(null)) break;
        }
        if(i==0) ss=new Shape(a[0]);
        else if(i==1) ss=new Shape(a[0], a[1]);
        else ss= new Shape(a[0], a[1], a[2]);
    }
}
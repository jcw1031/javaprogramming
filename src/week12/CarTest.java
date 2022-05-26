package week12;

abstract class Car{
    String name; //자동차 이름
    int price; //자동차 가격
    void printInfo(){ //자동차 정보 출력 메소드
        System.out.print("name : "+this.name);
        System.out.println("\t\tPrice : "+this.price);
    }
    abstract void printSignature(); //추상 메소드
}
class Benz extends Car{
    public Benz(int price){ //이름과 가격을 초기화하는 생성자
        this.name="Benz";
        this.price=price;
    }
    public void printSignature(){ //Benz의 시그니처 출력 메소드
        System.out.println("Mercedes-Benz");
    }
}
class Bmw extends Car{
    public Bmw(int price){ //이름과 가격을 초기화하는 생성자
        this.name="Bmw";
        this.price=price;
    }
    public void printSignature(){ //Bmw의 시그니처 출력 메소드
        System.out.println("Bayerische Motoren Werke");
    }
}

public class CarTest {
    public static void main(String[] args) {
        Benz benz=new Benz(120000000);
        Bmw bmw=new Bmw(85000000);

        benz.printInfo(); //Benz 정보
        bmw.printInfo(); //Bmw 정보
        benz.printSignature(); //Benz 시그니처
        bmw.printSignature(); //Bmw 시그니처
    }
}

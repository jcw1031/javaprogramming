package week12;

abstract class Car{
    String name; //자동차 이름
    int price; //자동차 가격
    void printInfo() { //자동차 정보 출력 메소드
        System.out.println("차 이름은 " + this.name+"이고, 가격은 "+this.price+"입니다.");
    }
    abstract void printSignature(); //추상 메소드
}
class Benz extends Car{
    public Benz(int price){ //이름과 가격을 초기화하는 생성자
        this.name="Benz";
        this.price=price;
    }
    public void printSignature(){ //Benz의 시그니처 출력 메소드
        System.out.println("벤츠는 길에서 자주 보입니다.");
    }
}
class Bmw extends Car{
    public Bmw(int price){ //이름과 가격을 초기화하는 생성자
        this.name="Bmw";
        this.price=price;
    }
    public void printSignature(){ //Bmw의 시그니처 출력 메소드
        System.out.println("BMW는 내가 좋아하는 차입니다.");
    }
}

public class CarTest {
    public static void main(String[] args) {
        Benz benz=new Benz(5000);
        Bmw bmw=new Bmw(4500);

        benz.printInfo(); //Benz 정보
        bmw.printInfo(); //Bmw 정보
        benz.printSignature(); //Benz 시그니처
        bmw.printSignature(); //Bmw 시그니처
    }
}

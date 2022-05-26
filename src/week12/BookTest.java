package week12;
import java.util.*;

abstract class Book{
    String name; //책 이름
    int price; //책 가격
    public Book(String name, int price){ //생성자. 책 이름과 책 가격 초기화
        this.name=name;
        this.price=price;
    }
    abstract void printInfo(); //추상 메소드
    abstract double salePrice(); //추상 메소드
}

class Comic extends Book{
    public Comic(String name, int price){ //생성자. 책 이름, 책 가격 초기화
        super(name, price);
    }@Override
    public void printInfo(){ //추상 메소드 오버라이딩. 책 정보 출력
        System.out.printf("책의 이름은 '%s'이고 장르는 만화책입니다.\n판매 가격은 %.0f원 입니다.\n", this.name, this.salePrice());
    }
    public double salePrice(){ //추상 메소드 오버라이딩. 할인률 계산
        return this.price*0.9;
    }
}

class Fiction extends Book{
    public Fiction(String name, int price){ //생성자. 책 이름, 책 가격 초기화
        super(name, price);
    }
    public void printInfo(){ //추상 메소드 오버라이딩. 책 정보 출력
        System.out.printf("책의 이름은 '%s'이고 장르는 소설입니다.\n판매 가격은 %.0f원 입니다.\n", this.name, this.salePrice());
    }
    public double salePrice(){ //추상 메소드 오버라이딩. 할인률 계산
        return this.price*0.85;
    }
}

class Magazine extends Book{
    public Magazine(String name, int price){ //생성자. 책 이름, 책 가격 초기화
        super(name, price);
    }
    public void printInfo(){ //추상 메소드 오버라이딩. 책 정보 출력
        System.out.printf("책의 이름은 '%s'이고 장르는 잡지입니다.\n판매 가격은 %.0f원 입니다.\n", this.name, this.salePrice());
    }
    public double salePrice(){ //추상 메소드 오버라이딩. 할인률 계산
        return this.price*0.95;
    }
}

class BookStore{
    Scanner s = new Scanner(System.in);

    Book[] books; //Book 클래스 배열

    public BookStore(int num){ //생성자. Book 클래스 배열 객체 초기화
        books=new Book[num];
    }
    public void setBooks(){ //책 정보 입력받는 메소드
        for(int i=0;i<books.length;i++){
            System.out.print("책 이름 : ");
            String name=s.next();
            System.out.print("책 가격 : ");
            int price=s.nextInt();
            System.out.print("책 장르 (1 : 코믹 / 2 : 소설 / 3 : 잡지) : ");
            int divide=s.nextInt();
            System.out.println("-------------------------------------------");

            switch (divide) {
                case 1 -> books[i] = new Comic(name, price);
                case 2 -> books[i] = new Fiction(name, price);
                case 3 -> books[i] = new Magazine(name, price);
            }
        }
    }
    public void printBooksInfo(){ //서점에서 판매하는 모든 책 정보를 출력
        for(int i=0;i<books.length;i++){
            books[i].printInfo();
        }
    }
}

public class BookTest {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.print("서점에서 파는 책의 개수 : ");
        int n=s.nextInt();
        System.out.println("-------------------------------------------");

        BookStore store=new BookStore(n);
        store.setBooks();
        store.printBooksInfo();
    }
}

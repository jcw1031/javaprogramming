package week14;
import java.util.*;

abstract class GameObject{
    protected int distance; //한 번 이동 거리
    protected int x, y; //현재 위치 (화면 맵 상의 위치)
    //static int count=0; //fish가 5번 중 4, 5번 째에 이동할 수 있도록 횟수를 세는 용도

    public GameObject(int startX, int startY, int distance){ //초기 위치와 이동 거리
        this.x=startX;
        this.y=startY;
        this.distance=distance;
    }
    public int getX(){return x;}
    public int getY(){return y;}

    public boolean collide(GameObject p){ //이 객체가 객체 p와 충돌했으면 true 리턴
        if(this.x==p.getX() && this.y==p.getY()){
            return true;
        }
        else
            return false;
    }
    protected abstract void move(); //이동한 후의 새로운 위치로 x, y 변경
    protected abstract char getShape(); //객체의 모양을 나타내는 문자 리턴
}

class Bear extends GameObject{
    private String c;
    public Bear(int startX, int startY, int distance) { //x와 y, 한 번에 이동할 칸 수 매개변수로 입력
        super(startX, startY, distance); //상위 클래스 생성자
    }

    public void setC(String c){ //Bear의 문자열 변수 c에 문자열을 저장하는 메소드
        this.c=c;
    }

    @Override
    protected void move() { //새로운 위치를 설정하는 메소드
        if(c.equals("d") && x<19){ //영역을 벗어나지 않도록 범위 고려
            x+=distance;
        }
        else if(c.equals("a") && x>0){
            x-=distance;
        }
        else if(c.equals("w") && y>0){
            y-=distance;
        }
        else if(c.equals("s") && y<9){
            y+=distance;
        }
        else{
            System.out.print("\n\n키를 잘 입력해 주세요."); //범위를 벗어나는 키를 입력하면 잘 입력하라는 문구 출력
        }
        //count++; //count 1 증가
    }

    @Override
    protected char getShape() {
        return 'B';
    }
}

class Fish extends GameObject{
    public Fish(int startX, int startY, int distance) { //x와 y, 한 번에 이동할 칸 수 초기화
        super(startX, startY, distance); //상위 클래스 생성자
    }

    @Override
    protected void move() { //새로운 위치를 설정하는 메소드
        //if (count % 5 == 4 || count % 5 == 0) { //5번 중 4, 5번째에 이동
            int ran = (int) (Math.random() * 4); //0~3 네 개의 수 중에 임의로 한 수를 ran에 저장
            switch (ran) {
                case 0: {
                    if (x < 19) x += distance; //fish가 범위를 벗어나지 않도록 조건문 사용
                    break;
                }
                case 1: {
                    if (x > 0) x -= distance;
                    break;
                }
                case 2: {
                    if (y < 9) y += distance;
                    break;
                }
                case 3: {
                    if (y > 0) {
                        y -= distance;
                        break;
                    }
                }
            }
        System.out.print("물고기 움직임");
        }
    //}
    @Override
    protected char getShape() {
        return '@';
    }
}

public class BearFishGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count=0;

        Bear b = new Bear(0, 0, 1); //Bear 클래스 객체 생성 -> x : 0, y : 0, 한 번에 이동할 칸 수 : 1
        Fish f = new Fish((int) (Math.random() * 20), (int) (Math.random() * 10), 1);
        //Fish 클래스 객체 생성 -> x : 0~19 중 랜덤한 수, y : 0~9 중 랜덤한 수, 한 번에 이동할 칸 수 : 1

        while (!b.collide(f)) { //Bear와 Fish가 만나면 반복문 종료
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    if (b.getX() == j && b.getY() == i) System.out.print(b.getShape()); //만약 Bear의 x와 y값이 i, j이면 'B' 출력
                    else if (f.getX() == j && f.getY() == i) System.out.print(f.getShape()); //만약 Fish의 x, y 값이 i, j이면 '@' 출력
                    else System.out.print('-');
                }
                System.out.println();
            }

            System.out.print("→ : d\t ← : a\t ↑ : w\t ↓ : s\t\t 입력 : ");
            b.setC(s.next()); //Bear 객체의 c에 입력받은 문자열 저장
            b.move(); //새로운 위치를 설정하는 메소드 호출
            count++;
            if(count%5==4 || count%5==0) {
                f.move(); //새로운 위치를 설정하는 메소드 호충
            }
            System.out.println("\n");
        }
        System.out.println("Bear Wins!"); //Bear와 Fish가 만나서 반복문이 종료. Bear Wins!
    }
}
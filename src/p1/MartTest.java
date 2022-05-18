package p1;

import java.util.*;

class Mart{
    private int purchase;
    private boolean member;
    private String id;

    public Mart(int purchase){
        this.purchase=purchase;
    }
    public Mart(boolean member, int purchase){
        this.member=member;
        this.purchase=purchase;
    }

    public void setId(String id){
        this.id=id;
    }

    public void sale(){
        double discount;
        if(this.purchase>100000) discount=0.2;
        else if(this.purchase>50000) discount=0.1;
        else discount=0.05;

        if(this.member){
            discount+=0.1;
            System.out.println("회원 ID : "+this.id+"의 최종 결제 금액은 "+(int)(this.purchase*(1-discount))+"원 입니다.");
        }
        else
            System.out.println("최종 결제 금액은 "+(int)(this.purchase*(1-discount))+"원 입니다.");
    }
}

public class MartTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int purchase;
        String id;
        while(true) {
            System.out.print("구매할 금액을 입력하세요 : ");
            purchase = s.nextInt();
            if(purchase>1000000 || purchase<0){
                System.out.println("구매 금액은 0원 이상 1,000,000이하 이어야 합니다.");
            }
            else
                break;
        }
        Mart A = new Mart(purchase);
        A.sale();

        while(true){
            System.out.print("회원 번호와 금액을 입력하세요 : ");
            id=s.next();
            purchase=s.nextInt();
            if(purchase>1000000 || purchase<0){
                System.out.println("구매 금액은 0원 이상 1,000,000이하 이어야 합니다.");
            }
            else
                break;
        }
        Mart B = new Mart(true, purchase);
        B.setId(id);
        B.sale();
    }
}

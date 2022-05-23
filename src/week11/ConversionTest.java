package week11;
import java.util.*;

class Conversion {
    private int num = 0;
    private String bin = "";
    private String hex = "";

    //---------------------------------------------------------------- 10진수 -> 2진수
    public void toBinary(int num) {
        this.num = num;
        while (num > 1) { //1/2는 정수형으로 0이므로 1이 아닐 때만 연산 수행 (num이 1이 되면 bin=num+bin)
            bin = num % 2 + bin; //나머지는 1 아니면 0. bin 문자열의 맨 앞에 나머지를 추가
            num /= 2; //num을 2로 나눈 몫을 저장
        }
        bin = num + bin; //num이 1이 되어 while 문이 종료되고 마지막 1을 bin의 맨 앞에 더함.
    }

    //---------------------------------------------------------------- 10진수 -> 16진수
    public void toHex(int num){
        while (num >= 10) { //10보다 크거나 같을 때 수행
            if (num % 16 >= 10) { //num을 16으로 나눈 나머지가 10 이상이면 수행
                hex = (char) (num % 16 + 55) + hex; //아스키코드 이용. 10+55='A'...
            } else {
                hex = num % 16 + hex; //hex 문자열 앞에 나머지를 추가
            }
            num /= 16; //num을 16으로 나눈 몫을 저장
        }
        hex = num + hex; //hex 문자열 앞에 num 추가
    }

    //---------------------------------------------------------------- 2진수 -> 16진수
    public void binaryToHex(String bin){
        this.bin=bin;
        int exponent=0; //지수부로 사용
        String sub; //입력받은 2진수에서 계산할 부분을 저장하는 용도
        int count=bin.length()/4; //for문 반복 횟수를 결정하기 위한 용도
        int temp=0; //hex 문자열에 추가하기 전 정수형으로 저장하기 위한 용도

        if(bin.length()%4!=0){ //입력받은 2진수가 4자리로 나누어 떨어지지 않는 경우
            int index=bin.length()%4; //bin 길이를 4로 나눈 나머지를 index에 저장
            sub=bin.substring(0, index); //문자열의 첫 번째부터 index 전 까지 문자열을 sub에 저장
            bin=bin.substring(index); //sub에 저장하고 남은 문자열을 다시 bin에 저장

            for(int i=sub.length();i>0;i--){ //sub 문자열 길이부터
                if(sub.charAt(i-1)=='1'){
                    temp+=Math.pow(2, exponent);
                    exponent++;
                }
                else{
                    exponent++;
                }
            }
            this.hex+=temp;
        }

        for(int i=0;i<count;i++){
            exponent=0;
            temp=0;
            sub=bin.substring(0, 4);
            bin=bin.substring(4);

            for(int j=4;j>0;j--){
                if(sub.charAt(j-1)=='1'){
                    temp+=Math.pow(2, exponent);
                    exponent++;
                }
                else{
                    exponent++;
                }
            }

            if(temp>=10){
                this.hex+=(char)(temp+55);
            }
            else{
                this.hex+=temp;
            }
        }
    }

    //---------------------------------------------------------------- 16진수 -> 2진수
    public void hexToBinary(String hex){
        this.hex=hex;

    }

    //---------------------------------------------------------------- 2진수 -> 10진수
    public void binaryToNum(String bin){

    }

    //---------------------------------------------------------------- 16진수 -> 10진수
    public void hexToNum(String hex){

    }

    //---------------------------------------------------------------- 출력 함수
    public void printNum(){ //10진수 출력
        System.out.println("10진수 : "+num);
    }
    public void printBinary(){ //2진수 출력
        System.out.println("2진수 : "+bin);
    }
    public void printHex(){ //16진수 출력
        System.out.println("16진수 : "+hex);
    }
}

public class ConversionTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Conversion conversion = new Conversion();

        System.out.print("진법과 값 입력 : ");
        int notation = s.nextInt();

        if(notation == 10){
            int value=s.nextInt();
            conversion.toBinary(value);
            conversion.toHex(value);
        }
        else if(notation == 2){
            String value = s.next();
            conversion.binaryToNum(value);
            conversion.binaryToHex(value);
        }
        else{
            String value = s.next();
            conversion.hexToNum(value);
            conversion.hexToBinary(value);
        }
        conversion.printNum();
        conversion.printBinary();
        conversion.printHex();
    }
}
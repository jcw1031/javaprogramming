package week11;
import java.util.*;

class Conversion {
    private int num = 0; //10진수 저장하는 변수
    private String bin = ""; //2진수 저장하는 변수
    private String hex = ""; //16진수 저장하는 변수
    private int temp=0; //hex, bin 문자열에 추가하기 전 정수형으로 저장하기 위한 용도
    private int count; //for문 반복 횟수 결정하기 위한 변수
    private String sub = ""; //입력받은 2진수, 16진수에서 계산할 일부분을 저장하는 용도
    private int exponent=0; //지수부로 사용

    //---------------------------------------------------------------- 10진수 -> 2진수
    public void toBinary(int num) {
        this.num = num;
        while (num > 1) { //1/2는 정수형으로 0이므로 1보다 클 때만 연산 수행
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
        temp=0;
        exponent=0;
        count=bin.length()/4; //for문 반복 횟수를 결정

        if(bin.length()%4!=0){ //입력받은 2진수가 4자리로 나누어 떨어지지 않는 경우
            int index=bin.length()%4; //bin 길이를 4로 나눈 나머지를 index에 저장
            sub=bin.substring(0, index); //문자열의 첫 번째부터 index 전 까지 문자열을 sub에 저장
            bin=bin.substring(index); //sub에 저장하고 남은 문자열을 다시 bin에 저장

            for(int i=sub.length();i>0;i--){ //sub 문자열 길이부터
                if(sub.charAt(i-1)=='1'){ //sub 문자열에서 i 인덱스에 있는 값이 1이면
                    temp+=Math.pow(2, exponent); //temp에 2의 exponent 승을 더함
                    exponent++;
                }
                else{
                    exponent++;
                }
            }
            this.hex+=temp;
        }

        for(int i=0;i<count;i++){ //입력받은 2진수의 길이를 4로 나눈 값 만큼 반복
            exponent=0; //지수부 초기화
            temp=0; //임시 저장 변수 초기화
            sub=bin.substring(0, 4); //sub에 bin 문자열의 0~3번째 문자열 저장
            bin=bin.substring(4); //sub에 저장하고 남은 문자열 bin에 저장

            for(int j=4;j>0;j--){ //4번 반복
                if(sub.charAt(j-1)=='1'){ //sub 문자열의 j 인덱스에 있는 값이 1이면
                    temp+=Math.pow(2, exponent); //temp에 2의 exponent 승을 더함
                    exponent++;
                }
                else{
                    exponent++;
                }
            }

            if(temp>=10){ //만약 temp 값이 10 이상이면
                this.hex+=(char)(temp+55); //아스키 코드를 사용하여 16진수(A : 10 등) 알파벳으로 변환 후 더함
            }
            else{
                this.hex+=temp; //아니면 그냥 더함
            }
        }
    }

    //---------------------------------------------------------------- 16진수 -> 2진수
    public void hexToBinary(String hex){
        this.hex=hex;
        count=hex.length();
        for(int i=0;i<count;i++){ //hex 문자열의 길이 만큼 반복
            char sub = hex.charAt(hex.length()-1); //아래에서 isAlphabetic 사용을 위해 char형으로 선언
            hex=hex.substring(0, hex.length()-1); //맨 뒤에 문자 하나 빼고 나머지 문자열을 다시 hex에 저장

            if(Character.isAlphabetic(sub)){ //만약 sub에 저장했던 문자가 알파벳이면 수행
                temp = sub-55; //아스키 코드 이용
            }
            else temp = sub-48; //아스키 코드 이용

            while (temp > 1) { //1/2은 정수형으로 0이므로, 1보다 클 때만 연산 수행
                bin = temp % 2 + bin; //나머지는 1 아니면 0. bin 문자열의 맨 앞에 나머지를 추가
                temp /= 2; //temp를 2로 나눈 몫을 저장
            }
            bin = temp + bin; //temp가 1이 되어 while 문이 종료되고 마지막 1을 bin의 맨 앞에 더함.
            int zero = bin.length()%4; //4자리를 맞춰주기 위해 사용하는 변수
            if(zero!=0) {
                for (int j = 0; j < 4 - zero; j++) {
                    bin = '0' + bin; //4자리 맞춰주기 위해 0 추가
                }
            }
        }
        if(bin.indexOf("1")!=-1) //입력된 값이 0이 아닐 경우 실행
            bin=bin.substring(bin.indexOf("1")); //만약 맨 앞에 0이 있게 되면 무시하고 저장
        else //입력된 값이 0인 경우
            bin="0";
    }

    //---------------------------------------------------------------- 2진수 -> 10진수
    public void binaryToNum(String bin){
        count = bin.length();

        for(int i=count;i>0;i--){ //bin 문자열 길이부터
            temp+=(bin.charAt(i-1)-48)*Math.pow(2, exponent); //temp에 2의 exponent 승과 bin의 i-1 인덱스에 있는 값을 곱하여 더함
            exponent++;
        }
        this.num=temp; //temp 값을 num에 저장
    }

    //---------------------------------------------------------------- 16진수 -> 10진수
    public void hexToNum(String hex){
        count=hex.length();
        temp=0;
        exponent=0;
        for(int i=count;i>0;i--){ //hex 문자열 길이부터
            if(Character.isAlphabetic(hex.charAt(i-1))){ //hex 문자열의 i-1 인덱스에 있는 값이 알파벳이면 수행
                temp+=(hex.charAt(i-1)-55)*Math.pow(16, exponent); //아스키 코드 이용. 16의 exponent 승과 hex의 i-1 인덱스에 있는 값을 곱한 결과를 temp에 더함
                exponent++;
            }
            else{
                temp+=(hex.charAt(i-1)-48)*Math.pow(16, exponent); //아스키 코드 이용. 위와 동일
                exponent++;
            }
        }
        this.num=temp; //temp 값을 num에 저장
    }

    //---------------------------------------------------------------- 출력 함수
    public void printNum(){ //10진수 출력
        System.out.println("10진수 : "+num);
    } //10진수 값 출력
    public void printBinary(){ //2진수 출력
        System.out.println("2진수 : "+bin);
    } //2진수 값 출력
    public void printHex(){ //16진수 출력
        System.out.println("16진수 : "+hex);
    } //16진수 값 출력
}

public class ConversionTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Conversion conversion = new Conversion(); //Conversion 클래스의 객체 생성

        System.out.print("진법과 값 입력(16진수의 경우 영문자는 대문자로 입력) : ");
        int notation = s.nextInt(); //notation 변수에 진법 입력 받기

        if(notation == 10){ //10진수
            int value=s.nextInt(); //값 입력 받기
            conversion.toBinary(value); //10진수 -> 2진수
            conversion.toHex(value); //10진수 -> 16진수
        }
        else if(notation == 2){ //2진수
            String value = s.next(); //값 입력 받기
            conversion.binaryToNum(value); //2진수 -> 10진수
            conversion.binaryToHex(value); //2진수 -> 16진수
        }
        else{ //16진수
            String value = s.next(); //값 입력 받기
            conversion.hexToNum(value); //16진수 -> 10진수
            conversion.hexToBinary(value); //16진수 -> 2진수
        }
        conversion.printNum(); //10진수 출력
        conversion.printBinary(); //2진수 출력
        conversion.printHex(); //16진수 출력
    }
}
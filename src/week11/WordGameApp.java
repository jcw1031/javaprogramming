package week11;
import java.util.*;

class Player{
    Scanner s = new Scanner(System.in);
    private String name;
    private String word;

    public Player(String n){
        this.name=n;
    }
    public void setWord(String w){
        this.word=w;
    }
    public void setName(String n){
        this.name=n;
    }
    public String getWord(){
        return word;
    }
    public String getName(){
        return name;
    }
    public void input(){
        System.out.print(this.name+" : ");
        setWord(s.next());
    }
}

public class WordGameApp {
    static Scanner s = new Scanner(System.in);
    private String startWord;
    Player[] p1;
    int n;

    public WordGameApp() {
        startWord = "와이파이";
    }

    private void createPlayers() {
        System.out.print("게임에 참가하는 인원 수 : ");
        n = s.nextInt();
        p1 = new Player[n];
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print("참가자 이름 : ");
            this.p1[i] = new Player(s.next());
        }
        String word;
        char startText;
        char endText;
        int count = 0;

        System.out.println("시작 단어는 '" + startWord + "'입니다.");
        endText = startWord.charAt(startWord.length() - 1);
        while (true) {
            p1[count % n].input();
            word = p1[count % n].getWord();
            startText = word.charAt(0);
            if (endText != startText) {
                System.out.println(p1[count % n].getName() + "이 졌습니다.");
                break;
            }
            endText = word.charAt(word.length() - 1);
            count++;
        }
    }
    public static void main(String[] args) {
        WordGameApp game1=new WordGameApp();
        game1.createPlayers();
        game1.run();
    }
}
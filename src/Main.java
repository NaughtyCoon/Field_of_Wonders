import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void getOut(){
        System.out.println("Благодарим за игру!");
        scanner.close();
    }

    public static void main(String[] args) {
        String[] Words = {"тыква", "репа", "арбуз", "вишня", "дыня", "яблоко", "морковь", "капуста", "помидор", "брюква"};
        int Range = Words.length;
        int Attempt = 5;
        int GuessedIndex = (int) (Math.random() * Range);
        int N = Words[GuessedIndex].length();
        char[] GuessedMatrix = new char[N];
        Arrays.fill(GuessedMatrix, '*');
        char[] TestCharArray = Words[GuessedIndex].toCharArray();
        System.out.println("   The Buratino Enterprises\n        P R E S E N T S\n F I E L D  O F  W O N D E R S");
        System.out.println();
        boolean GuessedFlag;

        while(true){
            System.out.println("Загадано слово "+ new String(GuessedMatrix));
            System.out.println("Назовите всё слово или угадайте букву. Осталось ошибок: " + Attempt);
            String GuessAttempt = scanner.nextLine().toLowerCase();
            switch(GuessAttempt.length()) {
                case (0):
                    System.out.println("Нужно ввести букву или слово целиком!");
                    break;
                case (1):
                    char GuessedLetter = GuessAttempt.toCharArray()[0];
                    GuessedFlag = false;
                    for (int i = 0; i < Words[GuessedIndex].length(); i++) {
                        if (GuessedLetter == TestCharArray[i]) {
                            GuessedMatrix[i] = TestCharArray[i];
                            GuessedFlag = true;
                        }
                    }
                    if (GuessedFlag) {
                        System.out.println("Есть такая буква!");
                        if (new String(GuessedMatrix).equals(Words[GuessedIndex])) {
                            System.out.println("И Вы угадали слово!");
                            getOut();
                            return;
                        }
                    } else {
                        System.out.println("Увы! Такой буквы нет!");
                        Attempt--;
                        if (Attempt < 1) {
                            System.out.println("Все попытки исчерпаны! Вы проиграли.");
                            getOut();
                            return;
                        }
                    }
                    break;
                default:
                    if (GuessAttempt.equals(Words[GuessedIndex])) {
                        System.out.println("П О З Д Р А В Л Я Е М ! ! !\rВы угадали слово!");
                    } else {
                        System.out.println("Увы! Правильное слово было: " + Words[GuessedIndex] + "! Вы проиграли :(");
                    }
                    getOut();
                    return;

            }
        }
    }
}
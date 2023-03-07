import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main obj = new Main();

        System.out.println("Метод findSymbolOccurance");
        System.out.println("Символ зустрічається - " + obj.findSymbolOccurance("Java", 'a') + " раз/разів");

        System.out.println();

        System.out.println("Метод findWordPosition");
        System.out.println("Result : " + obj.findWordPosition("Apollo", "pollo" ));
        System.out.println("Result : " + obj.findWordPosition("Apple", "Plant" ));

        System.out.println();

        System.out.println("Метод stringReverse");
        System.out.println("Result : " + obj.stringReverse("Hello"));

        System.out.println();

        System.out.println("Метод isPalindrome");
        System.out.println(obj.isPalindrome("ERE"));
        System.out.println(obj.isPalindrome("Allo"));

        System.out.println();
        System.out.println();

        System.out.println("Гра - вгадай слово");
        obj.guessWord();
    }

    public int findSymbolOccurance(String str, char ch) {

        char[] letters = str.toCharArray();
        int count = 0;

        for ( int i = 0; i < letters.length; i++ ) {
            if ( letters[i] == ch ) {
                count++;
            }
        }
        return count;
    }

    public int findWordPosition(String source, String target) {

        int index = source.indexOf(target);
        if (index != -1) {
            return index;
        } else {
            return -1;
        }
    }

    public String stringReverse(String simpleString) {

        char[] stringInLetters = simpleString.toCharArray();
        String result = "";

        for ( int i = stringInLetters.length - 1; i >= 0; i--) {
            result += String.valueOf(stringInLetters[i]);
        }
        return result;
    }

    public boolean isPalindrome(String source) {

        String lower = source.toLowerCase();
        char[] sourceInLetters = lower.toCharArray();
        String reverseWord = "";

        for ( int i = sourceInLetters.length - 1; i >= 0; i--) {
            reverseWord += String.valueOf(sourceInLetters[i]);
        }

        if (lower.equals(reverseWord)) {
            return true;
        } else {
            return false;
        }
    }

    public void guessWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};

        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int randomNum = random.nextInt(25);
        String word = words[randomNum];
        String playerChoice = "";

        do {
            System.out.println("Спробуй вгадати слово, яке я загадав!");
            playerChoice = input.nextLine().toLowerCase();

            if (playerChoice.equals(word)) {
                System.out.println("Ти вгадав!");
                break;
            } else {
                System.out.println("Не вгадав! Вот тобі підказка");
                sameLetters(word, playerChoice);
            }
        } while (word != playerChoice) ;
    }

    public void sameLetters(String word, String playerChoice) {

        char[] wordInLetters = word.toCharArray();
        char[] playerChoiceInLetters = playerChoice.toCharArray();
        int gridLength = 15;
        char[] gridInLetters = new char[gridLength];

        for ( int k = 0; k < gridLength; k++ ) {
            gridInLetters[k] = '#';
        }

        for ( int i = 0; i < wordInLetters.length; i++ ) {
            for ( int j = 0; j < playerChoiceInLetters.length; j++ ) {
                if ( wordInLetters[i] == playerChoiceInLetters[j]) {
                    gridInLetters[i] = wordInLetters[i];
                }
            }
        }
        System.out.println(gridInLetters);
    }
}
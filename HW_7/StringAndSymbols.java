import java.util.Scanner;

public class StringAndSymbols {
    public static void main(String[] args) {
// 2.
        String text = "t9jht45_t4";
        char findSymbol = 't';
        int number;
        number = findSymbolOccurence(text, findSymbol);
        System.out.printf("Символ '%s' зустрічається в переданому тексті %d рази(ів)\n", findSymbol, number );

// 3.
        String source = "Apollo";
        String target = "pollo";
        System.out.println(findWordPosition(source, target));

// 4.
        String sourceText = "Hello";
        String reverseText;
        reverseText = stringReverse(sourceText);
        System.out.println(reverseText);

// 5.
        String testingText = "ERE";
        System.out.printf("Слово %s являється паліндромом %b\n", testingText , isPalindrome(testingText));

// 5.
        System.out.println("----------------------------------");
        guessWord();
    }



    public static int findSymbolOccurence(String text, char findSymbol) {
        int counter = 0;
        char[] chars = text.toCharArray();
        for (char aChar : chars) if (findSymbol == aChar) counter++;
        return counter;
    }

    public static int  findWordPosition(String source, String target){
        return source.indexOf(target);
    }

    public static String stringReverse(String sourceText) {
        StringBuilder reverseText = new StringBuilder();
        for (int i = 0; i < sourceText.length(); i++) {
            reverseText.append(sourceText.charAt(sourceText.length() - 1 - i));
        }
        return reverseText.toString();
    }

    public static boolean isPalindrome(String sourceText) {
        String reverseText = new StringBuilder(sourceText).reverse().toString();
        return sourceText.equalsIgnoreCase(reverseText);
    }


    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado" , "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        int number = (int) (Math.random() * words.length);
        String guessWorld = words[number];
        System.out.println(guessWorld);


        System.out.println("Почнемо гру \"Вгадай слово!\" для виходу з гри, натисніть \"Enter\" ");
        Scanner scanner = new Scanner(System.in);
        String answer;

        while (true) {
            System.out.println("Введіть ваше слово: ");
            answer = scanner.nextLine();

            if (answer.equals("")) {
                System.out.println("Ви хочете вийти з гри?\n натисніть Y - так, N - ні" );
                if (scanner.nextLine().equalsIgnoreCase("Y")) break;
            }

            if (answer.equals(guessWorld)) {
                System.out.printf("Вам щастить ви вгадали слово %s", guessWorld);
                break;
            } else {
                System.out.println("Ви не вгадали слово. Спробуйте ще раз!");
                int lengthWorld = Math.min(answer.length(), guessWorld.length());
                for (int i = 0; i < 15 ; i++) {
                    if (i < lengthWorld) {
                        if (guessWorld.charAt(i) == answer.charAt(i)) System.out.print(guessWorld.charAt(i));
                        else System.out.print('#');
                    } else System.out.print('#');
                }
                System.out.println('#');
            }
        }
    }

}
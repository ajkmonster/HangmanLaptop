import java.util.*;

public class HangmanLaptop {
    private static ArrayList<String> words = new ArrayList<>();
    private static String[] splitStr = new String[]{};
    private static String[] list = new String[]{"","","","","","","","","","",""};
    private static String[] list2 = new String[]{"","","","","","","","","","",""};
    private static String[] list3 = new String[]{"","","","","","","","","","",""};
    private static int index;
    private static int wrongNum=0;
    private static String results;
    private static String userGuess;
    public static void main(String[] args) {
        initializeWords();
        welcomeMessage();
        lettersOfWord();
        intcharNumber();
        wordThinking();
        game();
        wonGame();
    }

    private static void welcomeMessage() {
        System.out.println("Welcome to Hangman!");
    }

    private static void initializeWords() {
        Collections.addAll(words, "tree", "rain", "bear", "encourage", "promise", "soup", "chess",
                "insurance", "pancakes", "stream");
    }

    private static void randomgenerator() {
        Random random = new Random();
        index = random.nextInt(words.size());
    }

    private static void lettersOfWord() {
        randomgenerator();
        splitStr = words.get(index).split("");
    }

    private static void game() {

           do {
               System.out.println("Please enter your guess: ");
               Scanner key = new Scanner(System.in);
               userGuess = key.nextLine().toLowerCase();
               if (wrongNum>=6) {
                   break;
               }
               if (!userGuess.equalsIgnoreCase(words.get(index))) {
                   for (int i = 0; i < splitStr.length; i++) {
                       if (splitStr[i].equalsIgnoreCase(userGuess)) {
                           list[i] = userGuess;
                           stringJoiner();
                       }
                   }
                   wrongChecker();
                   yourGuess();
               } else if (userGuess.equalsIgnoreCase(words.get(index))){
                   break;
               }
           }while(!words.get(index).equalsIgnoreCase(results));
    }

    private static void intcharNumber() {
        for (int i = 0; i < splitStr.length; i++) {
            list[i] = "-";
        }
    }

    private static void wordThinking() {
        System.out.print("The word I'm thinking of: ");
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println("\n");
    }
    private static void yourGuess() {
        System.out.print("Your guess so far: ");
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println("\n");
    }
    private static void stringJoiner() {
        list2 = list;
        results = String.join("", list2);
    }
    private static void wonGame() {
        if (wrongNum < 6) {
            System.out.println("You've won the game congrats!");
        } else {
            System.out.println("Sorry, you have no more guesses left. The word was "+words.get(index));
        }
    }
    private  static void wrongChecker (){
        list3 = list;
        boolean contains = false;
        for (String c:list3){
            if (c.equalsIgnoreCase(userGuess)) {
                contains = true;
            }
        }
        if (!contains) {
            wrongNum+=1;
        }
        System.out.println("You've guessed wrong "+wrongNum+"/6 times.");
    }
}

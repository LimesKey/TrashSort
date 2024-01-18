package trashsort;

import java.util.InputMismatchException;
import java.util.OptionalInt;
import java.util.Scanner;

public class TrashSort {
    public static final String ANSI_PURPLE = "\033[0;35m";  //IMPORT COLORS TO JAZZ IT UP! 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String CYAN = "\033[0;36m";

    public class Item {
        public String name;
        public TrashClassification classification;
        public int difficulty;
        public OptionalInt points;

        public Item(String name, TrashClassification classification, int difficulty, OptionalInt points) {
            this.name = name;
            this.classification = classification;
            this.difficulty = difficulty;
            this.points = points;
        }
    }

    public enum TrashClassification {
        RECYCLE,
        COMPOST,
        LANDFILL,
        SPECIAL // HAZARDOUS
    }

    public static class Player {
        public String name;
        public int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Item[] itemDatabase = ItemDb.ItemDBCreator(); // fetches the Item database from another file's function
        int bonusPoints = 0;
        int intro_decision = 0;
        int sanitizedDifficulty;
        int player_amount;

        while (!(intro_decision >= 1 && intro_decision <= 3)) {
            System.out.println(CYAN + "WELCOME TRASH-SORTING-SIMULATOR!" + ANSI_RESET);

            System.out.println
            ("\nWould you like to: " +
            "\n1.Play the game" +
            "\n2.Help" +
            "\n3.Exit");

            System.out.print("Choice: ");
            intro_decision = Integer.parseInt(scanner.nextLine());

            if (intro_decision == 3) {
                break;
            }

            switch (intro_decision) {
                case 2: {   // IF they want "help" or clarification on the program:
                    System.out.println("The purpose of this game is to have you" +
                    "(the user) \nassort various " +
                    "COMPOST,RECYCLING, or GARBAGE\nitems into the correct" +
                    " trash bins." +
                    "\nFOR EXAMPLE: Plastic Straws would go in the garbage.");
                }
            
                case 1: { // IF they want to play the game
                        // CREATE ENTIRE GAME MENU GUI IF THEY WANT TO PLAY THE GAME! 
                        System.out.println(ANSI_GREEN + "\nDESCRIPTION:" + ANSI_RESET);
                        System.out.println(" A trash-sorting game in which a user receives " +
                        "random items and their task\n is sorting them in the " +
                        "correct corresponding trash bins. The more they get correct,\n " +
                        "the harder it gets. Score 9 correct points and you win!!");
                        System.out.print(ANSI_GREEN + "\t\t\t\t\tGOODLUCK!\n" + ANSI_RESET);
                        System.out.println(CYAN + "\n ** NOTE. 1 = Garbage, 2 = Recycling, " +
                        "3 = Compost **" + ANSI_RESET);
                        break;
                    }
                case 3: System.out.println("Ending program..."); // if they want to end it
    
                default: {
                    System.err.println("Invalid input, please try again!");
                }
            }

            do {
                System.out.println("Please enter the amount of players: ");
                player_amount = Integer.parseInt(scanner.nextLine());
            } while (player_amount < 0 || player_amount > 10);

            Player[] player_list = new Player[player_amount];

            for (int i = 0; i < player_amount; i++) {
                System.out.println("Please enter the name for player " + (i + 1) + ": ");
                player_list[i] = new Player((scanner.nextLine().strip()), 0);
            }

            while (true) {
                System.out.println("\nPlease choose your difficulty level, normal, hard, extreme or adaptive (either type in word or number)");
                System.out.print("Game Difficulty: ");
                String difficulty = scanner.nextLine();

                try {
                    sanitizedDifficulty = matchDifficultyText(difficulty.toLowerCase().strip());
                    break;
                } 
                catch (InputMismatchException e) {
                    System.out.println("Invalid difficulty! Please try again!");
                    System.out.print(" You entered: " + difficulty);
                    System.out.println("Error message: " + e);
                }
            }

            long start = System.nanoTime();
            if (sanitizedDifficulty == 4) {
                Player[] new_player_list = adaptive(itemDatabase, player_list, bonusPoints);
                for (int i = 0; i < new_player_list.length; i++) {
                    System.out.println("Player " + player_list[i].name + " has a score of " + player_list[i].score);
                }
            }

            else {
                // classical function
            }
            
            long end = System.nanoTime();
            long elapsedTime = (end - start) / 1000000000;

            System.out.println("Game Over! Elapsed Time: " + elapsedTime + " seconds");
        }
        scanner.close();
    }

    public static Player[] adaptive(Item[] itemDatabase, Player[] player_list, int bonusPoints) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting Adaptive difficulty round, it will get increasingly hard until you get 3 wrong answers or exhaust the database.");
        int player_count = player_list.length;
        int track_difficulty = 0;

        for (int difficulty = 0; difficulty < 4; difficulty++) {
            track_difficulty++;

            if (difficulty > track_difficulty) {
                System.out.println(ANSI_YELLOW + "Level up, difficulty is now " + difficulty + "!" + ANSI_RESET);
            }
            else {
                System.out.println("Current Difficulty: " + difficulty);
            }

            int possible_items = 0;
            for (int j = 0; j < itemDatabase.length; j++) {
                if (itemDatabase[j] != null && itemDatabase[j].difficulty == difficulty) {
                    possible_items++;
                }
            }
            
            Item[] available_items = new Item[possible_items];
            
            int count = 0;
            for (int j = 0; j < itemDatabase.length && count < available_items.length; j++) {
                if (itemDatabase[j] != null && itemDatabase[j].difficulty == difficulty) {
                    available_items[count++] = itemDatabase[j];
                }
            }
        
            int avail_split = (int) Math.floorDiv(available_items.length, player_count);
            System.out.println("Each player will get " + avail_split + " items.");
            int logical_round = 0;
            for (int player = 0; player < (player_count); player++) {
                System.out.println(ANSI_RED + "\n\n" + player_list[player].name + " (" + (player + 1) + " of " + player_count + "), " + "it is your turn." + ANSI_RESET);
                int visualized_round = 0;
                for (; logical_round < (avail_split * (player + 1)); logical_round++)  {
                    visualized_round++;
                    System.out.println(ANSI_PURPLE + "Round " + visualized_round + " of " + avail_split + " for " + player_list[player].name +"!" + ANSI_RESET);
                    System.out.println("Item " + visualized_round + ": "+ ANSI_GREEN + available_items[logical_round].name + ANSI_RESET);
                    System.out.println("To which container does this item belong to?");
                    System.out.println("\tPlease choose your answer by typing in a word: Recycle, Compost, Landfill, Special\n");
                    System.out.print("Answer: ");

                    String userAnswer = scanner
                    .nextLine() // scan next line
                    .toLowerCase() // convert to lowercase
                    .strip() // strip leading whitespace
                    .replaceAll("[^\\p{ASCII}]", ""); // use regex to replace non-ascii characters

                    String correctAnswer = available_items[logical_round].classification.toString().toLowerCase();

                    if (userAnswer.equals(correctAnswer)) {
                        System.out.println("Correct!");
                        if (available_items[logical_round].points.isPresent()) {
                            player_list[player].score += available_items[logical_round].points.getAsInt();
                        }
                        player_list[player].score += 1;
                    }

                    else {
                        System.out.println("Incorrect!");
                    }
                }
            }
        }
        scanner.close();
        return player_list;
    }

    public static int matchDifficultyText(String difficulty) throws InputMismatchException {
        if (!difficulty.isEmpty() && !difficulty.matches("\\d")) {
            switch (difficulty) {
                case "normal":
                    return 1;
                case "hard":
                    return 2;
                case "extreme":
                    return 3;
                case "adaptive":
                    return 4;
                default:
                    System.out.println("You entered: " + difficulty);
                    throw new InputMismatchException();
            }
        } else {
            int numericDifficulty = Integer.parseInt(difficulty);
            if (numericDifficulty > 0 && numericDifficulty < 5) {
                return numericDifficulty;
            } else {
                System.out.println("You entered: " + difficulty);
                throw new InputMismatchException();
            }
        }
    }

    public static long calculatePoints(long time, int difficulty, int bonusPoints) {
        return Math.round((bonusPoints / time) * difficulty) * 10;
    }
}

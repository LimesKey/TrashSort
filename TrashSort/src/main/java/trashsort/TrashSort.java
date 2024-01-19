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
        public boolean eliminated;

        public Player(String name, int score, boolean eliminated) {
            this.name = name;
            this.score = score;
            this.eliminated = eliminated;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        Item[] itemDatabase = ItemDb.ItemDBCreator(); // fetches the Item database from another file's function
        int intro_decision = 0;
        int sanitizedDifficulty;
        int player_amount;
    
        System.out.println(CYAN + "WELCOME TRASH-SORTING-SIMULATOR!" + ANSI_RESET);
    
        while (intro_decision != 3) { // while the user didnt select to exit 
            while (!(0 > intro_decision && intro_decision > 3)) { // error trap for user introduction input to game
    
                System.out.println
                        ("\nWould you like to: " +
                                "\n\t1. Play the game" +
                                "\n\t2. Help" +
                                "\n\t3. Exit");
    
                System.out.print("Choice: ");
                scanner.reset();
                if (scanner.hasNextLine()) {
                    intro_decision = Integer.parseInt(scanner.nextLine()); // parse string to int
                }
                else {
                    
                }

               if (intro_decision == 3) {
                   break;
               }
               else if (intro_decision == 1) {
                    break;
               }
                 
                switch (intro_decision) {
                    case 1: { // IF they want to play the game
                        // CREATE ENTIRE GAME MENU GUI IF THEY WANT TO PLAY THE GAME! 
                        System.out.println(ANSI_GREEN + "\nDESCRIPTION:" + ANSI_RESET);
                        System.out.println(" A trash-sorting game in which a user receives " +
                                "random items and their task\n is sorting them in the " +
                                "correct corresponding trash bins. The more they get correct,\n " +
                                "the harder it gets. Score 9 correct points and you win!!"); // small instructions
                        System.out.print(ANSI_GREEN + "\t\t\t\t\tGOODLUCK!\n" + ANSI_RESET);
                        System.out.println(CYAN + "\n ** NOTE. 1 = Recycle, 2 = Compost, " +
                                "3 = Landfill or maybe 4 = Special **" + ANSI_RESET);
                        break;
                    }
    
                    case 2: {   // IF they want "help" or clarification on the program:
                        System.out.println(ANSI_BLUE + "\nThe purpose of this game is to have you" +
                                "(the user) \nassort various " +
                                "COMPOST, RECYCLING, or GARBAGE\nitems into the correct" + // help instructions
                                " trash bins." +
                                "\nFOR EXAMPLE: Plastic Straws would go in the garbage." + ANSI_RESET);
                        break;
                    }
    
                    case 3: {
                        break; // exit the game
                    }
    
                    default: {
                        System.err.println("Invalid input, please try again!"); // anything else just in case
                        continue;
                    }
                }
            }
    
            if (intro_decision == 3) {
                break; // break again to exit the game
            }
    
            do {
                System.out.println("Please enter the amount of players: ");
                player_amount = Integer.parseInt(scanner.nextLine());
            } while (player_amount < 0 || player_amount >= 10); // only allows 1 - 10 players
    
            Player[] player_list = new Player[player_amount]; // creates an array of players
    
            for (int i = 0; i < player_amount; i++) {
                System.out.println("Please enter the name for player " + (i + 1) + ": ");
                player_list[i] = new Player((scanner.nextLine().strip()), 0, false); // creates a new player object and assigns a name and a default score of 0
            }
    
            while (true) {
                System.out.println("\nPlease choose your difficulty level, normal, hard or adaptive (either type in word or number)");
                System.out.print("Game Difficulty: "); // difficulty for entire game
                String difficulty = scanner.nextLine();
    
                try {
                    sanitizedDifficulty = Tools.matchDifficultyText(difficulty.toLowerCase().strip()); // function to handle converting user inputted difficulty to int
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid difficulty! Please try again!");
                    System.out.print(" You entered: " + difficulty); // something went wrong
                    System.out.println("Error message: " + e);
                }
            }
    
            long start = System.nanoTime(); // track time to calculate score
            switch (sanitizedDifficulty) {
                case 1: {
                    for (int i = 0; i < player_list.length; i++) {
                        player_list[i] = Levels.classicalNormal(player_list[i], itemDatabase);
                        System.out.println("Player " + player_list[i].name + " has a score of " + player_list[i].score);
                    }
                    break;
                }
    
                case 2: {
                    for (int i = 0; i < player_list.length; i++) {
                        player_list[i] = Levels.classicalHard(player_list[i], itemDatabase);
                        System.out.println("Player " + player_list[i].name + " has a score of " + player_list[i].score);
                    }
                    break;
                }
    
                case 3: {
                    Player[] new_player_list = Levels.adaptive(itemDatabase, player_list);
                    for (int i = 0; i < new_player_list.length; i++) {
                        System.out.println("Player " + player_list[i].name + " has a score of " + player_list[i].score);
                    }
                }
            }
    
    
            long end = System.nanoTime();
            long elapsedTime = (end - start) / 1000000000; // calculate elapsed time in seconds
    
            System.out.println("Game Over! Elapsed Time: " + elapsedTime + " seconds");
            
            System.out.println("Thank you for playing! Program ending...");
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
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
    
        while (intro_decision != 3) {
            while (!(0 > intro_decision && intro_decision > 3)) {
    
                System.out.println
                        ("\nWould you like to: " +
                                "\n\t1. Play the game" +
                                "\n\t2. Help" +
                                "\n\t3. Exit");
    
                System.out.print("Choice: ");
                intro_decision = Integer.parseInt(scanner.nextLine());

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
                                "the harder it gets. Score 9 correct points and you win!!");
                        System.out.print(ANSI_GREEN + "\t\t\t\t\tGOODLUCK!\n" + ANSI_RESET);
                        System.out.println(CYAN + "\n ** NOTE. 1 = Recycle, 2 = Compost, " +
                                "3 = Landfill or maybe 4 = Special **" + ANSI_RESET);
                        break;
                    }
    
                    case 2: {   // IF they want "help" or clarification on the program:
                        System.out.println(ANSI_BLUE + "\nThe purpose of this game is to have you" +
                                "(the user) \nassort various " +
                                "COMPOST, RECYCLING, or GARBAGE\nitems into the correct" +
                                " trash bins." +
                                "\nFOR EXAMPLE: Plastic Straws would go in the garbage." + ANSI_RESET);
                        break;
                    }
    
                    case 3: {
                        break;
                    }
    
                    default: {
                        System.err.println("Invalid input, please try again!");
                        continue;
                    }
                }
            }
    
            if (intro_decision == 3) {
                break;
            }
    
            do {
                System.out.println("Please enter the amount of players: ");
                player_amount = Integer.parseInt(scanner.nextLine());
            } while (player_amount < 0 || player_amount > 10);
    
            Player[] player_list = new Player[player_amount];
    
            for (int i = 0; i < player_amount; i++) {
                System.out.println("Please enter the name for player " + (i + 1) + ": ");
                player_list[i] = new Player((scanner.nextLine().strip()), 0, false);
            }
    
            while (true) {
                System.out.println("\nPlease choose your difficulty level, normal, hard or adaptive (either type in word or number)");
                System.out.print("Game Difficulty: ");
                String difficulty = scanner.nextLine();
    
                try {
                    sanitizedDifficulty = tools.matchDifficultyText(difficulty.toLowerCase().strip());
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid difficulty! Please try again!");
                    System.out.print(" You entered: " + difficulty);
                    System.out.println("Error message: " + e);
                }
            }
    
            long start = System.nanoTime();
            switch (sanitizedDifficulty) {
                case 1: {
                    for (int i = 0; i < player_list.length; i++) {
                        player_list[i] = classicalNormal(player_list[i], itemDatabase);
                        System.out.println("Player " + player_list[i].name + " has a score of " + player_list[i].score);
                    }
                    break;
                }
    
                case 2: {
                    for (int i = 0; i < player_list.length; i++) {
                        player_list[i] = classicalHard(player_list[i], itemDatabase);
                        System.out.println("Player " + player_list[i].name + " has a score of " + player_list[i].score);
                    }
                    break;
                }
    
                case 3: {
                    Player[] new_player_list = adaptive(itemDatabase, player_list);
                    for (int i = 0; i < new_player_list.length; i++) {
                        System.out.println("Player " + player_list[i].name + " has a score of " + player_list[i].score);
                    }
                }
            }
    
    
            long end = System.nanoTime();
            long elapsedTime = (end - start) / 1000000000;
    
            System.out.println("Game Over! Elapsed Time: " + elapsedTime + " seconds");
    
            System.out.println("Thank you for playing! Program ending...");
        }
        System.out.println("Thank you for playing!");
        scanner.close();
    }
    

    public static Player[] adaptive(Item[] itemDatabase, Player[] player_list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting Adaptive difficulty round, it will get increasingly harder until you get 3 wrong answers or exhaust the database.");
        int player_count = player_list.length;
        int track_difficulty = 1;

        for (int difficulty = 1; difficulty < 4; difficulty++) {
            track_difficulty++;

            if (difficulty > track_difficulty) {
                System.out.println(ANSI_YELLOW + "Level up, difficulty is now " + difficulty + "!" + ANSI_RESET);
            }
            else {
                System.out.println("Current Difficulty: " + difficulty);
            }

            Item[] available_items = ItemDb.searchItemDbDifficulty(difficulty, itemDatabase);
        
            int avail_split = (int) Math.floorDiv(available_items.length, player_count);
            System.out.println("Each player will get " + avail_split + " items.");
            int logical_round = 0;
            for (int player = 0; player < (player_count); player++) {
                if (player_list[player].eliminated) {
                    continue;
                }
                System.out.println(ANSI_RED + "\n\n" + player_list[player].name + " (" + (player + 1) + " of " + player_count + "), " + "it is your turn." + ANSI_RESET);

                int visualized_round = 0;
                int wrong_answers = 0;
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

                    TrashClassification sanUserAnswer = tools.matchTrashClassification(userAnswer);

                    TrashClassification correctAnswer = available_items[logical_round].classification;

                    if (sanUserAnswer == correctAnswer) {
                        System.out.println("Correct!");
                        if (available_items[logical_round].points.isPresent()) {
                            player_list[player].score += available_items[logical_round].points.getAsInt();
                        }
                        player_list[player].score += (1 * difficulty);
                    }

                    else {
                        System.out.println("Incorrect!");
                        if (wrong_answers == 3) {
                            System.out.println("You got 3 wrong answers, game over!");
                            player_list[player].eliminated = true;
                            break;
                        }
                        else {
                            wrong_answers++;
                        }
                    }
                }
            }
        }
        scanner.close();
        return player_list;
    }

public static Player classicalNormal(Player player, Item[] itemDatabase) {
    // DECLARE VARIABLES + OBJECTS (for easyMethod2 function)
    Scanner scanS = new Scanner(System.in);
    int Count = 0;
    TrashClassification userAnswer;
    TrashClassification systemAnswer;

    do {
      int selectionEasy = (int)(1 + Math.random() * 3);
      switch (selectionEasy) {
        // Create case for garbageEASY
        case 1: {
            Item[] itemDatabaseEasy = ItemDb.searchItemDbClassification(TrashClassification.LANDFILL, itemDatabase);
            int itemEasyLANDFILL = (int)(Math.random() * (itemDatabaseEasy.length));
            System.out.println("Where does " +
            itemDatabaseEasy[itemEasyLANDFILL] +" go?");
            userAnswer = tools.matchTrashClassification(scanS.nextLine());
            systemAnswer = itemDatabaseEasy[itemEasyLANDFILL].classification;

            if (userAnswer == systemAnswer) {
                System.out.println(ANSI_GREEN + "Correct! " +
                "You get a point!\n" + ANSI_RESET);
                Count++;
            } 

            else {
                System.out.println(ANSI_RED + "Incorrect, " +
                "Try again\n" + ANSI_RESET);
            }
            break;
        }

        case 2: {
            Item[] itemDatabaseEasy = ItemDb.searchItemDbClassification(TrashClassification.RECYCLE, itemDatabase);
            int itemEasyRECYCLING = (int)(Math.random() * (itemDatabaseEasy.length));
            System.out.println("Where does " +
            itemDatabaseEasy[itemEasyRECYCLING] +" go?");
            userAnswer = tools.matchTrashClassification(scanS.nextLine());
            systemAnswer = itemDatabaseEasy[itemEasyRECYCLING].classification;

            if (userAnswer == systemAnswer) {
                System.out.println(ANSI_GREEN + "Correct! " +
                "You get a point!\n" + ANSI_RESET);
                Count++;
            } 

            else {
                System.out.println(ANSI_RED + "Incorrect, " +
                "Try again\n" + ANSI_RESET);
            }
            break;
        }
        case 3: {
            Item[] itemDatabaseEasy = ItemDb.searchItemDbClassification(TrashClassification.COMPOST, itemDatabase);
            int itemEasyCOMPOST = (int)(Math.random() * (itemDatabaseEasy.length));
            System.out.println("Where does " +
            itemDatabaseEasy[itemEasyCOMPOST] +" go?");
            userAnswer = tools.matchTrashClassification(scanS.nextLine());
            systemAnswer = itemDatabaseEasy[itemEasyCOMPOST].classification;

            if (userAnswer == systemAnswer) {
                System.out.println(ANSI_GREEN + "Correct! " +
                "You get a point!\n" + ANSI_RESET);
                Count++;
            } 

            else {
                System.out.println(ANSI_RED + "Incorrect, " +
                "Try again\n" + ANSI_RESET);
            }
            break;
        }
      } // End of SWITCH statement
    } while (Count <= 2);
    player.score = Count;
    scanS.close();
    return player;
  } // End of easyMethod2 statement

public static Player classicalHard(Player player, Item[] itemDatabase) {
    // DECLARE VARIABLES + OBJECTS (for mediumMethod2 function)
    Scanner scanS = new Scanner(System.in);
    int Count = 0;
    TrashClassification userAnswer;
    TrashClassification systemAnswer;
    System.out.println("------------------------------------------------");
    System.out.println("Congratulations, You've made it to MEDIUM mode." +
      "Things are gonna get slightly trickier.");
    do {
        int selection = (int)(1 + Math.random() * 3);
        switch (selection) {
            // Create case for garbageEASY
            case 1: {
                Item[] itemDatabaseHard = ItemDb.searchItemDbClassification(TrashClassification.LANDFILL, itemDatabase);
                itemDatabaseHard = ItemDb.searchItemDbDifficulty(2, itemDatabase);
                int itemEasy = (int)(Math.random() * (itemDatabaseHard.length));
                System.out.println("Where does " +
                itemDatabaseHard[itemEasy] +" go?");
                userAnswer = tools.matchTrashClassification(scanS.nextLine());
                systemAnswer = itemDatabaseHard[itemEasy].classification;
    
                if (userAnswer == systemAnswer) {
                    System.out.println(ANSI_GREEN + "Correct! " +
                    "You get a point!\n" + ANSI_RESET);
                    Count++;
                } 
    
                else {
                    System.out.println(ANSI_RED + "Incorrect, " +
                    "Try again\n" + ANSI_RESET);
                }
                break;
            }
    
            case 2: {
                Item[] itemDatabaseHard = ItemDb.searchItemDbClassification(TrashClassification.RECYCLE, itemDatabase);
                itemDatabaseHard = ItemDb.searchItemDbDifficulty(2, itemDatabase);
                int itemEasy = (int)(Math.random() * (itemDatabaseHard.length));
                System.out.println("Where does " +
                itemDatabaseHard[itemEasy] +" go?");
                userAnswer = tools.matchTrashClassification(scanS.nextLine());
                systemAnswer = itemDatabaseHard[itemEasy].classification;
    
                if (userAnswer == systemAnswer) {
                    System.out.println(ANSI_GREEN + "Correct! " +
                    "You get a point!\n" + ANSI_RESET);
                    Count++;
                } 
    
                else {
                    System.out.println(ANSI_RED + "Incorrect, " +
                    "Try again\n" + ANSI_RESET);
                }
                break;
            }
            case 3: {
                Item[] itemDatabaseHard = ItemDb.searchItemDbClassification(TrashClassification.COMPOST, itemDatabase);
                itemDatabaseHard = ItemDb.searchItemDbDifficulty(2, itemDatabase);
                int itemEasy = (int)(Math.random() * (itemDatabaseHard.length));
                System.out.println("Where does " +
                itemDatabaseHard[itemEasy] +" go?");
                userAnswer = tools.matchTrashClassification(scanS.nextLine());
                systemAnswer = itemDatabaseHard[itemEasy].classification;
    
                if (userAnswer == systemAnswer) {
                    System.out.println(ANSI_GREEN + "Correct! " +
                    "You get a point!\n" + ANSI_RESET);
                    Count++;
                } 
    
                else {
                    System.out.println(ANSI_RED + "Incorrect, " +
                    "Try again\n" + ANSI_RESET);
                }
                break;
            }
        }
      // Final do While Test coniditon for HARD
    } while (Count <= 5);
    player.score = Count;
    scanS.close();
    return player;
  } // End of mediumMethod2 FUNCTION
}
package trashsort;
import java.util.Scanner;
import trashsort.TrashSort.Item;
import trashsort.TrashSort.Player;
import trashsort.TrashSort.TrashClassification;

public class Levels {
    public static final String ANSI_PURPLE = "\033[0;35m";  //IMPORT COLORS TO JAZZ IT UP! 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String CYAN = "\033[0;36m";

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

                    TrashClassification sanUserAnswer = Tools.matchTrashClassification(userAnswer);

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
            itemDatabaseEasy[itemEasyLANDFILL].name +" go?");
            userAnswer = Tools.matchTrashClassification(scanS.nextLine());
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
            itemDatabaseEasy[itemEasyRECYCLING].name +" go?");
            userAnswer = Tools.matchTrashClassification(scanS.nextLine());
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
            itemDatabaseEasy[itemEasyCOMPOST].name +" go?");
            userAnswer = Tools.matchTrashClassification(scanS.nextLine());
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
                itemDatabaseHard[itemEasy].name +" go?");
                userAnswer = Tools.matchTrashClassification(scanS.nextLine());
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
                itemDatabaseHard[itemEasy].name+" go?");
                userAnswer = Tools.matchTrashClassification(scanS.nextLine());
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
                itemDatabaseHard[itemEasy].name +" go?");
                userAnswer = Tools.matchTrashClassification(scanS.nextLine());
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

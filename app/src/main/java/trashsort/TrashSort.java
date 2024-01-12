package trashsort;
import java.util.InputMismatchException;
import java.lang.Math;
import java.util.OptionalInt;
import java.util.Scanner;
public class TrashSort {

    public class Item {
        public String name;
        public TrashClassification classification;
        public int difficulty;
        public OptionalInt points;

        
        public Item(String name, TrashClassification classification, int difficulty, OptionalInt points) {
            this.name = name;
            this.classification = classification;   
            this.difficulty = difficulty;   // some type of constructor
            this.points = points;
        }
    }

    public enum TrashClassification {
        RECYCLE,
        COMPOST,
        LANDFILL,
        SPECIAL // HAZARDOUS
    }

    public static void main(String[] args) throws InputMismatchException{ 
        Scanner scanS = new Scanner(System.in);
        int sanDifficulty = 1;
        int rounds = 5; // change later
        TrashSort.Item[] PolyDB = ItemDb.ItemDBCreator(); // fetches the Item database from another file's function
        int bonus_points = 0;

        System.out.println("Welcome to Trash Sorting Simulator!");
        System.out.println("Please choose your difficulty: normal, hard, extreme, (either type in word or number)");
        String difficulty = scanS.nextLine();
        sanDifficulty = MatchDifficultyText(difficulty.toLowerCase().strip()); // sanitized difficulty

        long start = System.nanoTime();        

        for (int i = 0; i < rounds; i++) {
            System.out.println("Round " + (i) + " of " + rounds);
            System.out.println("Item: " + PolyDB[i].name);

            System.out.println("To which container does this item belong to?");
            System.out.println("\tPlease choose your answer by typing in the word: Recycle, Compost, Landfill, Special");
            
            if (scanS.nextLine().equals(PolyDB[i].classification.toString().toLowerCase())) {
                System.out.println("Correct!");
                if (PolyDB[i].points.isPresent() && PolyDB[i].points.getAsInt() > 0) {
                    bonus_points += PolyDB[i].points.orElse(0) * 50;
                    System.out.println("working");
                }
            }
            else if (sanDifficulty == 1 || sanDifficulty == 2){
                System.out.println("Incorrect!");
            }

            else {
                System.out.println("You suck loser! INCORRECT!");
            }
        }
        long end = System.nanoTime();
        long elapsedTime = (end - start) / 1000000000;
        System.out.println("You have finished the game! Your score is: " + CalculatePoints(elapsedTime, sanDifficulty, bonus_points));
        System.out.println("Game Over! Elapsed Time: " + elapsedTime + " seconds");

        scanS.close();
        System.nanoTime();
    }

    public static int MatchDifficultyText(String difficulty) {
        if (!difficulty.isEmpty() && !difficulty.matches("\\d")) {
            switch (difficulty) {
                case "normal":
                    return 1;
                case "hard":
                    return 2;
                case "extreme":
                    return 3;

                default:
                    System.out.println("Invalid difficulty! Please try again!");
                    System.out.println("You entered: " + difficulty);
                    throw new InputMismatchException();
            }
        }
        else {
            if (Integer.parseInt(difficulty) > 0 && Integer.parseInt(difficulty) < 4) {
                return Integer.parseInt(difficulty);
            }
            else {
                System.out.println("Invalid difficulty! Please try again!");
                throw new InputMismatchException();
            }
        }
    }

    public static long CalculatePoints(long time, int difficulty, int bonus_points) {
        long new_points = Math.round(bonus_points / time) * difficulty;
        return new_points;
    }
}
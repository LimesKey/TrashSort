package trashsort;

import java.util.InputMismatchException;
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

    public static void main(String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        int rounds = 5; // change later
        Item[] itemDatabase = ItemDb.ItemDBCreator(); // fetches the Item database from another file's function
        int bonusPoints = 0;

        System.out.println("Welcome to Trash Sorting Simulator!");
        System.out.println("Please choose your difficulty: normal, hard, extreme (either type in word or number)");

        String difficulty = scanner.nextLine();
        int sanitizedDifficulty = matchDifficultyText(difficulty.toLowerCase().strip());

        long start = System.nanoTime();

        for (int i = 0; i < rounds; i++) {
            System.out.println("Round " + i + " of " + rounds);
            System.out.println("Item: " + itemDatabase[i].name);
            System.out.println("To which container does this item belong to?");
            System.out.println("\tPlease choose your answer by typing in the word: Recycle, Compost, Landfill, Special");

            String userAnswer = scanner.nextLine().toLowerCase();
            String correctAnswer = itemDatabase[i].classification.toString().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                if (itemDatabase[i].points.isPresent() && itemDatabase[i].points.getAsInt() > 0) {
                    bonusPoints += itemDatabase[i].points.orElse(0) * 50;
                }
            } else if (sanitizedDifficulty == 1 || sanitizedDifficulty == 2) {
                System.out.println("Incorrect!");
            } else {
                System.out.println("You suck loser! INCORRECT!");
            }
        }

        long end = System.nanoTime();
        long elapsedTime = (end - start) / 1000000000;
        System.out.println("You have finished the game! Your score is: " + calculatePoints(elapsedTime, sanitizedDifficulty, bonusPoints));
        System.out.println("Game Over! Elapsed Time: " + elapsedTime + " seconds");

        scanner.close();
    }

    public static int matchDifficultyText(String difficulty) {
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
        } else {
            int numericDifficulty = Integer.parseInt(difficulty);
            if (numericDifficulty > 0 && numericDifficulty < 4) {
                return numericDifficulty;
            } else {
                System.out.println("Invalid difficulty! Please try again!");
                throw new InputMismatchException();
            }
        }
    }

    public static long calculatePoints(long time, int difficulty, int bonusPoints) {
        return Math.round(bonusPoints / time) * difficulty;
    }
}

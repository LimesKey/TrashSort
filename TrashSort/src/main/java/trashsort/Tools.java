package trashsort;

import trashsort.TrashSort.*;
import java.util.InputMismatchException;

public class Tools {
    // public static long calculatePoints(long time, int difficulty, int bonusPoints) {
    //     return Math.round((bonusPoints / time) * difficulty) * 10;                       to be edited later
    // }

    public static int matchDifficultyText(String difficulty) throws InputMismatchException {
        if (!difficulty.isEmpty() && !difficulty.matches("\\d")) {
            switch (difficulty) {
                case "normal":
                    return 1;
                case "hard":
                    return 2;
                case "adaptive":
                    return 3;
                default:
                    System.out.println("You entered: " + difficulty);
                    throw new InputMismatchException();
            }
        } else {
            int numericDifficulty = Integer.parseInt(difficulty);
            if (numericDifficulty > 0 && numericDifficulty < 4) {
                return numericDifficulty;
            } else {
                System.out.println("You entered: " + difficulty);
                throw new InputMismatchException();
            }
        }
    }

    public static TrashClassification matchTrashClassification(String classification) {
        classification = classification.toLowerCase().strip();
        
        if (classification.isEmpty()) {
            System.out.println("Input Mismatch Exception: Empty String!");
        }

        if (classification.matches("\\A\\p{ASCII}*\\z")) {
            switch (classification) {
                case "recycle":
                    return TrashClassification.RECYCLE;
                case "compost":
                    return TrashClassification.COMPOST;
                case "landfill":
                    return TrashClassification.LANDFILL;
                case "special":
                    return TrashClassification.SPECIAL;
                default:
                    throw new InputMismatchException();
            }
        }

        else if (classification.matches("\\d")) {
            int numericClassification = Integer.parseInt(classification);
            if (numericClassification > 0 && numericClassification < 5) {
                switch (numericClassification) {
                    case 1:
                        return TrashClassification.RECYCLE;
                    case 2:
                        return TrashClassification.COMPOST;
                    case 3:
                        return TrashClassification.LANDFILL;
                    case 4:
                        return TrashClassification.SPECIAL;
                    default:
                        throw new InputMismatchException();
                }
            }
            else {
                System.out.println("Invalid Input!");
                throw new InputMismatchException();
            }
        }
        else {
            System.out.println("Invalid Input!");
            throw new InputMismatchException();
        }
    }
}

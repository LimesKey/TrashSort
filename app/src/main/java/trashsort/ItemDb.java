package trashsort;

import java.util.OptionalInt;

import trashsort.TrashSort.Item;
import trashsort.TrashSort.Player;
import trashsort.TrashSort.TrashClassification;

public class ItemDb {
    public static TrashSort.Item[] ItemDBCreator() {
        TrashSort trashSort = new TrashSort();
        TrashSort.Item Item1 = trashSort.new Item("Water Bottle", TrashSort.TrashClassification.RECYCLE, 1, OptionalInt.of(1));
        TrashSort.Item Item2 = trashSort.new Item("Banana Peel", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item3 = trashSort.new Item("Plastic Bag", TrashSort.TrashClassification.LANDFILL, 1, OptionalInt.of(1));
        TrashSort.Item Item4 = trashSort.new Item("Batteries", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item5 = trashSort.new Item("Plastic Bottle", TrashSort.TrashClassification.RECYCLE, 1, OptionalInt.of(1));
        TrashSort.Item Item6 = trashSort.new Item("Apple Core", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item7 = trashSort.new Item("Plastic Wrap", TrashSort.TrashClassification.LANDFILL, 2, OptionalInt.of(1));
        TrashSort.Item Item8 = trashSort.new Item("Lightbulb", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item9 = trashSort.new Item("Glass Bottle", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item10 = trashSort.new Item("Orange Peel", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item11 = trashSort.new Item("Plastic Utensils", TrashSort.TrashClassification.LANDFILL, 2, OptionalInt.of(1));
        TrashSort.Item Item12 = trashSort.new Item("Paint", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item13 = trashSort.new Item("Paper", TrashSort.TrashClassification.RECYCLE, 1, OptionalInt.of(1));
        TrashSort.Item Item14 = trashSort.new Item("Paper Towel", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item15 = trashSort.new Item("Plastic Cup", TrashSort.TrashClassification.LANDFILL, 1, OptionalInt.of(1));
        TrashSort.Item Item16 = trashSort.new Item("Motor Oil", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item17 = trashSort.new Item("Cardboard", TrashSort.TrashClassification.RECYCLE, 1, OptionalInt.of(1));
        TrashSort.Item Item18 = trashSort.new Item("Eggshells", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item19 = trashSort.new Item("Plastic Fork", TrashSort.TrashClassification.LANDFILL, 1, OptionalInt.of(1));
        TrashSort.Item Item20 = trashSort.new Item("Antifreeze", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item21 = trashSort.new Item("Newspaper", TrashSort.TrashClassification.RECYCLE, 1, OptionalInt.of(1));
        TrashSort.Item Item22 = trashSort.new Item("Coffee Grounds", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item23 = trashSort.new Item("Plastic Knife", TrashSort.TrashClassification.LANDFILL, 1, OptionalInt.of(1));
        TrashSort.Item Item24 = trashSort.new Item("Pesticides", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item25 = trashSort.new Item("Magazines", TrashSort.TrashClassification.RECYCLE, 1, OptionalInt.of(1));
        TrashSort.Item Item26 = trashSort.new Item("Tea Bags", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item27 = trashSort.new Item("Plastic Spoon", TrashSort.TrashClassification.LANDFILL, 1, OptionalInt.of(1));
        TrashSort.Item Item28 = trashSort.new Item("Fluorescent Bulbs", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item29 = trashSort.new Item("Junk Mail", TrashSort.TrashClassification.RECYCLE, 1, OptionalInt.of(1));
        TrashSort.Item Item30 = trashSort.new Item("Fruit", TrashSort.TrashClassification.COMPOST, 1, OptionalInt.of(1));
        TrashSort.Item Item31 = trashSort.new Item("Plastic Straw", TrashSort.TrashClassification.LANDFILL, 1, OptionalInt.of(1));
        TrashSort.Item Item32 = trashSort.new Item("Glass Jar", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item33 = trashSort.new Item("Paper Plate", TrashSort.TrashClassification.COMPOST, 2, OptionalInt.of(1));
        TrashSort.Item Item34 = trashSort.new Item("Aluminum Can", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item35 = trashSort.new Item("CDs", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item36 = trashSort.new Item("Plastic Plant Pot", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item37 = trashSort.new Item("E-waste", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item38 = trashSort.new Item("Styrofoam", TrashSort.TrashClassification.LANDFILL, 2, OptionalInt.of(1));
        TrashSort.Item Item39 = trashSort.new Item("CFL Bulbs", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item40 = trashSort.new Item("Pizza Box", TrashSort.TrashClassification.COMPOST, 2, OptionalInt.of(1));
        TrashSort.Item Item41 = trashSort.new Item("Plastic Clamshell", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item42 = trashSort.new Item("Ink Cartridges", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item43 = trashSort.new Item("Metal Hangers", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item44 = trashSort.new Item("Disposable Diapers", TrashSort.TrashClassification.LANDFILL, 2, OptionalInt.of(1));
        TrashSort.Item Item45 = trashSort.new Item("Wine Corks", TrashSort.TrashClassification.COMPOST, 2, OptionalInt.of(1));
        TrashSort.Item Item46 = trashSort.new Item("Plastic CD Cases", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item47 = trashSort.new Item("Paint Cans", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item48 = trashSort.new Item("Ceramics", TrashSort.TrashClassification.LANDFILL, 2, OptionalInt.of(1));
        TrashSort.Item Item49 = trashSort.new Item("VHS Tapes", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item50 = trashSort.new Item("Plastic Cutlery", TrashSort.TrashClassification.LANDFILL, 2, OptionalInt.of(1));
        TrashSort.Item Item51 = trashSort.new Item("Foam Cups", TrashSort.TrashClassification.LANDFILL, 2, OptionalInt.of(1));
        TrashSort.Item Item52 = trashSort.new Item("Plastic Packaging", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item53 = trashSort.new Item("Disposable Cameras", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item54 = trashSort.new Item("Juice Boxes", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item55 = trashSort.new Item("Metallic Gift Wrap", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item56 = trashSort.new Item("Plastic Egg Cartons", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item57 = trashSort.new Item("Tyvek Envelopes", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item58 = trashSort.new Item("Shredded Paper", TrashSort.TrashClassification.COMPOST, 2, OptionalInt.of(1));
        TrashSort.Item Item59 = trashSort.new Item("Plastic Film", TrashSort.TrashClassification.RECYCLE, 2, OptionalInt.of(1));
        TrashSort.Item Item60 = trashSort.new Item("Crayons", TrashSort.TrashClassification.SPECIAL, 2, OptionalInt.of(1));
        TrashSort.Item Item61 = trashSort.new Item("Mercury Thermometers", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item62 = trashSort.new Item("Asbestos", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item63 = trashSort.new Item("Lead-based Paint", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item64 = trashSort.new Item("Radioactive Waste", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item65 = trashSort.new Item("Biomedical Waste", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item66 = trashSort.new Item("Used Needles", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item67 = trashSort.new Item("Plutonium", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item68 = trashSort.new Item("Ebola-contaminated Materials", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item69 = trashSort.new Item("Chemotherapy Drugs", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));
        TrashSort.Item Item70 = trashSort.new Item("Nuclear Reactor Waste", TrashSort.TrashClassification.SPECIAL, 3, OptionalInt.of(1));


        TrashSort.Item ItemDb[] = {Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10, Item11, Item12, Item13, Item14, Item15, Item16, Item17, Item18, Item19, Item20, Item21, Item22, Item23, Item24, Item25, Item26, Item27, Item28, Item29, Item30, Item31, Item32, Item33, Item34, Item35, Item36, Item37, Item38, Item39, Item40, Item41, Item42, Item43, Item44, Item45, Item46, Item47, Item48, Item49, Item50, Item51, Item52, Item53, Item54, Item55, Item56, Item57, Item58, Item59, Item60, Item61, Item62, Item63, Item64, Item65, Item66, Item67, Item68, Item69, Item70};
        return ItemDb;
    }

    public static Item[] searchItemDbDifficulty(int difficulty, TrashSort.Item[] ItemDb) {
        int possible_items = 0;

        for (int j = 0; j < ItemDb.length; j++) {
            if (ItemDb[j] != null && ItemDb[j].difficulty == difficulty) {
                possible_items++;
            }
        }
            
        Item[] available_items = new Item[possible_items];
            
        int count = 0;
        for (int j = 0; j < ItemDb.length && count < available_items.length; j++) {
            if (ItemDb[j] != null && ItemDb[j].difficulty == difficulty) {
                available_items[count++] = ItemDb[j];
            }
        }
        return available_items;
    }

    public static Item[] searchItemDbClassification(TrashClassification req_classification, TrashSort.Item[] ItemDb) {
        int possible_items = 0;

        for (int j = 0; j < ItemDb.length; j++) {
            if (ItemDb[j] != null && ItemDb[j].classification == req_classification) {
                possible_items++;
            }
        }
            
        Item[] available_items = new Item[possible_items];
            
        int count = 0;
        for (int j = 0; j < ItemDb.length && count < available_items.length; j++) {
            if (ItemDb[j] != null && ItemDb[j].classification == req_classification) {
                available_items[count++] = ItemDb[j];
            }
        }
        return available_items;
    }
}

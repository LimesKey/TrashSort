package trashsort;

import java.util.OptionalInt;
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

        TrashSort.Item ItemDb[] = {Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10, Item11, Item12, Item13, Item14, Item15, Item16, Item17, Item18, Item19, Item20, Item21, Item22, Item23, Item24, Item25, Item26, Item27, Item28, Item29, Item30, Item31};
        return ItemDb;
    }
}

public class Main {
    public static void main(String[] args){
        System.out.println("item");
        Inventory inventory = new Inventory();

//
//         runtime
//        Item item1 = new Item("Water Bucket", 20);
//        Item item2 = new Item("Generic Item", 5);
//        Fruit fruit = new Fruit("Apple", 3, "Fuji");
//        Fruit fruit2 = new Fruit("Banana", 5, "Sky Banana");
//        Weapon weapon = new Weapon("Broadsword", 2, 50, "Melee Weapon");
//        Weapon weapon2 = new Weapon("Dagger", 1, 20, "Melee Weapon");

//        inventory.addItem(item1);
//        inventory.addItem(item2);
//        inventory.addItem(fruit);
//        inventory.addItem(fruit2);
//        inventory.addItem(weapon);

        // compiled
//        inventory.addItem("Dagger", 1, 20, "Melee Weapon");
//        inventory.addItem("Banana", 5, "Sky Banana");

        // jeito pratico de add um item novo usando o runtime
        inventory.addItem(new Fruit("Watermelon", 5, "Juicy"));

        inventory.displayInventory();
    }
}
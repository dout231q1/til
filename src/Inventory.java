import java.util.ArrayList;

public class Inventory{
    private ArrayList<Item> items;

    public Inventory(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

// pra usar o compiled tem que adicionar um metodo addItem individualmente pra oque voce quer aqui

//    public void addItem(String name, int quantity, String type){
//        items.add(new Fruit(name, quantity, type));
//    }
//
//    public void addItem(String name, int quantity, int damage, String type){
//        items.add(new Weapon(name, quantity, damage, type));
//    }

    public void displayInventory(){
        for(Item item : items){
            System.out.println(item.toString());
        }
    }
}
//            System.out.printf("Item: %s Quantity %d\n", item.getName(), item.getQuantity());
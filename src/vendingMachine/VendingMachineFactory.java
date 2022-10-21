/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine;

import vendingMachine.inventory.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tamer
 */
public class VendingMachineFactory {

    public static VendingMachine createVendingMachine(String type) throws ClassNotFoundException {
        switch (type) {
            case "Snacks":
                return new SnackVendingMachine(5, 5, 10,snackItems);
            case "Coffee":
                throw new ClassNotFoundException("CoffeeVendingMachine Not Found!");
            case "Drinks":
                throw new ClassNotFoundException("DrinksVendingMachine Not Found!");
            default:
                throw new ClassNotFoundException();
        }
    }
    
    public static List<Item> snackItems = new ArrayList<Item>() {
        {
            add(new Item("1", "snack1", 10));
            add(new Item("2", "snack2", 20));
            add(new Item("3", "snack3", 50));
            add(new Item("4", "snack4", 100));
            add(new Item("5", "snack5", 2000));
            add(new Item("6", "snack6", 5000));
            add(new Item("7", "snack7", 80));
            add(new Item("8", "snack8", 350));
            add(new Item("9", "snack9", 710));
            add(new Item("10", "snack10", 890));
            add(new Item("11", "snack11", 520));
            add(new Item("12", "snack12", 3520));
            add(new Item("13", "snack13", 7450));
            add(new Item("14", "snack14", 330));
            add(new Item("15", "snack15", 460));
            add(new Item("16", "snack16", 90));
            add(new Item("17", "snack17", 445));
            add(new Item("18", "snack18", 1990));
            add(new Item("19", "snack19", 2540));
            add(new Item("20", "snack20", 780));
            add(new Item("21", "snack21", 1080));
            add(new Item("22", "snack22", 610));
            add(new Item("23", "snack23", 90));
            add(new Item("24", "snack24", 4500));
            add(new Item("25", "snack25", 770));
        }
    };

}

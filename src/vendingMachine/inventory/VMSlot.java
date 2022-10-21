/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vendingMachine.inventory;

/**
 *
 * @author tamer
 */
public interface VMSlot {

    Item deductItem();

    Item peekItem();

    void fillSlot(Item item);

    void fillSlot(Item item, int quantity);

    boolean isEmpty();

    boolean isFull();
}

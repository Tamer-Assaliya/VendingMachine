/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.inventory;

import java.util.*;

/**
 *
 * @author tamer
 */
public class SnackSlot implements VMSlot {

    private String snackSlotId;
    private Stack<Item> snackItems;
    private int maxSlotCapacity;

    public SnackSlot(String snackSlotId, int maxSlotCapacity) {
        this.snackSlotId = snackSlotId;
        this.snackItems = new Stack<Item>();
        this.maxSlotCapacity = maxSlotCapacity;
    }

    @Override
    public Item deductItem() {
        if (this.isEmpty()) {
            return null;
        }
        return this.snackItems.pop();
    }

    @Override
    public Item peekItem() {
        if (this.isEmpty()) {
            return null;
        }
        return this.snackItems.peek();
    }

    @Override
    public void fillSlot(Item snackItem) {
        if (this.isFull()) {
            return;
        }
        while (this.snackItems.size() != maxSlotCapacity) {
            this.snackItems.push(snackItem);
        }
    }

    @Override
    public void fillSlot(Item snackItem, int addedQuantity) {
        if (this.isFull()) {
            return;
        }
        for (int i = 0; i < addedQuantity; i++) {
            if (this.snackItems.size() != maxSlotCapacity) {
                this.snackItems.add(snackItem);
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.snackItems.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.snackItems.size() == this.maxSlotCapacity;
    }

}

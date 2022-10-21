/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.states;

import vendingMachine.money.Coins;
import vendingMachine.inventory.Item;
import vendingMachine.money.Money;
import vendingMachine.money.Notes;
import vendingMachine.SnackVendingMachine;
import vendingMachine.VendingMachineController;
import vendingMachine.inventory.VMSlot;

/**
 *
 * @author tamer
 */
public class DispenseState implements VMState {

    private SnackVendingMachine vendingMachine;
    private VendingMachineController vendingMachineController;

    public DispenseState(SnackVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        vendingMachineController = vendingMachine.getVendingMachineController();
    }

    @Override
    public void selectItem(int row, int column) {
        System.out.println("Item  already selected");
    }

    @Override
    public void insertMoney(Money money) {
        System.out.println("Enough money has been inserted");
    }

    @Override
    public void validateMoney() {
        System.out.println("Enough money has been inserted!");
    }

    @Override
    public void dispenseItem() {
        String selectedItemId = this.vendingMachine.getSelectedItem().getItemId();
        VMSlot selectedSlot = this.vendingMachine.getSnackSlots().get(selectedItemId);
        Item item = selectedSlot.deductItem();
        System.out.println("Item: " + item.getItemName() + " is dispensed!");
        this.vendingMachine.dispenseChange();
    }

    @Override
    public void dispenseChange() {
        Item selecteditem = this.vendingMachine.getSelectedItem();
        int itemPrice = selecteditem.getItemPrice();
        int currentCollectedAmount = this.vendingMachineController.getCurrentCollectedAmount();
        int change = currentCollectedAmount - itemPrice;
        Notes notesChange = vendingMachineController.calculateNotesChange(change);
        change -= notesChange.getvalue();
        Coins coinsChange = vendingMachineController.calculateCoinsChange(change);
        change -= coinsChange.getvalue();
        this.vendingMachineController.displayChange(notesChange, coinsChange);
        this.vendingMachineController.resetToInitialState();
    }
}

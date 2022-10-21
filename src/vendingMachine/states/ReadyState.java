/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.states;

import vendingMachine.inventory.Item;
import vendingMachine.money.Money;
import vendingMachine.SnackVendingMachine;
import vendingMachine.inventory.VMSlot;
import vendingMachine.VendingMachineController;

/**
 *
 * @author tamer
 */
public class ReadyState implements VMState {

    private SnackVendingMachine vendingMachine;
    private VendingMachineController vendingMachineController;

    public ReadyState(SnackVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.vendingMachineController = vendingMachine.getVendingMachineController();
    }

    @Override
    public void selectItem(int row, int column) {
        String slotId = this.vendingMachine.getSnackKeyPad().getSelectedSlotId(row, column);
        VMSlot selectedSlot = this.vendingMachine.getSnackSlots().get(slotId);
        Item item = selectedSlot.peekItem();
        this.vendingMachine.setSelectedItem(item);
        this.vendingMachineController.displayItemDetails(item);
        if (item != null) {
            boolean isMoneyInserted = this.vendingMachineController.getCurrentCollectedAmount() > 0;
            if (isMoneyInserted) {
                this.vendingMachine.setCurrentState(this.vendingMachine.getMoneyInsertedState());
                this.vendingMachine.validateMoney();

            } else {
                this.vendingMachine.setCurrentState(this.vendingMachine.getItemSelectedState());
            }
        }
    }

    @Override
    public void insertMoney(Money money) {
        System.out.println("You must select an item number first!");
    }

    @Override
    public void validateMoney() {
        System.out.println("You must select an item number first!");
    }

    @Override
    public void dispenseItem() {
        System.out.println("You must select an item number first!");
    }

    @Override
    public void dispenseChange() {
        System.out.println("You must select an item number first!");
    }

}

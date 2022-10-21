/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.states;

import vendingMachine.money.Card;
import vendingMachine.MoneySlots.CardSlot;
import vendingMachine.money.Coins;
import vendingMachine.MoneySlots.CoinsSlot;
import vendingMachine.inventory.Item;
import vendingMachine.money.Money;
import vendingMachine.money.Notes;
import vendingMachine.MoneySlots.NotesSlot;
import vendingMachine.SnackVendingMachine;
import vendingMachine.inventory.VMSlot;
import vendingMachine.VendingMachineController;

/**
 *
 * @author tamer
 */
public class MoneyInsertedState implements VMState {

    private SnackVendingMachine vendingMachine;
    private VendingMachineController vendingMachineController;

    public MoneyInsertedState(SnackVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        vendingMachineController = vendingMachine.getVendingMachineController();
    }

    @Override
    public void selectItem(int row, int column) {
        String slotId = this.vendingMachine.getSnackKeyPad().getSelectedSlotId(row, column);
        VMSlot selectedSlot = this.vendingMachine.getSnackSlots().get(slotId);
        Item item = selectedSlot.peekItem();
        this.vendingMachine.setSelectedItem(item);
        this.vendingMachineController.displayItemDetails(item);
        if (item == null) {
            this.vendingMachine.setCurrentState(this.vendingMachine.getReadyState());
        } else {
            this.vendingMachine.validateMoney();
        }
    }

    @Override
    public void insertMoney(Money money) {
        CoinsSlot coinsSlot = this.vendingMachine.getCoinsSlot();
        NotesSlot notesSlot = this.vendingMachine.getNotesSlot();
        CardSlot cardSlot = this.vendingMachine.getCardSlot();
        if (money instanceof Coins) {
            coinsSlot.addAmount(money);
        } else if (money instanceof Notes) {
            notesSlot.addAmount(money);
        } else if (money instanceof Card) {
            cardSlot.addAmount(money);
            cardSlot.authorizePurchase(this.vendingMachine.getSelectedItem().getItemPrice());
        }
        this.vendingMachineController.displayCurrentCollectedAmount();
        this.vendingMachine.validateMoney();
    }

    @Override
    public void validateMoney() {
        Item selecteditem = this.vendingMachine.getSelectedItem();
        int itemPrice = selecteditem.getItemPrice();
        int currentCollectedAmount = this.vendingMachineController.getCurrentCollectedAmount();
        boolean isSufficientAmount = currentCollectedAmount >= itemPrice;
        if (isSufficientAmount) {
            System.out.println("Money validated successfully!");
            this.vendingMachine.setCurrentState(this.vendingMachine.getDispenseState());
            this.vendingMachine.dispenseItem();
        } else {
            System.out.println("Inserted amount is less than the item's price: $" + itemPrice / 100.0);
            System.out.println("Please insert enough amount!, Additional $" + (itemPrice - currentCollectedAmount) / 100.0 + " needed!");
        }
    }

    @Override
    public void dispenseItem() {
        System.out.println("Not enough money inserted yet!");
    }

    @Override
    public void dispenseChange() {
        System.out.println("Not enough money inserted yet!");
    }

}

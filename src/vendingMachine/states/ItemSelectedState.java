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
import vendingMachine.VendingMachineController;
import vendingMachine.inventory.VMSlot;

/**
 *
 * @author tamer
 */
public class ItemSelectedState implements VMState {

    private SnackVendingMachine vendingMachine;
    private VendingMachineController vendingMachineController;

    public ItemSelectedState(SnackVendingMachine vendingMachine) {
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
        this.vendingMachine.setCurrentState(this.vendingMachine.getMoneyInsertedState());
        this.vendingMachine.validateMoney();
    }

    @Override
    public void validateMoney() {
        System.out.println("You must insert enough money first!");
    }

    @Override
    public void dispenseItem() {
        System.out.println("You must insert enough money first!");
    }

    @Override
    public void dispenseChange() {
        System.out.println("You must insert enough money first!");
    }

}

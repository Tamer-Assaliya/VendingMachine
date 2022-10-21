/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine;

import vendingMachine.inventory.SnackSlot;
import vendingMachine.inventory.Item;
import vendingMachine.money.Coins;
import vendingMachine.money.Notes;
import vendingMachine.money.Card;
import vendingMachine.MoneySlots.CardSlot;
import vendingMachine.MoneySlots.CoinsSlot;
import vendingMachine.MoneySlots.NotesSlot;
import vendingMachine.money.Money;
import java.util.HashMap;
import java.util.List;
import vendingMachine.inventory.VMSlot;
import vendingMachine.states.DispenseState;
import vendingMachine.states.ItemSelectedState;
import vendingMachine.states.MoneyInsertedState;
import vendingMachine.states.ReadyState;
import vendingMachine.states.VMState;

/**
 *
 * @author tamer
 */
public class SnackVendingMachine implements VendingMachine {

    private VendingMachineController vendingMachineCalculator;
    private VMState currentState;
    private VMState readyState;
    private VMState itemSelectedState;
    private VMState moneyInsertedState;
    private VMState dispenseState;
    private KeyPad snackKeyPad;
    private HashMap<String, VMSlot> snackSlots;
    private CoinsSlot coinsSlot;
    private NotesSlot notesSlot;
    private CardSlot cardSlot;
    private Item selectedItem = null;

    public SnackVendingMachine(int rows, int columns, int slotCapacity, List<Item> snackItems) {
        this.vendingMachineCalculator = new VendingMachineController(this);
        this.readyState = new ReadyState(this);
        this.itemSelectedState = new ItemSelectedState(this);
        this.moneyInsertedState = new MoneyInsertedState(this);
        this.dispenseState = new DispenseState(this);
        this.currentState = this.readyState;
        this.snackKeyPad = new SnackKeyPad(rows, columns);
        this.coinsSlot = new CoinsSlot(new Coins(10000, 10000, 10000, 10000));
        this.notesSlot = new NotesSlot(new Notes(10000, 10000));
        this.cardSlot = new CardSlot(new Card(1000000), new Card(0));
        this.snackSlots = new HashMap<String, VMSlot>();
        this.initializeSnackSlotsWithItems(rows, columns, slotCapacity, snackItems);
    }

    private void initializeSnackSlotsWithItems(int rows, int columns, int slotCapacity, List<Item> items) {
        int totalSlotsNumber = rows * columns;
        for (int i = 0; i < totalSlotsNumber; i++) {
            String slotId = String.valueOf(i + 1);
            SnackSlot snackSlot = new SnackSlot(slotId, slotCapacity);
            snackSlot.fillSlot(items.get(i));
            this.snackSlots.put(slotId, snackSlot);
        }
    }

    public VMState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(VMState state) {
        this.currentState = state;
    }

    public VMState getReadyState() {
        return readyState;
    }

    public VMState getItemSelectedState() {
        return itemSelectedState;
    }

    public VMState getMoneyInsertedState() {
        return moneyInsertedState;
    }

    public VMState getDispenseState() {
        return dispenseState;
    }

    public KeyPad getSnackKeyPad() {
        return snackKeyPad;
    }

    public HashMap<String, VMSlot> getSnackSlots() {
        return snackSlots;
    }

    public CoinsSlot getCoinsSlot() {
        return coinsSlot;
    }

    public NotesSlot getNotesSlot() {
        return notesSlot;
    }

    public CardSlot getCardSlot() {
        return cardSlot;
    }

    public VendingMachineController getVendingMachineController() {
        return vendingMachineCalculator;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    @Override
    public void selectItem(int row, int column) {
        this.currentState.selectItem(row, column);
    }

    @Override
    public void insertMoney(Money money) {
        this.currentState.insertMoney(money);
    }

    public void validateMoney() {
        this.currentState.validateMoney();
    }

    public void dispenseItem() {
        this.currentState.dispenseItem();
    }

    public void dispenseChange() {
        this.currentState.dispenseChange();
    }

}

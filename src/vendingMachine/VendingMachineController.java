/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine;

import vendingMachine.MoneySlots.CardSlot;
import vendingMachine.MoneySlots.CoinsSlot;
import vendingMachine.MoneySlots.NotesSlot;
import vendingMachine.inventory.Item;
import vendingMachine.money.Card;
import vendingMachine.money.Coins;
import vendingMachine.money.Notes;

/**
 *
 * @author tamer
 */
public class VendingMachineController {

    private SnackVendingMachine vendingMachine;

    public VendingMachineController(SnackVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public int getCurrentCollectedAmount() {
        NotesSlot notesSlot = this.vendingMachine.getNotesSlot();
        CoinsSlot coinsSlot = this.vendingMachine.getCoinsSlot();
        CardSlot cardSlot = this.vendingMachine.getCardSlot();
        return coinsSlot.getCurrentAmount().getvalue()
                + notesSlot.getCurrentAmount().getvalue()
                + cardSlot.getCurrentAmount().getvalue();
    }

    public void resetToInitialState() {
        NotesSlot notesSlot = this.vendingMachine.getNotesSlot();
        CoinsSlot coinsSlot = this.vendingMachine.getCoinsSlot();
        CardSlot cardSlot = this.vendingMachine.getCardSlot();

        coinsSlot.resetCurrentAmount();
        notesSlot.resetCurrentAmount();
        cardSlot.resetCurrentAmount();
        this.vendingMachine.setSelectedItem(null);
        this.vendingMachine.setCurrentState(this.vendingMachine.getReadyState());
    }

    public void displayItemDetails(Item item) {
        if (item == null) {
            System.out.println("Item is not available, please select another item");
        } else {
            System.out.println("Selected snack:");
            System.out.println("snackId: " + item.getItemId() + "\nsnackName: " + item.getItemName() + "\nsnackPrice: $" + item.getItemPrice() / 100.0);
        }
    }

    public void displayCurrentCollectedAmount() {
        CoinsSlot coinsSlot = this.vendingMachine.getCoinsSlot();
        NotesSlot notesSlot = this.vendingMachine.getNotesSlot();
        CardSlot cardSlot = this.vendingMachine.getCardSlot();
        Coins currentCollectedCoins = (Coins) coinsSlot.getCurrentAmount();
        Notes currentCollectedNotes = (Notes) notesSlot.getCurrentAmount();
        Card currentCard = (Card) cardSlot.getCurrentAmount();
        System.out.println("Accumulated amount of money:");
        System.out.println("Notes:\n\t$50: " + currentCollectedNotes.getFiftyDollars() + "\n\t$20: " + currentCollectedNotes.getTwentyDollars());
        System.out.println("Coins:\n\t¢10: " + currentCollectedCoins.getTenCents() + "\n\t¢20: " + currentCollectedCoins.getTwentyCents());
        System.out.println("\t¢50: " + currentCollectedCoins.getFiftyCents() + "\n\t$1: " + currentCollectedCoins.getOneDollar());
        if (cardSlot.getCustomerMoneyCard() != null) {
            System.out.println("Collected money from Card: $" + currentCard.getvalue() / 100.0);
        }
        System.out.println("Total inserted Amount = $" + this.getCurrentCollectedAmount() / 100.0);
    }

    public void displayChange(Notes notesChange, Coins coinsChange) {
        double $returnedAmount = (notesChange.getvalue() + coinsChange.getvalue()) / 100.0;
        if ($returnedAmount < 0) {
            return;
        }
        System.out.println("Please pickup the change: $" + $returnedAmount);
        System.out.println("Notes:\n\t$50: " + notesChange.getFiftyDollars() + "\n\t$20: " + notesChange.getTwentyDollars());
        System.out.println("Coins:\n\t¢10: " + coinsChange.getTenCents() + "\n\t¢20: " + coinsChange.getTwentyCents());
        System.out.println("\t¢50: " + coinsChange.getFiftyCents() + "\n\t$01: " + coinsChange.getOneDollar());
        System.out.println("Thank you ;)");
    }

    public Notes calculateNotesChange(int change) {
        NotesSlot notesSlot = this.vendingMachine.getNotesSlot();
        Notes totalNotes = (Notes) notesSlot.getTotalMoney();
        Notes notesChange = new Notes(0, 0);
        while (change >= 5000 && totalNotes.getFiftyDollars() > 0) {
            change -= 5000;
            totalNotes.setFiftyDollars(totalNotes.getFiftyDollars() - 1);
            notesChange.setFiftyDollars(notesChange.getFiftyDollars() + 1);
        };

        while (change >= 2000 && totalNotes.getTwentyDollars() > 0) {
            change -= 2000;
            totalNotes.setTwentyDollars(totalNotes.getTwentyDollars() - 1);
            notesChange.setTwentyDollars(notesChange.getTwentyDollars() + 1);
        };
        return notesChange;
    }

    public Coins calculateCoinsChange(int change) {
        CoinsSlot coinsSlot = this.vendingMachine.getCoinsSlot();
        Coins totalCoins = (Coins) coinsSlot.getTotalMoney();
        Coins coinsChange = new Coins(0, 0, 0, 0);
        while (change >= 100 && totalCoins.getOneDollar() > 0) {
            change -= 100;
            totalCoins.setOneDollar(totalCoins.getOneDollar() - 1);
            coinsChange.setOneDollar(coinsChange.getOneDollar() + 1);
        };
        while (change >= 50 && totalCoins.getFiftyCents() > 0) {
            change -= 50;
            totalCoins.setFiftyCents(totalCoins.getFiftyCents() - 1);
            coinsChange.setFiftyCents(coinsChange.getFiftyCents() + 1);
        };
        while (change >= 20 && totalCoins.getTwentyCents() > 0) {
            change -= 20;
            totalCoins.setTwentyCents(totalCoins.getTwentyCents() - 1);
            coinsChange.setTwentyCents(coinsChange.getTwentyCents() + 1);
        };
        while (change >= 10 && totalCoins.getTenCents() > 0) {
            change -= 10;
            totalCoins.setTenCents(totalCoins.getTenCents() - 1);
            coinsChange.setTenCents(coinsChange.getTenCents() + 1);
        };
        return coinsChange;
    }
}

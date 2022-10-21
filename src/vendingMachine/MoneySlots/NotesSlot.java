/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.MoneySlots;

import vendingMachine.money.Notes;
import vendingMachine.money.Money;

/**
 *
 * @author tamer
 */
public class NotesSlot implements MoneySlot {
    
    final private Notes totalNotes;
    private Notes currentNotesAmount;

    public NotesSlot(Notes notes) {
        this.totalNotes = notes;
        this.currentNotesAmount=new Notes(0, 0);
    }

    @Override
    public Money getTotalMoney() {
        return this.totalNotes;
    }
    
    @Override
    public Money getCurrentAmount() {
        return this.currentNotesAmount;
    }

    @Override
    public void addAmount(Money notes) {
        Notes addedNotes = (Notes) notes;
        this.totalNotes.setTwentyDollars(this.totalNotes.getTwentyDollars()+addedNotes.getTwentyDollars());
        this.totalNotes.setFiftyDollars(this.totalNotes.getFiftyDollars()+addedNotes.getFiftyDollars());
        this.currentNotesAmount.setTwentyDollars(this.currentNotesAmount.getTwentyDollars()+addedNotes.getTwentyDollars());
        this.currentNotesAmount.setFiftyDollars(this.currentNotesAmount.getFiftyDollars()+addedNotes.getFiftyDollars());
    }

    @Override
    public void resetCurrentAmount() {
        this.currentNotesAmount.setTwentyDollars(0);
        this.currentNotesAmount.setFiftyDollars(0);
    }

    @Override
    public boolean validateMoney() {
        //TODO reject invalid totalNotes types if inserted
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

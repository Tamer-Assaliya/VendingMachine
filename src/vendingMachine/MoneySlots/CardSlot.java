/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.MoneySlots;

import vendingMachine.money.Card;
import vendingMachine.money.Money;

/**
 *
 * @author tamer
 */
//TODO: add extra logic and validations for cards
public class CardSlot implements MoneySlot {

    private Card accountVMCard;
    private Card collectedMoneyCard;
    private Card customerMoneyCard;

    public CardSlot(Card totalAccountMoney, Card currentCollectedAmount) {
        this.accountVMCard = totalAccountMoney;
        this.collectedMoneyCard = currentCollectedAmount;
        this.customerMoneyCard=null;
    }

    @Override
    public Money getTotalMoney() {
        return this.accountVMCard;
    }
    
    @Override
    public Money getCurrentAmount() {
        return this.collectedMoneyCard;
    }

    @Override
    public void addAmount(Money card) {
        this.customerMoneyCard = (Card) card;
    }
    
    @Override
    public void resetCurrentAmount() {
        this.collectedMoneyCard.setBalance(0);
        this.customerMoneyCard=null;
    }
    
    public void authorizePurchase(int itemPrice) {
        //TODO reject  invalid card types if inserted
        if(this.customerMoneyCard.getvalue()>=itemPrice){
            this.collectedMoneyCard.setBalance(itemPrice);
            this.accountVMCard.setBalance(this.accountVMCard.getvalue()+itemPrice);
            this.customerMoneyCard.setBalance(this.customerMoneyCard.getvalue()-itemPrice);
        }
        else{
            this.customerMoneyCard=null;
            System.out.println("Card does't have enough balance to complete purchase!");
        } 
    }

    public Card getCustomerMoneyCard() {
        return customerMoneyCard;
    }
    
    

    @Override
    public boolean validateMoney() {
        //TODO reject  invalid card types if inserted
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

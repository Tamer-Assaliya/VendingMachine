/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.money;

import vendingMachine.money.Money;

/**
 *
 * @author tamer
 */
public class Card implements Money {

    private int balance;

    public Card(int balance) {
        this.balance = balance;
    }

    @Override
    public int getvalue() {
        return balance;
    }

    @Override
    public void addvalue(Money addedMoney) {
        Card addedCard = (Card) addedMoney;
        balance+= addedCard.balance;
    }


//
    public void setBalance(int balance) {
        this.balance = balance;
    }

}

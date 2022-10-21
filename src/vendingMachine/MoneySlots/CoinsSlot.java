/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.MoneySlots;

import vendingMachine.money.Coins;
import vendingMachine.money.Money;

/**
 *
 * @author tamer
 */
public class CoinsSlot implements MoneySlot {

    final private Coins totalCoins;
    private Coins currentCoinsAmount;

    public CoinsSlot(Coins coins) {
        this.totalCoins = coins;
        this.currentCoinsAmount = new Coins(0, 0, 0, 0);
    }

    @Override
    public Money getTotalMoney() {
        return this.totalCoins;
    }

    @Override
    public Money getCurrentAmount() {
        return this.currentCoinsAmount;
    }

    @Override
    public void addAmount(Money coins) {
        Coins addedCoins = (Coins) coins;
        this.totalCoins.setTenCents(this.totalCoins.getTenCents() + addedCoins.getTenCents());
        this.totalCoins.setTwentyCents(this.totalCoins.getTwentyCents() + addedCoins.getTwentyCents());
        this.totalCoins.setFiftyCents(this.totalCoins.getFiftyCents() + addedCoins.getFiftyCents());
        this.totalCoins.setOneDollar(this.totalCoins.getOneDollar() + addedCoins.getOneDollar());
        this.currentCoinsAmount.setTenCents(this.currentCoinsAmount.getTenCents() + addedCoins.getTenCents());
        this.currentCoinsAmount.setTwentyCents(this.currentCoinsAmount.getTwentyCents() + addedCoins.getTwentyCents());
        this.currentCoinsAmount.setFiftyCents(this.currentCoinsAmount.getFiftyCents() + addedCoins.getFiftyCents());
        this.currentCoinsAmount.setOneDollar(this.currentCoinsAmount.getOneDollar() + addedCoins.getOneDollar());

    }

    @Override
    public void resetCurrentAmount() {
        this.currentCoinsAmount.setTenCents(0);
        this.currentCoinsAmount.setTwentyCents(0);
        this.currentCoinsAmount.setFiftyCents(0);
        this.currentCoinsAmount.setOneDollar(0);
    }

    @Override
    public boolean validateMoney() {
        //TODO reject invalid coin types if inserted
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

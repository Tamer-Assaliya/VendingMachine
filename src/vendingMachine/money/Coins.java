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
public class Coins implements Money {

    private int tenCents, twentyCents, fiftyCents, oneDollar;
//TODO define unvalid coin types, so if inserted reject them
    public Coins(Integer tenCents, int twentyCents, int fiftyCents, int oneDollar) {
        this.tenCents = tenCents;
        this.twentyCents = twentyCents;
        this.fiftyCents = fiftyCents;
        this.oneDollar = oneDollar;
    }

    @Override
    public int getvalue() {
        int total = 0;
        total += tenCents * 10;
        total += twentyCents * 20;
        total += fiftyCents * 50;
        total += oneDollar * 100;
        return total;
    }
   
    @Override
     public void addvalue(Money addedMoney) {
         Coins addedCoins=(Coins) addedMoney;
         tenCents+=addedCoins.tenCents;
         twentyCents+=addedCoins.twentyCents;
         fiftyCents+=addedCoins.fiftyCents;
         oneDollar+=addedCoins.oneDollar;
    }

    public int getTenCents() {
        return tenCents;
    }

    public void setTenCents(int tenCents) {
        this.tenCents = tenCents;
    }

    public int getTwentyCents() {
        return twentyCents;
    }

    public void setTwentyCents(int twentyCents) {
        this.twentyCents = twentyCents;
    }

    public int getFiftyCents() {
        return fiftyCents;
    }

    public void setFiftyCents(int fiftyCents) {
        this.fiftyCents = fiftyCents;
    }

    public int getOneDollar() {
        return oneDollar;
    }

    public void setOneDollar(int oneDollar) {
        this.oneDollar = oneDollar;
    }

}

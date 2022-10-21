/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.money;

/**
 *
 * @author tamer
 */
public class Notes implements Money {

    private int twentyDollars, fiftyDollars;

    public Notes(int twentyDollars, int fiftyDollars) {
        this.twentyDollars = twentyDollars;
        this.fiftyDollars = fiftyDollars;
    }

    @Override
    public int getvalue() {
        int total = 0;
        total += twentyDollars * 2000;
        total += fiftyDollars * 5000;
        return total;
    }

    @Override
    public void addvalue(Money addedMoney) {
        Notes addedNotes = (Notes) addedMoney;
        twentyDollars += addedNotes.twentyDollars;
        fiftyDollars += addedNotes.fiftyDollars;
    }

    public int getTwentyDollars() {
        return twentyDollars;
    }

    public void setTwentyDollars(int twentyDollars) {
        this.twentyDollars = twentyDollars;
    }

    public int getFiftyDollars() {
        return fiftyDollars;
    }

    public void setFiftyDollars(int fiftyDollars) {
        this.fiftyDollars = fiftyDollars;
    }

}

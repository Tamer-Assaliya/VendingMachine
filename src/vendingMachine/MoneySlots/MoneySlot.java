/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine.MoneySlots;

import vendingMachine.money.Money;

/**
 *
 * @author tamer
 */
public interface MoneySlot {

    Money getTotalMoney();
    
    Money getCurrentAmount();

    void resetCurrentAmount();

    void addAmount(Money money);

    boolean validateMoney();
}

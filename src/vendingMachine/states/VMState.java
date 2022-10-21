/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vendingMachine.states;

import vendingMachine.money.Money;

/**
 *
 * @author tamer
 */
public interface VMState {
    void selectItem(int row,int column);
    void insertMoney(Money money);
    void validateMoney();
    void dispenseItem();
    void dispenseChange();
}

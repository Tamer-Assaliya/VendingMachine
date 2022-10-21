/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vendingMachine;

import vendingMachine.money.Money;
import vendingMachine.inventory.Item;

/**
 *
 * @author tamer
 */
public interface VendingMachine {
    void selectItem(int row,int column);
    void insertMoney(Money money);
}

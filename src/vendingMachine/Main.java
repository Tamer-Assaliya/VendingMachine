/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vendingMachine;

import vendingMachine.money.Coins;
import vendingMachine.money.Notes;
import vendingMachine.money.Card;

/**
 *
 * @author tamer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        VendingMachine snackVendingMachine = VendingMachineFactory.createVendingMachine("Snacks");
        //perfect senarios (ReadyState > ItemSelected > moneyInserted > dispense):
        snackVendingMachine.selectItem(1, 2);
        snackVendingMachine.insertMoney(new Coins(2, 0, 0, 4));
        System.out.println("1------------------------------------------------1");
        //insert money in ready state:
        snackVendingMachine.insertMoney(new Notes(1, 0));
        System.out.println("2------------------------------------------------2");
        //insert money more than one time:
        snackVendingMachine.selectItem(2, 2);
        snackVendingMachine.insertMoney(new Coins(2, 0, 0, 4));
        snackVendingMachine.insertMoney(new Notes(2, 0));
        snackVendingMachine.insertMoney(new Notes(0, 1));
        System.out.println("3------------------------------------------------3");
        //change = 0:
        snackVendingMachine.selectItem(1, 3);
        snackVendingMachine.insertMoney(new Coins(0, 0, 0, 8));
        System.out.println("4------------------------------------------------4");
        //buy using card:
        snackVendingMachine.selectItem(4, 3);
        snackVendingMachine.insertMoney(new Card(1000));
        snackVendingMachine.insertMoney(new Card(5000));
        System.out.println("5------------------------------------------------5");
        //insert notes, then card:
        snackVendingMachine.selectItem(4, 3);
        snackVendingMachine.insertMoney(new Notes(1, 0));
        snackVendingMachine.insertMoney(new Card(10000));
        System.out.println("6------------------------------------------------6");
        //select, select, insert:
        snackVendingMachine.selectItem(4, 3);
        snackVendingMachine.selectItem(1, 3);
        snackVendingMachine.insertMoney(new Notes(1, 0));
        snackVendingMachine.insertMoney(new Card(10000));
        System.out.println("7------------------------------------------------7");
        //select insert, dispense till empty, then select:
        for (int i = 0; i < 10; i++) {
            snackVendingMachine.selectItem(0, 3);
            snackVendingMachine.insertMoney(new Notes(1, 0));
        }
        snackVendingMachine.selectItem(0, 3);
        System.out.println("8------------------------------------------------8");
        //select, insert(not enough),then select cheaper:
        snackVendingMachine.selectItem(2, 1);
        snackVendingMachine.insertMoney(new Notes(1, 0));
        snackVendingMachine.selectItem(2, 0);
        System.out.println("9------------------------------------------------9");
        //select, insert(not enough), select(still not enough money), insert enough:
        snackVendingMachine.selectItem(2, 1);
        snackVendingMachine.insertMoney(new Coins(1, 0,0,0));
        snackVendingMachine.selectItem(2, 0);
        snackVendingMachine.insertMoney(new Coins(0,0,0,6));
        System.out.println("10------------------------------------------------10");

    }

}

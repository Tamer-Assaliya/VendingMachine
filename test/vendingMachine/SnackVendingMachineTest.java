/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vendingMachine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingMachine.MoneySlots.NotesSlot;
import vendingMachine.inventory.Item;
import vendingMachine.money.Coins;
import vendingMachine.money.Notes;
import vendingMachine.states.ReadyState;
import vendingMachine.states.VMState;

/**
 *
 * @author tamer
 */
public class SnackVendingMachineTest {

    private SnackVendingMachine snackVendingMachine;

    public SnackVendingMachineTest() {
        this.snackVendingMachine = new SnackVendingMachine(5, 5, 10, VendingMachineFactory.snackItems);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setCurrentState method, of class SnackVendingMachine.
     */
    @Test
    public void testSetCurrentState() {
        System.out.println("setCurrentState");
        VMState expectedState = new ReadyState(snackVendingMachine);
        snackVendingMachine.setCurrentState(expectedState);
        var actualState = snackVendingMachine.getCurrentState();
        assertEquals(expectedState, actualState);
    }

    /**
     * Test of getSelectedItem method, of class SnackVendingMachine.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        Item expResult = new Item("1", "Snack", 100);
        snackVendingMachine.setSelectedItem(expResult);
        Item actualResult = snackVendingMachine.getSelectedItem();
        assertEquals(expResult, actualResult);
    }

    /**
     * Test of setSelectedItem method, of class SnackVendingMachine.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Item actualSelectedItem = new Item("1", "Snack", 100);
        snackVendingMachine.setSelectedItem(actualSelectedItem);
        assertEquals(snackVendingMachine.getSelectedItem(), actualSelectedItem);
    }

    /**
     * Test of selectItem method, of class SnackVendingMachine.
     */
    @Test
    public void testSelectItem() {
        System.out.println("selectItem");
        int row = 1;
        int column = 3;
        Item expectedItem = new Item("9", "snack9", 710);
        snackVendingMachine.selectItem(row, column);
        var actualItem = snackVendingMachine.getSelectedItem();
        assertEquals(expectedItem.getItemId(), actualItem.getItemId());
        assertEquals(expectedItem.getItemName(), actualItem.getItemName());
        assertEquals(expectedItem.getItemPrice(), actualItem.getItemPrice());
    }

    /**
     * Test of insertMoney method, of class SnackVendingMachine.
     */
    @Test
    public void testInsertMoneyNotEqual() {
        System.out.println("insertMoney");
        snackVendingMachine.selectItem(1, 3);
        var item = snackVendingMachine.getSelectedItem();
        Coins expectedMoney = new Coins(2, 3, 4, 5);
        snackVendingMachine.insertMoney(expectedMoney);
        //money are sufficient so VM clears the current amount:
        Coins actualMoney = (Coins) snackVendingMachine.getCoinsSlot().getCurrentAmount();
        assertNotEquals(expectedMoney.getvalue(), actualMoney.getvalue());
        assertNotEquals(expectedMoney.getvalue(), actualMoney.getvalue());
        assertNotEquals(expectedMoney.getFiftyCents(), actualMoney.getFiftyCents());
        assertNotEquals(expectedMoney.getOneDollar(), actualMoney.getOneDollar());
        assertNotEquals(expectedMoney.getTenCents(), actualMoney.getTenCents());
        assertNotEquals(expectedMoney.getTwentyCents(), actualMoney.getTwentyCents());
    }

    @Test
    public void testInsertMoneyEqual() {
        //Another senario:
        snackVendingMachine.selectItem(1, 3);
        var item = snackVendingMachine.getSelectedItem();
        Coins expectedMoney = new Coins(2, 3, 0, 5);
        snackVendingMachine.insertMoney(expectedMoney);
        //money are not enough so they are collected in coinsSlot:
        Coins actualMoney = (Coins) snackVendingMachine.getCoinsSlot().getCurrentAmount();
        assertEquals(expectedMoney.getvalue(), actualMoney.getvalue());
        assertEquals(expectedMoney.getvalue(), actualMoney.getvalue());
        assertEquals(expectedMoney.getFiftyCents(), actualMoney.getFiftyCents());
        assertEquals(expectedMoney.getOneDollar(), actualMoney.getOneDollar());
        assertEquals(expectedMoney.getTenCents(), actualMoney.getTenCents());
        assertEquals(expectedMoney.getTwentyCents(), actualMoney.getTwentyCents());
    }

    /**
     * Test of validateMoney method, of class SnackVendingMachine.
     */
    @Test
    public void testValidateMoneyNotEnough() {
        System.out.println("validateMoney");
        snackVendingMachine.selectItem(2, 1);
        var item = snackVendingMachine.getSelectedItem();
        Notes notes = new Notes(1, 0);
        NotesSlot notesSlot = this.snackVendingMachine.getNotesSlot();
        notesSlot.addAmount(notes);
        this.snackVendingMachine.setCurrentState(this.snackVendingMachine.getMoneyInsertedState());
        this.snackVendingMachine.validateMoney();
        assertEquals(notes.getvalue(), this.snackVendingMachine.getNotesSlot().getCurrentAmount().getvalue());
        assertTrue(notes.getvalue() < item.getItemPrice());
    }
}

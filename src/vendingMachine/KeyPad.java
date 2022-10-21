/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine;

/**
 *
 * @author tamer
 */
public abstract class KeyPad {

    protected int keyPadMatrix[][];

    public abstract String getSelectedSlotId(int row, int col);

    public abstract boolean CancelKeyPressed(boolean isPressed);

}

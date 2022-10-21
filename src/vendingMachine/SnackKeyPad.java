/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingMachine;

/**
 *
 * @author tamer
 */
public class SnackKeyPad extends KeyPad {

    public SnackKeyPad(int rows, int columns) {
        keyPadMatrix = new int[rows][columns];
    }
    
    

    @Override
    public String getSelectedSlotId(int row,int col) {
        boolean isValidNumberPressed = row>=0&&row<5&&col>=0&&col<5;
        if(!isValidNumberPressed) throw new IndexOutOfBoundsException();
        String selectedSlotId= String.valueOf((row*keyPadMatrix.length)+col+1);
        return selectedSlotId;
    }
    
    @Override
    public boolean CancelKeyPressed(boolean isPressed){
        return isPressed;
    }
    
}

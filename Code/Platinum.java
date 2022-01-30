/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class Platinum extends Customer {

    public Platinum(String Address, String name, String _CNIC, String contactNo) {
        super(Address, name, _CNIC, contactNo);
    }

    @Override
    public int gettype() {
        return 2;
    }

    public float calculateDiscount() {
        return 10;
    }
}

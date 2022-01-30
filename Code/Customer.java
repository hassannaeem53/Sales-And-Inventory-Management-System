/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public abstract class Customer extends Person{
    private String Address;

    public Customer(String Address, String name, String _CNIC, String contactNo) {
        super(name, _CNIC, contactNo);
        this.Address = Address;
    }
 

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
     public abstract float calculateDiscount();
     public abstract int gettype();
}

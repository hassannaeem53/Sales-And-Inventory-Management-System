/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class PerishableBatch extends Batch {

    private String expiryDate;

    public PerishableBatch(int batchID, int boxes, int itemsPerBox, Item item, Vendor vendor, String expiry) {
        super(batchID, boxes, itemsPerBox, item, vendor);
        expiryDate = expiry;
    }

    //Getters
    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int isPerishable() {
        return 1; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setExpiry(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String getExpiry() {
        return expiryDate;
    }
}

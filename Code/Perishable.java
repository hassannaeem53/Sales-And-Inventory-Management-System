/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Fatimah
 */
public class Perishable extends Item {

    private String expiryDate;

    public Perishable(String SKU, String name, float price, int isFragile, Department department, String expiry) {
        super(SKU, name, price, isFragile, department);
        expiryDate = expiry;
    }

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

    @Override
    public boolean isExpired() throws Exception {
        Date expiry = new SimpleDateFormat("dd-MM-yyyy").parse(expiryDate);
        Date date = Calendar.getInstance().getTime();
        if (expiry.before(date)) {
            return true;
        }
        return false;
    }

}

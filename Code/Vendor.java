/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class Vendor extends Person {

    private String companyName;

    public Vendor(String name, String CNIC, String contactNo, String companyName) {
        super(name, CNIC, contactNo);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}

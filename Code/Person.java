/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class Person {

    protected String name;
    protected String CNIC;
    protected String contactNo;

    public Person(String name, String _CNIC, String contactNo) {
        this.name = name;
        this.CNIC = _CNIC;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class Batch {
    private int batchID;
    private int numberOfBoxes;
    private int itemsPerBox;

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public void setNumberOfBoxes(int numberOfBoxes) {
        this.numberOfBoxes = numberOfBoxes;
    }

    public void setItemsPerBox(int itemsPerBox) {
        this.itemsPerBox = itemsPerBox;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public int getBatchID() {
        return batchID;
    }

    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }

    public int getItemsPerBox() {
        return itemsPerBox;
    }

    public Item getItem() {
        return item;
    }

    public Vendor getVendor() {
        return vendor;
    }
    private Item item;
    private Vendor vendor;
    
    public Batch(int batchID, int boxes, int itemsPerBox, Item item,Vendor vendor){
        this.batchID = batchID;
        this.numberOfBoxes = boxes;
        this.itemsPerBox = itemsPerBox;
        this.item = item;
        this.vendor=vendor;
    }
    public int isPerishable(){
        return 0;
    }
    public void setExpiry(String expiryDate){}
    public String getExpiry(){return "";}
}

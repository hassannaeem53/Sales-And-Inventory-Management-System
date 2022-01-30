/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import java.util.*;

/**
 *
 * @author Fatimah
 */
public class Sale {

    private int saleID;
    private Customer customer;
    private Cashier cashier;
    private float discount;
    List<ItemQuantity> items = new ArrayList<ItemQuantity>();

    public Sale(int saleID, Customer customer, Cashier cashier, float discount) {
        this.saleID = saleID;
        this.customer = customer;
        this.cashier = cashier;
        this.discount = discount;

    }

    public Customer getCustomer() {
        return customer;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void generateReceipt() {
    }

    public int getSaleID() {
        return saleID;
    }

    public List<ItemQuantity> getItems() {
        return items;
    }

    public void AddtoListItem(Item a, int Quantity) {
        ItemQuantity tempIQ = new ItemQuantity(a, Quantity);
        items.add(tempIQ);
    }

    public void addItem(ItemQuantity item) {
        items.add(item);
    }

    public void print() {
        System.out.println("saleID: " + saleID);
        System.out.println("customerCNIC: " + customer.getCNIC());
        System.out.println("cashierCNIC: " + cashier.getCNIC());
        for (int i = 0; i < items.size(); i++) {
            System.out.println("item " + i);
            System.out.println("SKU: " + items.get(i).getItem().getSKU());
            System.out.println("quantity: " + items.get(i).getQuantity());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import GUI.StoreManagerMain;
import ImplementationDB.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fatimah
 */
public class Store {

    private List<Cashier> cashierList = new ArrayList<Cashier>();
    private List<Customer> customerList = new ArrayList<Customer>();
    private List<Sale> saleList = new ArrayList<Sale>();
    private List<ItemQuantity> itemQuantityList = new ArrayList<ItemQuantity>();
    private List<Item> ItemL = new ArrayList<Item>();
    private List<Promotion> promotionList = new ArrayList<Promotion>();
    private List<Department> departmentList = new ArrayList<Department>();
    private int currentCashier;
    private StoreManager storeManager;
    

    public Store() {
        SQL obj = new SQL();
        //Loading Cashier details from db to list
        try (ResultSet rs = obj.GetRecordsCashier();) {

            while (rs.next()) {
                Cashier temp = new Cashier(rs.getString(1), rs.getString(2), rs.getString(3));
                cashierList.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Loading Customer details from db to list
        try (ResultSet rs = obj.GetRecordsCustomer();) {

            while (rs.next()) {
                if (rs.getInt(5) == 0) {
                    Customer tempSilver = new Silver(rs.getString(4), rs.getString(1), rs.getString(2), rs.getString(3));
                    customerList.add(tempSilver);
                }
                if (rs.getInt(5) == 1) {
                    Customer tempGold = new Gold(rs.getString(4), rs.getString(1), rs.getString(2), rs.getString(3));
                    customerList.add(tempGold);
                }
                if (rs.getInt(5) == 2) {
                    Customer tempPlat = new Platinum(rs.getString(4), rs.getString(1), rs.getString(2), rs.getString(3));
                    customerList.add(tempPlat);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Loading Promotion details from db to list
        try (ResultSet rs = obj.GetRecordsPromotion();) {
            while (rs.next()) {
                Promotion temp = new Promotion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5));
                promotionList.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Loading Department details from db to list
        try (ResultSet rs = obj.GetRecordsDepartment();) {

            while (rs.next()) {
                int pobj = getPromotionFromId(rs.getInt(2));
                Department temp = new Department(rs.getString(1), promotionList.get(pobj));
                departmentList.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Loading StoreItem details from db to List
        try (ResultSet rs = obj.GetRecordsStoreItem()) {
            while (rs.next()) {
                int dobj = getDepartmentFromName(rs.getString(6));

                if (rs.getInt(4) == 1) {
                    Item tempPeri = new Perishable(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(5), departmentList.get(dobj), rs.getString(8));
                    ItemL.add(tempPeri);
                    ItemQuantity iobj = new ItemQuantity(tempPeri, rs.getInt(7));
                    itemQuantityList.add(iobj);
                } else {
                    Item temp = new Item(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(5), departmentList.get(dobj));
                    ItemL.add(temp);
                    ItemQuantity iobj = new ItemQuantity(temp, rs.getInt(7));
                    itemQuantityList.add(iobj);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Load reciept details from db to list
        try (ResultSet rs = obj.GetRecordsReceipt();) {
            //receipt id cusc cashc dis itemsku quntity
            while (rs.next()) {
                if (getSaleFromSaleID(rs.getInt(1)) == -1) {
                    int customerindex = getCustomerFromCnic(rs.getString(2));
                    // System.out.println("customer index: "+customerindex);
                    int cashierindex = getCashierFromCnic(rs.getString(3));
                    //System.out.println("cashier index: "+cashierindex);
                    int itemindex = getItemFromSku(rs.getString(5));
                    //System.out.println("item index: "+itemindex);
                    Sale temp = new Sale(rs.getInt(1), customerList.get(customerindex), cashierList.get(cashierindex), rs.getFloat(4));
                    //ItemQuantity tempitemQuantity=new ItemQuantity(Itemarr.get(itemindex),rs.getInt(6));
//                for(int i=0;i<Itemarr.size();i++){
//                    System.out.println(Itemarr.get(i).getSKU());
//                }
                    //System.out.println(rs.getString(5));
                    temp.AddtoListItem(ItemL.get(itemindex), rs.getInt(6));
                    saleList.add((temp));
                    // System.out.println(rs.getInt(1));
                }
                if (getSaleFromSaleID(rs.getInt(1)) > -1) {
                    int customerindex = getCustomerFromCnic(rs.getString(2));
                    int cashierindex = getCashierFromCnic(rs.getString(3));
                    int itemindex = getItemFromSku(rs.getString(5));
                    int saleindex = getSaleFromSaleID(rs.getInt(1));
                    saleList.get(saleindex).AddtoListItem(ItemL.get(itemindex), rs.getInt(6));

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<Promotion> getPromotionList() {
        return promotionList;
    }

    public List<Item> getItemL() {
        return ItemL;
    }

    public List<ItemQuantity> getItemQuantityList() {
        return itemQuantityList;
    }

    public int getCurrentCashier() {
        return currentCashier;
    }

    public List<Cashier> getCashierList() {
        return cashierList;
    }
    private String[] Departments = {"Grocery", "Pharmacy", "Electronics", "Clothing", "Sports", "Crockery", "Bakery"};
    public String[] getDepartments() {
        return Departments;
    }

    public void addCashier(String name, String CNIC, String contactNumber) {
        //Add cashier to list
        Cashier cashier = new Cashier(name, CNIC, contactNumber);
        cashierList.add(cashier);
        //Add cashier in database
        SQL obj = new SQL();
        obj.AddCashierRecordDb(name, CNIC, contactNumber);
        obj.AddCashierLoginDb(CNIC, "tired", 1);
    }

    public void addCustomer(String name, String CNIC, String contactNumber, String address) {
        //Add customer to list
        Customer customer = new Silver(name, CNIC, contactNumber, address);
        customerList.add(customer);
        //Add customer in database
        SQL obj1 = new SQL();
        obj1.AddCustomerRecordDb(name, CNIC, contactNumber, address);

    }

    public void addItem(Item item, int quantity) {
        ItemQuantity i = new ItemQuantity(item, quantity);
        itemQuantityList.add(i);
    }

    public void applyPromotion(String name, String sDate, String eDate, float discount, String department) {
        int id = getNextPromotionID();
        Promotion promotion = new Promotion(id, name, sDate, eDate, discount);
        promotionList.add(promotion);
        int dIndex = getDepartmentFromName(department);
        departmentList.get(dIndex).setPromotion(promotionList.get(promotionList.size() - 1));
        SQL obj = new SQL();
        obj.AddPromotionRecordDb(name, sDate, eDate, discount);
        obj.updateDepartmentPromotionDb(id, department);
    }

    public void updateCustomer(int index, String name, String contactNo, String address) {
        //Update in list
        customerList.get(index).setAddress(address);
        customerList.get(index).setName(name);
        customerList.get(index).setContactNo(contactNo);
        //Update in database
        SQL obj = new SQL();
        obj.UpdateCustomerRecordDb(name, contactNo, address, customerList.get(index).getCNIC());

    }

    public boolean removeExpiredItems() {
        SQL obj1 = new SQL();
        boolean found = false;
        for (int i = 0; i < itemQuantityList.size(); i++) {
            try {
                if (itemQuantityList.get(i).getItem().isExpired()) {
                    itemQuantityList.get(i).setQuantity(0);
                    found = true;
                    obj1.RemoveExpiredItemDb(itemQuantityList.get(i).getItem().getSKU());
                }
            } catch (Exception ex) {
                System.out.println("hi");
                Logger.getLogger(StoreManagerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return found;
    }

    public int getDepartmentFromName(String name) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void setCurrentCashier(int currentCashier) {
        this.currentCashier = currentCashier;
    }

    public int getPromotionFromId(int id) {
        for (int i = 0; i < promotionList.size(); i++) {
            if (promotionList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getCustomerFromCnic(String cnic) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCNIC().equals(cnic)) {
                return i;
            }
        }
        return -1;
    }

    public int getCashierFromCnic(String cnic) {
        for (int i = 0; i < cashierList.size(); i++) {
            if (cashierList.get(i).getCNIC().equals(cnic)) {
                return i;
            }
        }
        return -1;
    }

    public int getItemFromSku(String sku) {
        for (int i = 0; i < ItemL.size(); i++) {
            if (ItemL.get(i).getSKU().equals(sku)) {
                return i;
            }
        }
        return -1;
    }

    public int getItemQuantityFromSku(String sku) {
        for (int i = 0; i < itemQuantityList.size(); i++) {
            if (itemQuantityList.get(i).getItem().getSKU().equals(sku)) {
                return i;
            }
        }
        return -1;
    }

    public void addSale(Sale sale) {
        saleList.add(sale);
    }

    public void addItemQuantity(Item item, int quantity) {
        ItemQuantity i = new ItemQuantity(item, quantity);
        itemQuantityList.add(i);
    }

    public int getNextSaleID() {
        return (saleList.size() + 1);
    }

    public int getSaleFromSaleID(int id) {
        for (int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i).getSaleID() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getCustomerSales(int index) {
        int count = 0;
        for (int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i).getCustomer() == customerList.get(index)) {
                count++;
            }
        }
        return count;
    }

    public int getNextPromotionID() {
        return (promotionList.get(promotionList.size() - 1).getId() + 1);
    }

}

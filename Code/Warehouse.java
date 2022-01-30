/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

import ImplementationDB.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Fatimah
 */
public class Warehouse {

    SQL obj = new SQL();
    private List<Batch> batchList = new ArrayList<Batch>();
    private List<Vendor> vendorList = new ArrayList<Vendor>();
    private List<Item> itemList = new ArrayList<Item>();
    private List<Department> departmentList = new ArrayList<Department>();
    private List<Promotion> promotionList = new ArrayList<Promotion>();
    private WarehouseManager warehouseManager;

    public Warehouse() {
        //Loading Vendor details from db to list
        try (ResultSet rs = obj.GetRecordsVendor();) {
            while (rs.next()) {
                Vendor temp = new Vendor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                vendorList.add(temp);
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
        //Loading Warehouse Items from db to list
        try (ResultSet rs = obj.GetRecordsWarehouseItem()) {
            while (rs.next()) {
                int dobj = getDepartmentFromName(rs.getString(7));

                Item temp;
                if (rs.getInt(5) == 1) {
                    temp = new Perishable(rs.getString(1), rs.getString(2), rs.getFloat(4), rs.getInt(6), departmentList.get(dobj), "");
                } else {
                    temp = new Item(rs.getString(1), rs.getString(2), rs.getFloat(4), rs.getInt(6), departmentList.get(dobj));
                }
                itemList.add(temp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Load batch details from db to list
        try (ResultSet rs = obj.GetRecordsBatch()) {
            while (rs.next()) {
                int iobj = getItemFromSKU(rs.getString(2));
                int vobj = getVendorFromCNIC(rs.getString(5));
                if (itemList.get(iobj).isPerishable() == 0) {
                    Batch temp = new Batch(rs.getInt(1), rs.getInt(3), rs.getInt(4), itemList.get(iobj), vendorList.get(vobj));
                    batchList.add(temp);
                } else {
                    Batch tempperi = new PerishableBatch(rs.getInt(1), rs.getInt(3), rs.getInt(4), itemList.get(iobj), vendorList.get(vobj), rs.getString(6));
                    batchList.add(tempperi);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Item> getItemList() {
        return itemList;
    }

    public List<Batch> getBatchList() {
        return batchList;
    }

    public List<Vendor> getVendorList() {
        return vendorList;
    }

    public void addVendor(String name, String CNIC, String contactNo, String company) {
        Vendor v = new Vendor(name, CNIC, contactNo, company);
        //Add vendor to list
        vendorList.add(v);
        //Add vendor to database
        SQL obj1 = new SQL();
        obj1.AddVendorRecordDb(name, CNIC, contactNo, company);
    }

    //adds item to itemList and returns index
    public int addItem(String sku, String name, float price, boolean isPerishable, int isFragile, String department) {
        Item item;
        if (isPerishable) {
            item = new Perishable(sku, name, price, isFragile, departmentList.get(getDepartmentFromName(department)), "");
        } else {
            item = new Item(sku, name, price, isFragile, departmentList.get(getDepartmentFromName(department)));
        }
        //add item to list
        itemList.add(item);

        //add item to database
        SQL obj1 = new SQL();
        obj1.AddWItemRecordDb(name, sku, price, isFragile, department, isPerishable, vendorList.get(0).getCNIC());
        return itemList.size() - 1;
    }

    public void addBatch(String vendorCNIC, int itemIndex, int boxes, int itemsPerBox, boolean perishable, String expiry) {
        int batchID = SingletonPattern.getInstance().getSystem().getWarehouse().getNextBatchID();
        Vendor vendor = vendorList.get(getVendorFromCNIC(vendorCNIC));
        Item item = itemList.get(itemIndex);
        Batch batch;
        if (!perishable) {
            batch = new Batch(batchID, boxes, itemsPerBox, item, vendor);
        } else {
            batch = new PerishableBatch(batchID, boxes, itemsPerBox, item, vendor, expiry);
        }
        batchList.add(batch);
        //Add batch to database
        SQL obj = new SQL();
        obj.AddBatchRecordDb(vendorCNIC, itemList.get(itemIndex).getSKU(), boxes, expiry, itemsPerBox);
    }

    public void updateBatch(int batchIndex, int vendorIndex, String expiry, int boxes, int itemsPerBox) {
        if (batchList.get(batchIndex).isPerishable() == 0) {
            batchList.get(batchIndex).setExpiry(expiry);
        }
        batchList.get(batchIndex).setItemsPerBox(itemsPerBox);
        batchList.get(batchIndex).setNumberOfBoxes(boxes);
        batchList.get(batchIndex).setVendor(vendorList.get(vendorIndex));
        SQL obj = new SQL();
        obj.UpdateBatchDb(batchList.get(batchIndex).getBatchID(), vendorList.get(vendorIndex).getCNIC(), boxes, itemsPerBox, expiry);
    }
    public void updateItem(int itemIndex, String name, float price, String department){
        itemList.get(itemIndex).setName(name);
        itemList.get(itemIndex).setPrice(price);
        itemList.get(itemIndex).setDepartment(departmentList.get(getDepartmentFromName(department)));
        SQL obj = new SQL();
        obj.UpdateWarehouseItemRecordDb(itemList.get(itemIndex).getSKU(), name, price, department);
    }
    public int getPromotionFromId(int id) {
        for (int i = 0; i < promotionList.size(); i++) {
            if (promotionList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getItemFromSKU(String SKU) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getSKU().equals(SKU)) {
                return i;
            }
        }
        return -1;
    }

    public int getVendorFromCNIC(String cnic) {
        for (int i = 0; i < vendorList.size(); i++) {
            if (vendorList.get(i).getCNIC().equals(cnic)) {
                return i;
            }
        }
        return -1;
    }

    public int getBatchFromSKU(String SKU) {
        for (int i = 0; i < batchList.size(); i++) {
            if (batchList.get(i).getItem().getSKU().equals(SKU)) {
                return i;
            }
        }
        return -1;
    }

    public int getDepartmentFromName(String name) {
        for (int i = 0; i < departmentList.size(); i++) {
            if (departmentList.get(i).getDepartmentName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void addBatch(Batch batch) {
        batchList.add(batch);
    }

    public int getNextBatchID() {
        return batchList.get(batchList.size() - 1).getBatchID() + 1;
    }

    public int getBatchFromID(int id) {
        for (int i = 0; i < batchList.size(); i++) {
            if (batchList.get(i).getBatchID() == id) {
                return i;
            }
        }
        return -1;
    }
}

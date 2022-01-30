/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementationDB;

import Code.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * s
 *
 * @author hassan nasir
 */
public class SQL {

    protected String url = "jdbc:sqlserver://HASSAN-NAEEM\\MSSQLSERVER;" + "databaseName=sdaproject;integratedSecurity=true;";

    public ResultSet SelectCandidate(int ID) {
        ResultSet rs = null;

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [SelectCandidate](?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setInt(1, ID);
            rs = Cmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet GetRecordsCashier() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [Cashiers]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void AddCashierRecordDb(String Name, String CNIC, String ContactNo) {

        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [Cashiers]" + "values (?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            pst.setString(2, CNIC);
            pst.setString(1, Name);
            pst.setString(3, ContactNo);
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void AddCashierLoginDb(String CNIC, String password, int type) {

        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [LoginInformation]" + "values (?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            pst.setString(1, CNIC);
            pst.setString(2, password);
            pst.setInt(3, type);
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet GetRecordsCustomer() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [Customers]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }


    public void AddCustomerRecordDb(String Name, String CNIC, String ContactNo, String Address) {
        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [Customers]" + "values (?,?,?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            pst.setString(1, Name);
            pst.setString(2, CNIC);
            pst.setString(3, ContactNo);
            pst.setString(4, Address);
            pst.setInt(5, 0);

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void UpdateCustomerRecordDb(String Name, String ContactNo, String Address, String CNIC) {

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [UpdateCustomer](?,?,?,?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setString(1, CNIC);
            Cmt.setString(2, Name);
            Cmt.setString(3, Address);
            Cmt.setString(4, ContactNo);
            Cmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateBatchDb(int id, String vendor, int boxes, int itemsPerBox, String expiry) {

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [UpdateBatch](?,?,?,?, ?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setInt(1, id);
            Cmt.setString(2, vendor);
            Cmt.setInt(3, boxes);
            Cmt.setInt(4, itemsPerBox);
            Cmt.setString(5, expiry);
            Cmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateWarehouseItemRecordDb(String SKU, String name, float price, String Department) {

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [UpdateWarehouseItem](?,?,?,?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setString(1, SKU);
            Cmt.setString(2, name);
            Cmt.setFloat(3, price);
            Cmt.setString(4, Department);
            Cmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void updateDepartmentPromotionDb(int id, String department) {

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [UpdateDepartmentPromotion](?,?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setInt(1, id);
            Cmt.setString(2, department);
            Cmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void AddPromotionRecordDb(String name, String sDate, String eDate, float discount) {
        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [Promotions]" + "values (?,?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, sDate);
            pst.setString(3, eDate);
            pst.setFloat(4, discount);

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void RemoveExpiredItemDb(String SKU) {

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [RemoveExpiredItem](?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setString(1, SKU);
            Cmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RemoveEmployeeDb(String CNIC) {

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [RemoveEmployee](?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setString(1, CNIC);
            Cmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddVendorRecordDb(String Name, String CNIC, String ContactNo, String CompanyName) {
        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [Vendors]" + "values (?,?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            pst.setString(1, Name);
            pst.setString(2, CNIC);
            pst.setString(3, ContactNo);
            pst.setString(4, CompanyName);

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void AddWItemRecordDb(String Name, String SKU, float price, int fragile, String department, boolean perishable, String vendorcnic) {
        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [WarehouseItems]" + "values (?,?,?,?,?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            pst.setString(2, Name);
            pst.setString(1, SKU);
            pst.setString(3, vendorcnic);
            pst.setFloat(4, price);
            pst.setBoolean(5, perishable);
            pst.setInt(6, fragile);
            pst.setString(7, department);

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void AddBatchRecordDb(String VendorCnic, String SKU, int nb, String expiry, int ib) {
        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [Batch]" + "values (?,?,?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);

            pst.setString(1, SKU);
            pst.setInt(2, nb);
            pst.setInt(3, ib);
            pst.setString(4, VendorCnic);
            pst.setString(5, expiry);

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet GetRecordsStoreItem() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [StoreItems]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet GetRecordsDepartment() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [Departments]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet GetRecordsPromotion() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [Promotions]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet GetRecordsVendor() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [Vendors]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void UpdateVendorRecord(Vendor v) {

        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [Vendors]" + "values (?,?,?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            pst.setString(1, v.getName());
            pst.setString(2, v.getCNIC());
            pst.setString(3, v.getContactNo());
            pst.setString(4, v.getCompanyName());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet GetRecordsBatch() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [Batch]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet GetRecordsWarehouseItem() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [WarehouseItems]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet GetRecordsReceipt() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "select R.ReceiptID,R.CustomerCNIC,R.CashierCNIC,R.Discount,RI.Item_SKU,RI.Quantity\n"
                    + "from Receipts AS R join ReceiptItem AS RI on R.ReceiptID=RI.ReceiptID";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet GetCredentials() {
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Select * from [LoginInformation]";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    public void RemoveBatchFromDb(int id)
     {
         
      try
        {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [RemoveBatch](?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setInt(1,id);
            Cmt.execute();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
    public void AddStoreItemRecordDb(String sku, String Name, float price, int perishable, int fragile, String department, int quantity, String expiry) {
        try {

            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "Insert into [StoreItems]" + "values (?,?,?,?,?, ?, ?,?)";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            pst.setString(1, sku);
            pst.setString(2, Name);
            pst.setFloat(3, price);
            pst.setInt(4, perishable);
            pst.setInt(5, fragile);
            pst.setString(6, department);
            pst.setInt(7, quantity);
            pst.setString(8, expiry);

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
       public void updateItemQuantityDb(String sku, int quantity) {

        try {
            Connection con = DriverManager.getConnection(url);
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String SQL = "{call [UpdateItemQuantity](?,?)}"; // for Microsoft SQL Server
            CallableStatement Cmt = con.prepareCall(SQL);
            Cmt.setInt(2, quantity);
            Cmt.setString(1, sku);
            Cmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class InventorySystem {
     Store store;
     Warehouse warehouse;
    
    public InventorySystem(){
        store = new Store();
        warehouse = new Warehouse();
    }
    
    public Store getStore(){
        return store;
    }
    public Warehouse getWarehouse(){
        return warehouse;
    }
}

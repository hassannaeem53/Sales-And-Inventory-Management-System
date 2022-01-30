/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class Item {
    private String SKU;
    private String name;
    private float price;
    private int isFragile;
    private Department department;

    public Item(String SKU, String name, float price, int isFragile,Department department){
        this.SKU = SKU;
        this.name = name;
        this.price = price;
        this.isFragile = isFragile;
        this.department=department;
    }
    
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
    public boolean isExpired()throws Exception{return false;}

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
    //Getters
    public String getSKU(){
        return SKU;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public int getIsFragile(){
        return this.isFragile;
    }
    public Department getDepartment(){
        return department;
    } 
    //Setters
    public void setIsFragile(int isFragile){
        this.isFragile = isFragile;
    }
    public int isPerishable(){
        return 0;
    }
    public float getDiscount(){
        if(department.getPromotion()!=null){
            return department.getPromotion().getDiscount();
        }
        return 0;
    }
    public void setExpiry(String expiryDate){}
    public String getExpiry(){return "";}
    
}

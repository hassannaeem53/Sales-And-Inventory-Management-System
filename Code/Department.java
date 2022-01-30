/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class Department {
    private String departmentName;
    private Promotion promotion;

    
    public Department(String departmentName,Promotion promotion){
        this.departmentName = departmentName;
        this.promotion = promotion;
    }
    //Getters
    public String getDepartmentName(){
        return departmentName;
    }
    public Promotion getPromotion(){
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
    
    
}

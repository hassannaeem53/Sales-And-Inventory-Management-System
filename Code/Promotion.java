/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Code;

/**
 *
 * @author Fatimah
 */
public class Promotion {

    public int getId() {
        return id;
    }
    private int id;
    private String name;
    private String startingDate;
    private String endingDate;
    private float discount;

    public Promotion(int id, String name, String startingDate, String endingDate, float discount) {
        this.id = id;
        this.name = name;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public float getDiscount() {
        return discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

}

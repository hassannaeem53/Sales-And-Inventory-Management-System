/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Kashif khan
 */
public class SingletonPattern {

    private static SingletonPattern obj;

    private SingletonPattern() {
    }

    public static SingletonPattern getInstance() {
        if (obj == null) {
            obj = new SingletonPattern();
        }
        return obj;
    }
    private InventorySystem system = new InventorySystem();

    public InventorySystem getSystem() {
        return system;
    }

}

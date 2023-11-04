//Desarrollado por CristianGuasca
package co.edu.ue.pet.Entities;

import java.io.Serializable;

public class Costumer implements Serializable {
    // Attributes
    private String name;
    private String last;
    private String address;
    private String selectedFruits;
    private int totalCost;

    // Constructor
    public Costumer(String name,String last, String address) {
        this.name = name;
        this.last = last;
        this.address = address;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getSelectedFruits() {
        return selectedFruits;
    }

    public void setSelectedFruits(String selectedFruits) {
        this.selectedFruits = selectedFruits;
    }

    // Info
    @Override
    public String toString() {
        return '\n' + "Name=" + name + " " + last + '\n' +
                "Address=" + address + '\n' +
                "You buy: " + selectedFruits + '\n' +
                "Total Cost: $" + totalCost + '\n';
    }
}
//Desarrollado por CristianGuasca
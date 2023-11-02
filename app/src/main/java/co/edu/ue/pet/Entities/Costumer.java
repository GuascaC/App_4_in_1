//Desarrollado por CristianGuasca
package co.edu.ue.pet.Entities;

import android.location.Address;

import java.io.Serializable;

public class Costumer implements Serializable {
    //Atributtes
    private String name;
    private String last;
    private String address;
    private String selectedFruits;
    //Constructor

    public Costumer(String name, String last, String address) {
        this.name = name;
        this.last = last;
        this.address = address;
    }
    //Info
    @Override
    public String toString() {
        return
                '\n'+"Name=" + name + " " + last + '\n' +
                        "Address=" + address + '\n' +
                        "You buy:"  + selectedFruits + '\n';
    }

    public String getSelectedFruits() {
        return selectedFruits;
    }
    public void setSelectedFruits(String selectedFruits) {
        this.selectedFruits = selectedFruits;
    }
}
//Desarrollado por CristianGuasca
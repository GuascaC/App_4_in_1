//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import co.edu.ue.pet.Entities.Costumer;

public class Products extends AppCompatActivity {

    private CheckBox rbApple;
    private CheckBox rbPear;
    private CheckBox rbBanana;
    private CheckBox rbPineapple;
    private CheckBox rbGrape;
    private CheckBox rbPeach;
    private Button btnBuy;
    private Costumer costumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        receive();
        start();
        btnBuy.setOnClickListener(this::data);
    }

    private void goBill(Costumer costumer) {
        Intent bill = new Intent(getApplicationContext(), Bill.class);
        bill.putExtra("costumer", costumer);
        startActivity(bill);
    }

    //Products
    private void data(View view) {
        String selectedFruits = "";
        if (rbApple.isChecked()) {
            selectedFruits += "Apple, ";
        }
        if (rbPear.isChecked()) {
            selectedFruits += "Pear, ";
        }
        if (rbBanana.isChecked()) {
            selectedFruits += "Banana, ";
        }
        if (rbPineapple.isChecked()) {
            selectedFruits += "Pineapple, ";
        }
        if (rbGrape.isChecked()) {
            selectedFruits += "Grape, ";
        }
        if (rbPeach.isChecked()) {
            selectedFruits += "Peach, ";
        }
        if (selectedFruits.endsWith(", ")) {
            selectedFruits = selectedFruits.substring(0, selectedFruits.length() - 2);
        }
            costumer.setSelectedFruits(selectedFruits);
            goBill(costumer);
    }
    //Receive
    public void receive() {
        Bundle receiveData = getIntent().getExtras();
        if (receiveData != null) {
            costumer = (Costumer) receiveData.get("costumer");
        }
    }

    private void start() {
        rbApple = findViewById(R.id.rbApple);
        rbPear = findViewById(R.id.rbPear);
        rbBanana = findViewById(R.id.rbBanana);
        rbPineapple = findViewById(R.id.rbPineapple);
        rbGrape = findViewById(R.id.rbGrape);
        rbPeach = findViewById(R.id.rbPeach);
        btnBuy = findViewById(R.id.btnBuy);
    }
}
//Desarrollado por CristianGuasca
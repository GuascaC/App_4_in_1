//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
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

    // Prices
    private static final int PRICE_APPLE = 100;
    private static final int PRICE_PEAR = 200;
    private static final int PRICE_BANANA = 2000;
    private static final int PRICE_PINEAPPLE = 500;
    private static final int PRICE_GRAPE = 1000;
    private static final int PRICE_PEACH = 5000;

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

    // Total
    private void data(View view) {
        StringBuilder selectedFruits = new StringBuilder();
        if (rbApple.isChecked()) {
            selectedFruits.append("Apple, ");
        }
        if (rbPear.isChecked()) {
            selectedFruits.append("Pear, ");
        }
        if (rbBanana.isChecked()) {
            selectedFruits.append("Banana, ");
        }
        if (rbPineapple.isChecked()) {
            selectedFruits.append("Pineapple, ");
        }
        if (rbGrape.isChecked()) {
            selectedFruits.append("Grape, ");
        }
        if (rbPeach.isChecked()) {
            selectedFruits.append("Peach, ");
        }
        if (selectedFruits.length() > 0) {
            selectedFruits.setLength(selectedFruits.length() - 2); // Remove the trailing comma and space
        }
        costumer.setSelectedFruits(selectedFruits.toString());
        int totalCost = calculateTotalCost();
        costumer.setTotalCost(totalCost);
        goBill(costumer);
    }

    private int calculateTotalCost() {
        int totalCost = 0;
        if (rbApple.isChecked()) {
            totalCost += PRICE_APPLE;
        }
        if (rbPear.isChecked()) {
            totalCost += PRICE_PEAR;
        }
        if (rbBanana.isChecked()) {
            totalCost += PRICE_BANANA;
        }
        if (rbPineapple.isChecked()) {
            totalCost += PRICE_PINEAPPLE;
        }
        if (rbGrape.isChecked()) {
            totalCost += PRICE_GRAPE;
        }
        if (rbPeach.isChecked()) {
            totalCost += PRICE_PEACH;
        }
        return totalCost;
    }

    // Receive
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
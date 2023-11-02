//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import co.edu.ue.pet.Entities.Costumer;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {
    private EditText etName;
    private EditText etLast;
    private EditText etAddress;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        start();
        btnRegister.setOnClickListener(this::data);
    }
    private void goBuy(Costumer costumer) {
        Intent products = new Intent(getApplicationContext(), Products.class);
        products.putExtra("costumer",costumer);
        startActivity(products);
    }
    //"Register"
    private void data(View view) {
        String name = etName.getText().toString().trim();
        String lastName = etLast.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        if (name.isEmpty() || lastName.isEmpty() || address.isEmpty()) {
            //Mensaje
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Costumer customer = new Costumer(name, lastName, address);
            goBuy(customer);
        }
    }

    private void start(){
        this.etName = findViewById(R.id.etName);
        this.etAddress = findViewById(R.id.etAddress);
        this.etLast = findViewById(R.id.etLast);

        this.btnRegister = findViewById(R.id.btnRegister);
    }
}
//Desarrollado por CristianGuasca
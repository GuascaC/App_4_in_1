//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.edu.ue.pet.Entities.Costumer;

public class Bill extends AppCompatActivity {

    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        Button button = findViewById(R.id.btnHome);
        this.data = findViewById(R.id.data);
        receive();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });
    }
    //Receive data
        public void receive(){
            Bundle receiveData = getIntent().getExtras();
            if(receiveData != null) {
                Costumer costumer;
                costumer = (Costumer) receiveData.get("costumer");
                data.setText("Costumer data:" + costumer);
            }
        }
    }
//Desarrollado por CristianGuasca
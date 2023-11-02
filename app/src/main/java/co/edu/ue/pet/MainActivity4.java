//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private EditText etIMCHI;
    private EditText etIMCWI;
    private EditText etIMCHM;
    private EditText etIMCWM;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button button = findViewById(R.id.btnHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        etIMCHI = findViewById(R.id.etIMCHI);
        etIMCWI = findViewById(R.id.etIMCWI);
        etIMCHM = findViewById(R.id.etIMCHM);
        etIMCWM = findViewById(R.id.etIMCWM);
        tvDate = findViewById(R.id.tvResult);

        Button btnIMCI = findViewById(R.id.btnIMCI);
        Button btnIMCM = findViewById(R.id.btnIMCM);

        btnIMCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput(etIMCHI, etIMCWI)) {
                    calculateIMCI();
                } else {
                    displayValidationError();
                }
            }
        });

        btnIMCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput(etIMCHM, etIMCWM)) {
                    calculateIMCM();
                } else {
                    displayValidationError();
                }
            }
        });
    }

    //English
    private void calculateIMCI() {
        double height = Double.parseDouble(etIMCHI.getText().toString());
        double weight = Double.parseDouble(etIMCWI.getText().toString());

        double imc = weight / (height * height);

        tvDate.setText("IMC (English system): " + imc + "kg/m²");
    }
    //Metric
    private void calculateIMCM() {
        double height = Double.parseDouble(etIMCHM.getText().toString());
        double weight = Double.parseDouble(etIMCWM.getText().toString());

        double imc = weight / (height * height);

        tvDate.setText("IMC (Metric system): " + imc + "kg/m²");
    }

    private boolean validateInput(EditText heightEditText, EditText weightEditText) {
        String heightText = heightEditText.getText().toString();
        String weightText = weightEditText.getText().toString();
        return !heightText.isEmpty() && !weightText.isEmpty();
    }

    private void displayValidationError() {
        Toast.makeText(this, "Please enter values in both fields.", Toast.LENGTH_SHORT).show();
    }
}
//Desarrollado por CristianGuasca
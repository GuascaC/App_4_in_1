//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etDate;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnHome);
        etDate = findViewById(R.id.etDate);
        tvDate = findViewById(R.id.tvDate);
        Button btnCalculate = findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAge();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //Pickeable Date

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                calendar.set(selectedYear, selectedMonth, selectedDay);
                String formattedDate = sdf.format(calendar.getTime());
                etDate.setText(formattedDate);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    //Convertion and substract
    private void calculateAge() {
        String dateStr = etDate.getText().toString().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        sdf.setLenient(false);

        try {
            Date birthDate = sdf.parse(dateStr);
            Date currentDate = new Date();

            long ageInMillis = currentDate.getTime() - birthDate.getTime();
            long ageYears = ageInMillis / (1000L * 60 * 60 * 24 * 365);

            if (ageYears < 0) {
                tvDate.setText("Invalid date: Age can't be negative");
            } else {
                tvDate.setText(ageYears + " years old");
            }
        } catch (ParseException e) {
            tvDate.setText("Invalid date format");
        }
    }
}
//Desarrollado por CristianGuasca
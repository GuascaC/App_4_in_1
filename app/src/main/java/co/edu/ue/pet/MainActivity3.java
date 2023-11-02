//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity3 extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private RadioGroup radioGroup6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        radioGroup1 = findViewById(R.id.rgTwo);
        radioGroup2 = findViewById(R.id.rgThree);
        radioGroup3 = findViewById(R.id.rgFour);
        radioGroup4 = findViewById(R.id.rgFive);
        radioGroup5 = findViewById(R.id.rgSix);
        radioGroup6 = findViewById(R.id.rgSeven);

        AtomicInteger score = new AtomicInteger(0);

        //Answers

        final String answer1 = getString(R.string.rbTest1A);
        final String answer2 = getString(R.string.rbTest2B);
        final String answer3 = getString(R.string.rbTest3C);
        final String answer4 = getString(R.string.rbTest4A);
        final String answer5 = getString(R.string.rbTest5B);
        final String answer6 = getString(R.string.rbTest6C);

        radioGroup1.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(answer1)) {
                score.incrementAndGet();
            }
        });

        radioGroup2.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(answer2)) {
                score.incrementAndGet();
            }
        });

        radioGroup3.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(answer3)) {
                score.incrementAndGet();
            }
        });
        radioGroup4.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(answer4)) {
                score.incrementAndGet();
            }
        });
        radioGroup5.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(answer5)) {
                score.incrementAndGet();
            }
        });
        radioGroup6.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            if (selectedAnswer.equals(answer6)) {
                score.incrementAndGet();
            }
        });

        //Send score
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity3.this, Test.class);
            intent.putExtra("score", score.get());
            startActivity(intent);
        });
    }
}
//Desarrollado por CristianGuasca

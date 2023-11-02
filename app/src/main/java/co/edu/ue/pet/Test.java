//Desarrollado por CristianGuasca
package co.edu.ue.pet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Test extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button = findViewById(R.id.btnHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });
        //Get Score

        int score = getIntent().getIntExtra("score", 0);

        TextView tvResult = findViewById(R.id.tvResult);

        String message;
        if (score <= 0) {
            message = "Try again";
        } else if (score <= 4 && score > 2) {
            message = "Good";
        } else if (score == 5) {
            message = "Great";
        } else if (score == 6) {
            message = "Congrats!";
        } else {
            message = "Invalid score";
        }

        tvResult.setText("Score: " + score + "/6\n" + message);
    }
}
//Desarrollado por CristianGuasca
package com.example.matma;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button oblicz = findViewById(R.id.Policz);

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText wartosc_a = findViewById(R.id.editTextA);
                EditText wartosc_b = findViewById(R.id.editTextB);
                EditText wartosc_c = findViewById(R.id.editTextC);
                EditText wynik = findViewById(R.id.editTextWynik);

                double a = Double.parseDouble(wartosc_a.getText().toString());
                double b = Double.parseDouble(wartosc_b.getText().toString());
                double c = Double.parseDouble(wartosc_c.getText().toString());

                Double delta = (b * b)-4*a*c;

                if (delta > 0){
                    double x1 = (-b+Math.sqrt(delta)) / (2*a); //  B -4 * A * C;
                    double x2 = (-b-Math.sqrt(delta)) / (2*a);

                    wynik.setText("wynik: x1:" + x1 + ", x2:" +x2);
                } else if (delta ==0){
                    double x = -b / (2*a);

                    wynik.setText("wynik: x:" + x);
                } else if (delta <0){
                    Toast.makeText(getBaseContext(),"Brak roziwazan",Toast.LENGTH_SHORT).show();
                }

            };
        });

    }
}
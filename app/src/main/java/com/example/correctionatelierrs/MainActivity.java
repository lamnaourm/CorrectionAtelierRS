package com.example.correctionatelierrs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e;
    Button b1, b2;
    RadioGroup rg;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e = findViewById(R.id.eval);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        rg = findViewById(R.id.grp);
        t = findViewById(R.id.tresrr);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Valeur saisie vide", Toast.LENGTH_SHORT).show();
                    return;
                }
                int taux=0;
                double val = Double.valueOf(e.getText().toString());
                if(rg.getCheckedRadioButtonId()==R.id.rd1){
                    taux = getResources().getInteger(R.integer.dollar_taux);
                }else {
                    taux = getResources().getInteger(R.integer.euro_taux);
                }

                t.setText(String.format("%.2f",val/taux));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.getText().clear();
                rg.check(R.id.rd2);
                e.requestFocus();
                t.setText(getString(R.string.default_res));
            }
        });
    }
}
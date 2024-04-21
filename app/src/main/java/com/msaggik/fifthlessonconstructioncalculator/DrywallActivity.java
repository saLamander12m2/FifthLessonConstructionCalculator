package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DrywallActivity extends AppCompatActivity {

    private EditText squareDrywall; // площадь оклеиваемой поверхности
    private EditText widthDrywall, heightDrywall, costDrywall; // параметры рулона обоев
    private Button buttonNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drywall);


        squareDrywall = findViewById(R.id.squareDrywall);
        widthDrywall = findViewById(R.id.widthDrywall);
        heightDrywall = findViewById(R.id.heightDrywall);
        costDrywall = findViewById(R.id.costDrywall);
        buttonNextActivity = findViewById(R.id.buttonNextActivity);


        buttonNextActivity.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Please, select a value",
                    Toast.LENGTH_LONG).show();

                int squareDrywallInt = Integer.parseInt(squareDrywall.getText().toString());
                int widthDrywallInt = Integer.parseInt(widthDrywall.getText().toString());
                int heightDrywallInt = Integer.parseInt(heightDrywall.getText().toString());
                int costDrywallInt = Integer.parseInt(costDrywall.getText().toString());

                Drywall drywall = new Drywall(widthDrywallInt, heightDrywallInt, costDrywallInt);

                Intent intent = new Intent(getApplicationContext(), CalculationDrywallActivity.class);
                intent.putExtra("keySquareDrywall", squareDrywallInt); // вложение в намерение значения squareInt по ключу keySquare
                intent.putExtra(Drywall.class.getSimpleName(), drywall); // вложение в намерение значения объекта wallpaper по ключу Wallpaper.class.getSimpleName()
                startActivity(intent);
        });
    }
}
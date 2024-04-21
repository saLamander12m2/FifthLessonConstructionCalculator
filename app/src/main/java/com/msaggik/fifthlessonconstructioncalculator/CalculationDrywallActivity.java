package com.msaggik.fifthlessonconstructioncalculator;

import static java.lang.Math.floor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class CalculationDrywallActivity extends AppCompatActivity {

    private TextView output; // вывод результата
    private Button buttonBack, buttonNew; // кнопки возврата назад

    private double count = 0; // количество рулонов обоев для оклейки
    private double costAll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        output = findViewById(R.id.output);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNew = findViewById(R.id.buttonNew);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int squareDrywallInt = bundle.getInt("keySquareDrywall"); // извлечение параметра площади оклеиваемой поверхности
            Drywall drywall = (Drywall) bundle.getSerializable(Drywall.class.getSimpleName()); // извлечение объекта рулона обоев
            // расчёт рулонов обоев (площадь поверхности (м*м) / (длину (м) * ширину (см) / 100))
            count = (double) squareDrywallInt / ((drywall.getHeightDrywall() * drywall.getWidthDrywall()) / 10000);
            if ((double) squareDrywallInt / ((drywall.getHeightDrywall() * drywall.getWidthDrywall()) / 10000) > 0) { // если при делении образуется остаток, то нужен ещё один рулон
                count++;
            }

            costAll = count * drywall.getCostDrywall();


            output.setText("Для строительства нужно " + count + " листов/а гипсокартона\nИх стоимость " + costAll + " монет");
        }


        buttonBack.setOnClickListener(listener);
        buttonNew.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = null; // объявление намерения

            // инициализация намерения
            switch (view.getId()) {
                case R.id.buttonBack:
                    intent = new Intent(getApplicationContext(), DrywallActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // удаление всех активностей кроме той на которую происходит переход
                    break;
                case R.id.buttonNew:
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // перемещение нужной активности на вершину стека
                    break;
            }
            startActivity(intent); // запуск намерения
        }
    };
}
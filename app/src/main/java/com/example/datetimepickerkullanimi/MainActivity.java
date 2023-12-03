package com.example.datetimepickerkullanimi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSaat, editTextTarix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSaat = findViewById(R.id.editTextSaat);
        editTextTarix = findViewById(R.id.editTextTarix);

        editTextSaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int saat = calendar.get(Calendar.HOUR_OF_DAY);
                int deqiqe = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePicker;

                timePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        editTextSaat.setText(i+" : "+i1);
                    }
                },saat,deqiqe,true);

                timePicker.setTitle("Saat secin");
                timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Teyin et",timePicker);
                timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"Legv et",timePicker);

                timePicker.show();
            }
        });

        editTextTarix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int il = calendar.get(Calendar.YEAR);
                int ay = calendar.get(Calendar.MONTH);
                int gun = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker;

                datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editTextTarix.setText(i2+"/"+i1+"/"+i);
                    }
                },il,ay,gun);

                datePicker.setTitle("Tarix secin");
                datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"Teyin et",datePicker);
                datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"Legv et",datePicker);
                datePicker.show();
            }
        });
    }
}
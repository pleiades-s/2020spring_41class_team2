package com.example.bloodwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class SearchConfigureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_configure);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView searchStartDateText = (TextView) findViewById(R.id.search_configure_start_date);
        searchStartDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext());
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String dateString = GetDate(year, month, dayOfMonth);
                        searchStartDateText.setText(dateString);
                    }
                });
                datePickerDialog.show();
            }
        });

        final TextView searchEndDateText = (TextView) findViewById(R.id.search_configure_end_date);
        searchEndDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext());
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String dateString = GetDate(year, month, dayOfMonth);
                        searchEndDateText.setText(dateString);
                    }
                });
            }
        });


    }

    private String GetDate(int year, int month, int day) {
        return String.format("%d.%02d.%02d", year % 100, month + 1, day);
    }
}

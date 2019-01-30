package com.example.pickerfordate;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment  = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datepicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String monthString = Integer.toString(month+1);
        String dayString = Integer.toString(day);
        String yearString = Integer.toString(year);
        String dateMessage = (monthString + "/" + dayString + "/" + yearString);
        Toast.makeText(getApplicationContext(), "Date: "+dateMessage, Toast.LENGTH_SHORT).show();
    }
}

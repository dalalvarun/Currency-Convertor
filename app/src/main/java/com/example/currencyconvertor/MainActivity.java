package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view)
    {
        Switch rev = (Switch) findViewById(R.id.reverse);
        boolean isRev = rev.isChecked();
        double us=0, ir=0;
        EditText USD = (EditText) findViewById(R.id.USD);
        try {
            us = parseDouble(USD.getText().toString());
        }
        catch(NumberFormatException ex)
        {
            Toast.makeText(this, "Enter USD Value", Toast.LENGTH_SHORT).show();
        }
        EditText INR = (EditText) findViewById(R.id.INR);
        try {
            ir = parseDouble(INR.getText().toString());
        }
        catch (NumberFormatException ex)
        {
            Toast.makeText(this, "Enter INR Value", Toast.LENGTH_SHORT).show();
        }
        if(isRev)
        {
            double ans = ir/73.98;
            USD.setText(String.format("%.2f",ans));
        }
        else
        {
            double ans = us*73.98;
            INR.setText(String.format("%.2f",ans));
        }

    }
}
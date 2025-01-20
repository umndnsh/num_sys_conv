package com.example.converter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.converter.R;

public class ConverterActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private Button btnDecimal, btnHexa, btnBinary, btnOctal;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter); // Use activity2.xml for this screen

        // Initialize views
        editTextNumber = findViewById(R.id.editTextText);
        btnDecimal = findViewById(R.id.decibtn);
        btnHexa = findViewById(R.id.hexabtn);
        btnBinary = findViewById(R.id.binarybtn);
        btnOctal = findViewById(R.id.octabtn);
        answerTextView = findViewById(R.id.Answer); // Reference to the Answer TextView

        // Set up button listeners
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToDecimal();
            }
        });

        btnHexa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToHexadecimal();
            }
        });

        btnBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToBinary();
            }
        });

        btnOctal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToOctal();
            }
        });
    }

    private void convertToDecimal() {
        String input = editTextNumber.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            showResult("Please enter a number");
            return;
        }
        try {
            int number = Integer.parseInt(input);
            showResult("Decimal: " + number);
        } catch (NumberFormatException e) {
            showResult("Invalid number format");
        }
    }

    private void convertToHexadecimal() {
        String input = editTextNumber.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            showResult("Please enter a number");
            return;
        }
        try {
            int number = Integer.parseInt(input);
            String hex = Integer.toHexString(number).toUpperCase();
            showResult("Hexadecimal: " + hex);
        } catch (NumberFormatException e) {
            showResult("Invalid number format");
        }
    }

    private void convertToBinary() {
        String input = editTextNumber.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            showResult("Please enter a number");
            return;
        }
        try {
            int number = Integer.parseInt(input);
            String binary = Integer.toBinaryString(number);
            showResult("Binary: " + binary);
        } catch (NumberFormatException e) {
            showResult("Invalid number format");
        }
    }

    private void convertToOctal() {
        String input = editTextNumber.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            showResult("Please enter a number");
            return;
        }
        try {
            int number = Integer.parseInt(input);
            String octal = Integer.toOctalString(number);
            showResult("Octal: " + octal);
        } catch (NumberFormatException e) {
            showResult("Invalid number format");
        }
    }

    private void showResult(String message) {
        // Set the result in the Answer TextView
        answerTextView.setText(message);

    }

}



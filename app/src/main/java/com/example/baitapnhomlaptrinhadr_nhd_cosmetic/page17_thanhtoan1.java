package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class page17_thanhtoan1 extends AppCompatActivity {

    private EditText etFirstName, etStreetName, etCity, etProvince, etPhoneNumber;
    private Spinner spinnerCountry;
    private RadioGroup rgShippingMethod;
    private Button btnCodecf,btnConfirm;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_17_thanhtoan1); // Change to your actual layout file name

        etFirstName = findViewById(R.id.etFirstName);
        etStreetName = findViewById(R.id.etStreetName);
        etCity = findViewById(R.id.etCity);
        etProvince = findViewById(R.id.etProvince);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        rgShippingMethod = findViewById(R.id.rgShippingMethod);
        btnCodecf = findViewById(R.id.btnCodecf);
        btnConfirm = findViewById(R.id.btnConfirm);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // Set up button click listener
        btnConfirm.setOnClickListener(view -> {
            Intent intent = new Intent(page17_thanhtoan1.this, page18_thanhtoan2.class);
            startActivity(intent);
        });
    }


}
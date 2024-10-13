package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        // Set up button click listener
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmOrder();
            }
        });
    }

    private void confirmOrder() {
        String firstName = etFirstName.getText().toString().trim();
        String streetName = etStreetName.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String province = etProvince.getText().toString().trim();
        String phoneNumber = etPhoneNumber.getText().toString().trim();

        // Get selected country from spinner
        String country = spinnerCountry.getSelectedItem().toString();

        // Get selected shipping method
        int selectedId = rgShippingMethod.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        String shippingMethod = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";
        if (firstName.isEmpty() || streetName.isEmpty() || city.isEmpty() ||
                province.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Toast.makeText(this, "Đơn hàng của bạn đã được xác nhận!\n" +
                    "Tên: " + firstName + "\n" +
                    "Địa chỉ: " + streetName + ", " + city + ", " + province + ", " + country + "\n" +
                    "Số điện thoại: " + phoneNumber + "\n" +
                    "Phương thức vận chuyển: " + shippingMethod, Toast.LENGTH_LONG).show();
        };
    }
}
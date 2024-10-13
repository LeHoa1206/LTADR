package com.example.baitapnhomlaptrinhadr_nhd_cosmetic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class chitietsanpham extends AppCompatActivity {

    private Button addToCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);

        // Initialize the button
        addToCartButton = findViewById(R.id.add_to_cart_button);

        // Set an OnClickListener to switch activities when the button is clicked
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to SecondActivity
                Intent intent = new Intent(chitietsanpham.this, page10_Trangchu.class);
                startActivity(intent);  // Start the new activity
            }
        });
    }
}

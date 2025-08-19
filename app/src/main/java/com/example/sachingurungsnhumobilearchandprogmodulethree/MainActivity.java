package com.example.sachingurungsnhumobilearchandprogmodulethree;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private EditText nameText;
    private TextView textGreeting;
    private Button buttonSayHello;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect UI components
        nameText = findViewById(R.id.nameText);
        textGreeting = findViewById(R.id.textGreeting);
        buttonSayHello = findViewById(R.id.buttonSayHello);

        // Disable button initially
        buttonSayHello.setEnabled(false);

        // Add TextWatcher to enable/disable the button based on input
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buttonSayHello.setEnabled(s.toString().trim().length() > 0);
            }
        });
    }

    public void SayHello(View view) {
        String name = nameText.getText().toString().trim();

        if (name.isEmpty()) {
            return;
        }

        textGreeting.setText("Hello " + name + "!");
    }
}

package com.example.baithi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    EditText name, quantity;
    Button insert, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        name = findViewById(R.id.name);
        quantity = findViewById(R.id.quantity);
        insert = findViewById(R.id.Add);
        view = findViewById(R.id.View);

        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormActivity.this, ListActivity.class));
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String quantityTXT = quantity.getText().toString();

                Boolean checkinsertdata  = DB.insertuserdata(nameTXT, quantityTXT);
                if(checkinsertdata==true)
                {
                    Toast.makeText(FormActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(FormActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
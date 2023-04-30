package com.example.diyarbakrgezi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button geziBtn, yemekBtn, konakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        MainActivity.this.getWindow().setBackgroundDrawableResource(R.drawable.bg);

        geziBtn = (Button) findViewById(R.id.geziBtn);
        yemekBtn = (Button) findViewById(R.id.yemekBtn);
        konakBtn = (Button) findViewById(R.id.konakBtn);

        geziBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GezilecekYerler.class));
            }
        });
        konakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), otelList.class));
            }
        });
        yemekBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), YemekList.class));
            }
        });

    }
}
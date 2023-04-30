package com.example.diyarbakrgezi;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class otelinfo extends otelList {
    private Button araBtn, mapBtn;
    private TextView infoView;
    private ImageSlider slider;
    ArrayList<SlideModel> slideModels = new ArrayList<>();
    oteller otel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_info);
        Bundle extras = getIntent().getExtras();
        int sayi = extras.getInt("Sayi");
        otel = konaklar[sayi];
        setTitle(otel.name);

        araBtn = findViewById(R.id.araBtn);
        mapBtn = findViewById(R.id.mapBtnx);
        slider = findViewById(R.id.Slider);
        infoView = findViewById(R.id.metin);
        infoView.setText(otel.text);

        for(int i = 0; i < otel.imageLink.length; i++){
            slideModels.add(new SlideModel(otel.imageLink[i], ScaleTypes.FIT));
        }

        slider.setImageList(slideModels, ScaleTypes.FIT);

        araBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+otel.number));
                if (ActivityCompat.checkSelfPermission(otelinfo.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(otelinfo.this,
                            new String[]{Manifest.permission.CALL_PHONE}, 1);
                }else{
                    startActivity(callIntent);
                }
            }

        });
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(otel.location);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
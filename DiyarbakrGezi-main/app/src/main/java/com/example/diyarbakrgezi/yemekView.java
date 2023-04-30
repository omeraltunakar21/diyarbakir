package com.example.diyarbakrgezi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class yemekView extends YemekList {
    private Button mapBtn;
    private TextView infoView;
    private ImageSlider slider;
    ArrayList<SlideModel> slideModels = new ArrayList<>();
    yemekler yemek1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_view);
        Bundle extras = getIntent().getExtras();
        int sayi = extras.getInt("Sayi");
        yemek1 = yemek[sayi];
        setTitle(yemek1.name);

        mapBtn = findViewById(R.id.mapBtnx);
        slider = findViewById(R.id.Slider);
        infoView = findViewById(R.id.metin);
        infoView.setText(yemek1.text);

        for(int i = 0; i < yemek1.imageLink.length; i++){
            slideModels.add(new SlideModel(yemek1.imageLink[i], ScaleTypes.FIT));
        }

        slider.setImageList(slideModels, ScaleTypes.FIT);

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(yemek1.location);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
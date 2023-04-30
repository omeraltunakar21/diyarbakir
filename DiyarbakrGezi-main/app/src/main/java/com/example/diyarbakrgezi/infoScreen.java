package com.example.diyarbakrgezi;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class infoScreen extends GezilecekYerler {
    private TextView yaziView;
    private Button mapBtn;
    private ImageView imageView;
    yerler yer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);
        Bundle extras = getIntent().getExtras();
        int sayi = extras.getInt("Sayi");
        yer = bolgeler[sayi];
        setTitle(yer.getName());

        yaziView = (TextView) findViewById(R.id.yaziView);
        mapBtn = (Button) findViewById(R.id.mapBtn1);
        imageView = (ImageView) findViewById(R.id.imageView2);


        yaziView.setText(yer.getText());
        int draw = yer.getPicture();
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),draw);
        imageView.setImageBitmap(bitmap);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(yer.getLocation());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
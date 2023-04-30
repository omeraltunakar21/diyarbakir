package com.example.diyarbakrgezi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class YemekList extends AppCompatActivity {

    private ListView listView;

    String[] xaleMehemeImg = {"https://media-cdn.tripadvisor.com/media/photo-s/17/82/4b/0c/ocakbasi.jpg", "https://www.diyarbakirsoz.com/Images/218565.webp", "https://images.culinarybackstreets.com/wp-content/uploads/cb_istanbul_eo_liver_final_Mehme.jpg"};
    yemekler xaleMeheme = new yemekler("Xale Meheme", "https://goo.gl/maps/avzWjYiYhkwRDWhd6", "", "Ciğerci", R.drawable.xalemeheme, xaleMehemeImg);

    String[] diyarbakirHanciImg = {"https://media-cdn.tripadvisor.com/media/photo-p/14/c1/a3/dd/photo1jpg.jpg", "https://media-cdn.tripadvisor.com/media/photo-f/1c/1a/52/63/firin-yemekleri-ve-yemeklerin.jpg", "https://media-cdn.tripadvisor.com/media/photo-s/1b/2d/ea/63/hanci-et.jpg", "https://media-cdn.tripadvisor.com/media/photo-f/16/78/c0/18/photo0jpg.jpg"};
    yemekler diyarbakirHanci = new yemekler("Diyarbakır Hancı", "https://goo.gl/maps/NbVtWG2kibTVKaTh9", "", "Et Lokantası", R.drawable.diyarbakirhanci, diyarbakirHanciImg);

    String[] cigerciRemziImg = {"https://media-cdn.tripadvisor.com/media/photo-w/12/38/9f/6a/photo1jpg.jpg", "https://media-cdn.tripadvisor.com/media/photo-w/12/38/9b/af/cigerci-remzi-usta.jpg", "https://media-cdn.tripadvisor.com/media/photo-o/1b/87/7f/df/img-20200710-164545-largejpg.jpg", "https://media-cdn.tripadvisor.com/media/photo-w/12/38/9f/6b/photo2jpg.jpg", "https://media-cdn.tripadvisor.com/media/photo-w/12/38/9b/b3/cigerci-remzi-usta.jpg"};
    yemekler cigerciRemzi = new yemekler("Ciğerci Remzi Usta", "https://goo.gl/maps/Atz96JimpvJDfdjWA", "", "Ciğerci", R.drawable.cigerciremzi, cigerciRemziImg);

    String[] hasanPasaHaniImg = {"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/25/31/f5/d7/caption.jpg?w=900&h=-1&s=1", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/e0/6e/31/20190607-160754-largejpg.jpg?w=1100&h=-1&s=1", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/90/07/22/omer-in-yeri-musteriyi.jpg?w=1200&h=-1&s=1", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/10/e5/37/fb/ust-kat-2.jpg?w=1200&h=-1&s=1", "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/68/4d/ca/photo0jpg.jpg?w=1200&h=-1&s=1"};
    yemekler hasanPasaHani = new yemekler("Hasan Paşa Hanı", "https://goo.gl/maps/VCPx9hEKSkvFGZh88", "", "Kahvaltı & Kafe", R.drawable.hasanpasahani, hasanPasaHaniImg);

    String[] lokumEtImg = {"https://i.ytimg.com/vi/sEijfb1X368/maxresdefault.jpg","https://i.ytimg.com/vi/PP0VDzYiUO4/maxresdefault.jpg", "https://media.safarway.com/content/3c4f6389-006e-49c6-a9c7-2e41b5e35ec4_sm.jpg", "https://media.safarway.com/content/f4d787cd-735c-44a0-a643-90f25e8170e5_xs.jpg"};
    yemekler lokumEt = new yemekler("Loqum Et-Steakhouse", "https://goo.gl/maps/LwuxotmY4hmHU9bq9", "", "Et Lokantası", R.drawable.loqumet, lokumEtImg);

    yemekler[] yemek = {xaleMeheme, diyarbakirHanci, cigerciRemzi, hasanPasaHani, lokumEt};
    String mBaslik[] = new String[yemek.length];
    String mAciklama[] = new String[yemek.length];
    int mresim[] = new int[yemek.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_list);

        for(int i = 0; i < yemek.length; i++){
            mBaslik[i] = yemek[i].name;
            mAciklama[i] = yemek[i].aciklama;
            mresim[i] = yemek[i].picture;
        }

        listView = findViewById(R.id.listView);
        benimAdapter adapter = new benimAdapter(this,mBaslik,mAciklama,mresim);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), yemekView.class);
                intent.putExtra("Sayi", i);
                startActivity(intent);
            }
        });
    }

    class benimAdapter extends ArrayAdapter<String> {
        Context context;
        String rBaslik[];
        String rAciklama[];
        int rresim[];

        benimAdapter(Context c, String baslik[], String Aciklama[], int resim[]) {
            super(c, R.layout.cutom_listview, R.id.text1, baslik);
            this.context = c;
            this.rBaslik = baslik;
            this.rAciklama = Aciklama;
            this.rresim = resim;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View satir = layoutInflater.inflate(R.layout.cutom_listview, parent, false);
            ImageView resim = satir.findViewById(R.id.resim);
            TextView benimBaslik = satir.findViewById(R.id.text1);
            TextView benimAciklama = satir.findViewById(R.id.text2);

            resim.setImageResource(rresim[position]);
            benimBaslik.setText(rBaslik[position]);
            benimAciklama.setText(rAciklama[position]);


            return satir;


        }
    }
}
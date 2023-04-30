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

public class otelList extends AppCompatActivity {

    String[] diyarbakirImg = {"https://cdn.worldota.net/t/640x400/content/a9/22/a922dd8eaff15ed08021458d27568ca28d9f6447.jpeg","https://cdn.worldota.net/t/240x240/content/6f/16/6f1629d742875edfbd202912c055698699d783a6.jpeg","https://cdn.worldota.net/t/240x240/content/4d/88/4d88e28b0c9a2d56247ee3ab03d311eafeffdd1f.jpeg","https://cdn.worldota.net/t/240x240/content/84/bb/84bbc129191e7da58c98e54558baa2b9fdb86416.jpeg"};
    oteller diyarbakirOtel = new oteller("Diyarbakır Otel", "https://goo.gl/maps/Ln4nQKFuskkFdnmJA", "+905324177401","Diyarbakır şehrinde konaklama için harika bir seçenek olan Hotel Diyarbakir, havaalanına sadece 4,5 km uzaklıktadır. Ücretsiz avantajlara kablosuz İnternet, vale hizmeti olmayan otopark ve her gün 7.00 ve 10.30 arasında açık büfe kahvaltı dahildir.","569", R.drawable.diyarbakirotel, diyarbakirImg);

    String[] plazaOtelImg = {"https://images.odamax.com/img/300x300/odamax/image/upload/bed1656505db4da68b69f62c51b24e8d.jpg", "https://images.odamax.com/img/1024x768/odamax/image/upload/5f43846a0c044f13b9283c0a089b0716.jpg", "https://images.odamax.com/img/300x300/odamax/image/upload/45d2e840b5ccc88287b0de283e722a56.jpg", "https://images.odamax.com/img/1024x768/odamax/image/upload/cae74f5bbd34506117db68786978c5e5.jpg", "https://images.odamax.com/img/1024x768/odamax/image/upload/f0ec962a9aa916b1df10cf0d6cbe4760.jpg"};
    oteller plazaOtel = new oteller("Plaza Hotel", "https://goo.gl/maps/gYFD2tbfCfroUzne9", "+908503040808", "Ticaret bölgesinde yer alan bu rahat otel, Roma döneminden kalma Diyarbakır Kalesi'ne 14, Orta Çağ'dan kalma Ulu Cami'ye 15 dakikalık yürüme mesafesinde ve D950 kara yoluna 3 km uzaklıktadır.", "961", R.drawable.plaza, plazaOtelImg);

    String[] newGardenImg = {"https://www.newgardenhotel.com.tr/upload/img_103412530991403.jpg", "https://www.newgardenhotel.com.tr/upload/img_025019457648140.JPG", "https://www.newgardenhotel.com.tr/upload/img_021231290511576.JPG", "https://www.newgardenhotel.com.tr/upload/img_023758580449493.JPG", "https://www.newgardenhotel.com.tr/upload/img_0238321799180204.JPG", "https://www.newgardenhotel.com.tr/upload/img_0238231148751381.JPG", "https://www.newgardenhotel.com.tr/upload/img_023755181353303.jpg"};
    oteller newGarden = new oteller("New Garden Otel", "https://goo.gl/maps/SJg7TuafKSqJr8jL7", "+904122290404", "Ticaret bölgesinde yer alan bu rahat otel, Roma döneminden kalma Diyarbakır Kalesi'ne 14, Orta Çağ'dan kalma Ulu Cami'ye 15 dakikalık yürüme mesafesinde ve D950 kara yoluna 3 km uzaklıktadır.", "1.184", R.drawable.garden, newGardenImg);

    String[] prestigeImg = {"https://images.reseliva.com/hotels/bGFtYmwuMTYyNzQ=/room_40950_1_200.jpg", "https://diyarbakirprestigehotel.com/wp-content/uploads/2021/07/suit-yatak-1110x611.jpg", "https://diyarbakirprestigehotel.com/wp-content/uploads/2021/07/hamam1.jpg", "https://diyarbakirprestigehotel.com/wp-content/uploads/2021/07/fitness1.jpg", "https://diyarbakirprestigehotel.com/wp-content/uploads/2021/07/restoran1.jpg", "https://diyarbakirprestigehotel.com/wp-content/uploads/2021/07/restoran14.jpg"};
    oteller prestige = new oteller("Prestige Hotel", "https://goo.gl/maps/BLMwpvnMtAEUPQDF9", "4440329", "Ön cephesi camlı olan yüksek bir binada hizmet veren bu lüks otel Diyarbakır Tren Garı'na ve Diyarbakır Ulu Cami'ye 2 km, Diyarbakır Havalimanı'na ise 4 km uzaklıktadır.", "903", R.drawable.prestige, prestigeImg);

    String[] anemonImg = {"https://www.anemonhotels.com/images/otelfotogaleri/1d2a0489edit_a3f83.jpg", "https://www.anemonhotels.com/images/otelfotogaleri/1d2a1352edit_perde_50491.jpg", "https://www.anemonhotels.com/images/otelfotogaleri/1d2a1861edit_41a36.jpg", "https://www.anemonhotels.com/images/otelfotogaleri/1d2a1678edit_6d5e6.jpg", "https://www.anemonhotels.com/images/otelfotogaleri/1d2a2816edit_38609.jpg", "https://www.anemonhotels.com/images/otelfotogaleri/1d2a1469edit_5aa8e.jpg", "https://www.anemonhotels.com/images/otelfotogaleri/1d2a1467edit_35b3c.jpg", "https://www.anemonhotels.com/images/otelfotogaleri/1d2a2868edit_59b13.jpg"};
    oteller anemon = new oteller("Anemon Diyarbakır Otel", "https://goo.gl/maps/2TMEWmhG6CLmMh2C9", "+908503333333", "Genellikle konutların bulunduğu bir bölgede yer alan bu rahat otel D360 kara yolu üzerindedir. Diyarbakır Arkeoloji Müzesi'ne 12 km ve Hevsel Bahçeleri'ne 13 km uzaklıktadır.", "1.168", R.drawable.anemon, anemonImg);

    ListView listView;
    oteller[] konaklar = {diyarbakirOtel, plazaOtel, newGarden, prestige, anemon};
    String mBaslik[] = new String[konaklar.length];
    String mAciklama[] = new String[konaklar.length];
    int mresim[] = new int[konaklar.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_list);

        for(int i = 0; i < konaklar.length; i++){
            mBaslik[i] = konaklar[i].name;
            mAciklama[i] = konaklar[i].fiyat;
            mresim[i] = konaklar[i].picture;
        }

        listView = findViewById(R.id.listeView);
        benimAdapter adapter = new benimAdapter(this,mBaslik,mAciklama,mresim);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), otelinfo.class);
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
            benimAciklama.setText("₺"+rAciklama[position]);


            return satir;


        }
    }
}
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

public class GezilecekYerler extends AppCompatActivity {


    private ListView listeView;
    ArrayAdapter<String> adapter;
    yerler uluCami = new yerler("Ulu Cami", "https://goo.gl/maps/mjrmyg1VFCdPTajD7", R.drawable.ulu, "Bu tarihi yapılardan ilki kesinlikle Ulucami olacaktır. Anadolu’nun en eski camilerinden biri olan aynı zamanda İslam dünyasının en önemli yapıtlarından biri olan bu eminim sizleri de büyüleyecektir.");
    yerler onGozlu = new yerler("On Gözlü Köprü", "https://goo.gl/maps/dx2JQgXCRpbhJxoT6", R.drawable.ongozlu, "Birçok tarihi eseri sınırları içinde barındıran Diyarbakır için bir açık hava müzesi desek yanlış olmaz. Birçok medeniyete ev sahipliği yapmış, tarihi yapı ve mekana sahip Diyarbakır’ın en önemli simgelerinden biri olarak Dicle Köprüsü’nü sayabiliriz. Peki bu simge haline gelmiş köprü Diyarbakır’da tam olarak nerede yer alıyor?  Dicle Köprüsü (On Gözlü Köprü) Diyarbakır’ın Sur ilçesinde, adından da anlaşılacağı üzere Dicle Nehri üzerinde yer alıyor. Köprü, ülkemizin en önemli nehirlerinden olan Dicle’nin iki yakasını birleştiriyor. On ayrı açıklığa yani kemere sahip olduğu için On Gözlü Köprü olarak adlandırılıyor. Aynı zamanda Diyarbakır Silvan güzergahında yer aldığı için halk arasında Silvan Köprüsü olarak da anılıyor. Köprü Mardin’e ve şehir merkezine 3 km uzaklıkta konumlanıyor");
    yerler hasanPasa = new yerler("Tarihi Hasan Paşa Hanı", "https://goo.gl/maps/NY9E7CcsoCiz3NZD9", R.drawable.hasanpasa, "Çin Seddinden sonra dünyada en uzun ikinci yapı olarak bilinen ve Unesco Dünya Mirası listesinde bulunan Diyarbakır Surlarını; Meryan Ana Kilisesi’ni; mimarisiyle dikkat çeken Kervansaray’ını; şehrin fethi sırasında şehit olan sahabelerin de olduğu Hz. Süleyman Cami’sini; Dört Ayaklı Minare’yi ve şehrin en büyük hanı olan aynı zamanda yöresel kahvaltı edip hediyelik eşya bakabileceğiniz Tarihi Hasan Paşa Han’ını gezilecekler listenize eklemenizi öneririm.");
    yerler sulukluHan = new yerler("Sülüklü Han", "https://goo.gl/maps/vsM46m9AogZMWdeX8", R.drawable.suluklu, "Diyarbakır merkez ilçelerinden Sur’da bulunan Sülüklü Han 1683 tarihinde inşa edilmiş tarihi bir alışveriş merkezi. Diyarbakır Sülüklü Han inşa edilirken siyah bazalt taş kullanılmış ve mekanın tarihi ve otantik atmosferi bu taşlarla birlikte iyice oturmuş. Bu yapının Hanilioğlu Mahmut Çelebi ve kız kardeşi Atike Hatun tarafından yaptırıldığı söyleniyor.");
    yerler hevsel = new yerler("Hevsel Bahçeleri", "https://goo.gl/maps/gTt9fiHtdhyZccRr8", R.drawable.hevsel, "Adeta bu güzel şehirle özdeşleşmiş olan Dicle Nehri’ni, Mardin kapısından 3 kilometre uzaklıkta yer alan nehir üzerindeki Dicle köprüsü diğer adıyla On Gözlü Köprüsü’nü ve Diyarbakır surlarıyla Dicle Nehri arasında göz alabildiğine uzanan Hevsel Bahçeleri‘’ni de görmeden dönmemenizi tavsiye ediyorum.");

    String[] basliklar = {uluCami.getName(), onGozlu.getName(), hasanPasa.getName(), sulukluHan.getName(), hevsel.getName()};
    yerler[] bolgeler = {uluCami, onGozlu, hasanPasa, sulukluHan, hevsel};
    int mresim[] = {uluCami.getPicture(), onGozlu.getPicture(), hasanPasa.getPicture(), sulukluHan.getPicture(), hevsel.getPicture()};
    String mAciklama[] = {"","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gezilecek_yerler);
        listeView = (ListView) findViewById(R.id.listeView);
        benimAdapter adapter = new benimAdapter(this,basliklar,mAciklama,mresim);
        /*adapter = new ArrayAdapter<String>(GezilecekYerler.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, basliklar);*/
        listeView.setAdapter(adapter);

        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), infoScreen.class);
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
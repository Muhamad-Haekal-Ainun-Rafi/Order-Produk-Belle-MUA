package com.melenia.makeup.MenuUtama;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ActionMenuView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.melenia.makeup.Beli.BeliActivity;
import com.melenia.makeup.Login.LoginActivity;
import com.melenia.makeup.Profile.ProfileActivity;
import com.melenia.makeup.Profile.ProfileSetting;
import com.melenia.makeup.R;

public class MenuActivity extends AppCompatActivity {
    private TextView tv_Produk_Bedak, tv_Harga_Bedak, tv_Produk_Lipstik, tv_Harga_Lipstik, tv_Produk_Skincare, tv_Harga_Skincare,
                     tv_Produk_Maskerwajah, tv_Harga_Maskerwajah, tv_Produk_Pensil, tv_Harga_Pensil, tv_Produk_Sampo, tv_harga_Shampo;
    private Button Btn_Beli_Bedak, Btn_Beli_Lipstik, Btn_Beli_Skincare, Btn_Beli_Masker, Btn_Beli_Pensil, Btn_Beli_Sampo;
    private String data_brg_bedak,Uid, Date, data_hrg_bedak, data_brg_lipstik, data_hrg_lipstik;
    private ImageView Bedak, Skincare;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        Uid = getIntent().getStringExtra("Uid");


        tv_Produk_Bedak = findViewById(R.id.produk_bedak);
        tv_Harga_Bedak = findViewById(R.id.hrg_bedak);

        tv_Produk_Lipstik = findViewById(R.id.produk_lipstik);
        tv_Harga_Lipstik = findViewById(R.id.hrg_lipstik);

        tv_Produk_Skincare = findViewById(R.id.produk_skincare);
        tv_Harga_Skincare = findViewById(R.id.hrg_skincare);

        tv_Produk_Maskerwajah = findViewById(R.id.produk_ovale);
        tv_Harga_Maskerwajah = findViewById(R.id.hrg_ovale);

        tv_Produk_Pensil = findViewById(R.id.produk_pensil);
        tv_Harga_Pensil = findViewById(R.id.hrg_pensil);

        tv_Produk_Sampo = findViewById(R.id.produk_sampo);
        tv_harga_Shampo = findViewById(R.id.hrg_sampo);

        Btn_Beli_Bedak = findViewById(R.id.beli_bedak);
        Btn_Beli_Lipstik = findViewById(R.id.beli_lipstik);
        Btn_Beli_Skincare = findViewById(R.id.beli_skincare);
        Btn_Beli_Masker = findViewById(R.id.beli_ovale);
        Btn_Beli_Pensil = findViewById(R.id.beli_pensil);
        Btn_Beli_Sampo = findViewById(R.id.beli_sampo);
        Bedak = findViewById(R.id.img_bedak);



        DatabaseReference offline = FirebaseDatabase.getInstance().getReference().child("Users");
        offline.keepSynced(true);
        Btn_Beli_Bedak.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){

                /**
                 * Passing data menggunakan Bundle
                 */

                Bundle bundle = new Bundle();
                bundle.putString("produk", tv_Produk_Bedak.getText().toString());
                bundle.putString("harga", tv_Harga_Bedak.getText().toString());
                Intent intent = new Intent(MenuActivity.this, BeliActivity.class);
                Toast.makeText(MenuActivity.this, tv_Produk_Bedak.getText(), Toast.LENGTH_SHORT).show();
                intent.putExtras(bundle);


                startActivity(intent);
            }
        });

        Btn_Beli_Lipstik.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){

                /**
                 * Passing data menggunakan Bundle
                 */

                Bundle bundle = new Bundle();
                bundle.putString("produk", tv_Produk_Lipstik.getText().toString());
                bundle.putString("harga", tv_Harga_Lipstik.getText().toString());

                Intent intent = new Intent(MenuActivity.this, BeliActivity.class);
                Toast.makeText(MenuActivity.this, tv_Produk_Lipstik.getText(), Toast.LENGTH_SHORT).show();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Btn_Beli_Skincare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){

                /**
                 * Passing data menggunakan Bundle
                 */

                Bundle bundle = new Bundle();
                bundle.putString("produk", tv_Produk_Skincare.getText().toString());
                bundle.putString("harga", tv_Harga_Skincare.getText().toString());

                Intent intent = new Intent(MenuActivity.this, BeliActivity.class);
                Toast.makeText(MenuActivity.this, tv_Produk_Skincare.getText(), Toast.LENGTH_SHORT).show();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Btn_Beli_Masker.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){

                /**
                 * Passing data menggunakan Bundle
                 */

                Bundle bundle = new Bundle();
                bundle.putString("produk", tv_Produk_Maskerwajah.getText().toString());
                bundle.putString("harga", tv_Harga_Maskerwajah.getText().toString());

                Intent intent = new Intent(MenuActivity.this, BeliActivity.class);
                Toast.makeText(MenuActivity.this, tv_Produk_Maskerwajah.getText(), Toast.LENGTH_SHORT).show();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Btn_Beli_Pensil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){

                /**
                 * Passing data menggunakan Bundle
                 */

                Bundle bundle = new Bundle();
                bundle.putString("produk", tv_Produk_Pensil.getText().toString());
                bundle.putString("harga", tv_Harga_Pensil.getText().toString());

                Intent intent = new Intent(MenuActivity.this, BeliActivity.class);
                Toast.makeText(MenuActivity.this, tv_Produk_Pensil.getText(), Toast.LENGTH_SHORT).show();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Btn_Beli_Sampo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){

                /**
                 * Passing data menggunakan Bundle
                 */

                Bundle bundle = new Bundle();
                bundle.putString("produk", tv_Produk_Sampo.getText().toString());
                bundle.putString("harga", tv_harga_Shampo.getText().toString());

                Intent intent = new Intent(MenuActivity.this, BeliActivity.class);
                Toast.makeText(MenuActivity.this, tv_Produk_Sampo.getText(), Toast.LENGTH_SHORT).show();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId())
        {
            case R.id.action_profile:
                Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
                intent.putExtra("Uid", Uid);
                startActivity(intent);
                return true;

            case R.id.action_profile_setting:
                Intent intent2 = new Intent(MenuActivity.this, ProfileSetting.class);
                intent2.putExtra("Uid", Uid);
                startActivity(intent2);
                return true;

            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent3 = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent3);
                finish();

                return true;
            default:
                return super.onContextItemSelected(item);



        }

    }
}

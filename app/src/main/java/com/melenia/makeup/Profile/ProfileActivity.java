package com.melenia.makeup.Profile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.melenia.makeup.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private DatabaseReference database;
    private ProgressDialog loading;
    private TextView TV_NAMA, TV_ALAMAT,TV_TELPON;
    private ImageView FotoAkun;
    private String Uid;
    private Button btnSetting, btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        TV_NAMA = findViewById(R.id.akun_nama);
        TV_ALAMAT = findViewById(R.id.akun_alamat);
        TV_TELPON = findViewById(R.id.akun_telpon);

        FotoAkun = findViewById(R.id.akun_foto);

        database = FirebaseDatabase.getInstance().getReference();

        loading = ProgressDialog.show(ProfileActivity.this,
                "",
                "Please wait...",
                true,
                false);

        Uid = getIntent().getStringExtra("Uid");

        DatabaseReference offline = database.child("Users");
        offline.keepSynced(true);

        database.child("Users").child(Uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loading.dismiss();
                String Gnama = dataSnapshot.child("nama").getValue(String.class);
                String Galamat = dataSnapshot.child("alamat").getValue(String.class);
                String Gtelpon = dataSnapshot.child("no_telpon").getValue(String.class);
                final String Gfoto = dataSnapshot.child("foto").getValue(String.class);

                if (Gfoto.isEmpty()){
                    FotoAkun.setImageResource(R.drawable.ic_launcher_foreground);
                    TV_NAMA.setText(Gnama);
                    TV_ALAMAT.setText(Galamat);
                    TV_TELPON.setText(Gtelpon);
                }else {
                    Picasso.get().load(Gfoto).into(FotoAkun);
                    Picasso.get().load(Gfoto).networkPolicy(NetworkPolicy.OFFLINE).into(FotoAkun, new Callback() {
                        @Override
                        public void onSuccess() {}
                        @Override
                        public void onError(Exception e) {Picasso.get().load(Gfoto).into(FotoAkun); }
                    });
                    TV_NAMA.setText(Gnama);
                    TV_ALAMAT.setText(Galamat);
                    TV_TELPON.setText(Gtelpon);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }



    }


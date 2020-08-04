package com.melenia.makeup.Beli;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.melenia.makeup.MenuUtama.MenuActivity;
import com.melenia.makeup.R;
public class BeliActivity extends AppCompatActivity {
private TextView txt_Merek,txt_Harga,Rekening,Bank,Kurir;
private EditText et_Nama,et_Alamat,et_Telpon;
private String s2,s1,s3,Uid,Date;
private RadioButton mandiri,bri,tiki,jne;
private Button Btn_bayar,Btn_batal;
private String sId, sNama_pembeli, sNama_barang, sHarga_barang, sAlamat, sNo_telpon, sMetode_pembayaran,sKurir_pengiriman;
private DatabaseReference database;
private ProgressDialog loading;
Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli);

        database = FirebaseDatabase.getInstance().getReference().child("Pembelian");


        member = new Member();
        txt_Harga = findViewById(R.id.txt_harga);
        txt_Merek = findViewById(R.id.txt_merek);
        Rekening = findViewById(R.id.no_rek);
        Bank = findViewById(R.id.bank);
        Kurir = findViewById(R.id.kurir);

        et_Nama = findViewById(R.id.et_nama);
        et_Alamat = findViewById(R.id.et_alamat);
        et_Telpon = findViewById(R.id.et_telpon);

        mandiri = findViewById(R.id.rb_mandiri);
        bri = findViewById(R.id.rb_bri);

        tiki = findViewById(R.id.rb_tiki);
        jne = findViewById(R.id.rb_jne);

        Btn_bayar = findViewById(R.id.btn_bayar);

        txt_Merek.setText(sNama_barang);
        txt_Harga.setText(sHarga_barang);
        et_Nama.setText(sNama_pembeli);
        et_Alamat.setText(sAlamat);
        et_Telpon.setText(sNo_telpon);


        Bundle bundle = getIntent().getExtras();
        txt_Merek.setText(bundle.getString("produk"));
        txt_Harga.setText(bundle.getString("harga"));


        Btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mandiri.getText().toString();
                bri.getText().toString();
                if (mandiri.isChecked()){
                    s2 ="Bank Mandiri";
                }else{
                    s2 ="Bank BRI";
                }

                Bank.setText(s2);

                jne.getText().toString();
                tiki.getText().toString();
                if (jne.isChecked()){
                    s3 ="JNE";
                }else{
                    s3 ="TIKI";
                }

                Kurir.setText(s3);

                member.setNama_barang(txt_Merek.getText().toString().trim());
                member.setHarga_barang(txt_Harga.getText().toString().trim());
                member.setNama_pembeli(et_Nama.getText().toString().trim());
                member.setAlamat(et_Alamat.getText().toString().trim());
                member.setNo_telpon(et_Telpon.getText().toString().trim());
                member.setMetode_pembayaran(Bank.getText().toString().trim());
                member.setKurir_pengiriman(Kurir.getText().toString().trim());
                database.push().setValue(member);
                Toast.makeText(BeliActivity.this, "Barang akan segera dikirim", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BeliActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
    });

}
    public void bank(View view){
        if (mandiri.isChecked()){
            s1 ="587888888";
        }else{
            s1 ="234888888";
        }

        Rekening.setText(s1);

    }
}





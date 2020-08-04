package com.melenia.makeup.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.melenia.makeup.Model.Request;
import com.melenia.makeup.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEmail, mPassword,mTanggal,mAlamat,mNama,mTelpon;
    private Button mRegistration;
    private TextView tv_Login;
    private CheckBox checkBox;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    private ProgressDialog loading;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        database = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if ((user!=null)){
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        mNama = findViewById(R.id.txt_nama);
        mTanggal = findViewById(R.id.txt_lahir);
        mAlamat = findViewById(R.id.txt_alamat);
        mTelpon = findViewById(R.id.txt_telpon);
        mEmail = findViewById(R.id.txt_email);
        mPassword = findViewById(R.id.txt_password);
        tv_Login = findViewById(R.id.tv_login);
        mRegistration = findViewById(R.id.btnRegist);

        checkBox = findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else {
                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });

        mRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Snama = mNama.getText().toString();
                final String Stanggal_lahir = mTanggal.getText().toString();
                final String Salamat = mAlamat.getText().toString();
                final String Sno_telpon = mTelpon.getText().toString();

                final String Sfoto = "";

                final String Semail = mEmail.getText().toString();
                final String Spassword = mPassword.getText().toString();

                if (Snama.equals("")){
                    mNama.setError("Masukkan nama terlebih dahulu!");
                    mNama.requestFocus();
                }
                else if (Stanggal_lahir.equals("")){
                    mTanggal.setError("Masukkan email terlebih dahulu!");
                    mTanggal.requestFocus();
                }
                else if (Salamat.equals("")){
                    mAlamat.setError("Masukkan deskripsi terlebih dahulu!");
                    mAlamat.requestFocus();
                }
                else if (Sno_telpon.equals("")){
                    mTelpon.setError("Masukkan deskripsi terlebih dahulu!");
                    mTelpon.requestFocus();
                }
                else if (Semail.equals("")){
                    mEmail.setError("Masukkan email terlebih dahulu!");
                    mEmail.requestFocus();
                }

                else if (Spassword.equals("")){
                    mPassword.setError("Masukkan password terlebih dahulu!");
                    mPassword.requestFocus();
                }

                else {
                    loading = ProgressDialog.show(SignUpActivity.this,
                            "",
                            "Please wait...",
                            true,
                            false);

                    mAuth.createUserWithEmailAndPassword(Semail, Spassword).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()){
                                loading.dismiss();
                                Toast.makeText(SignUpActivity.this, "Sign Up error!", Toast.LENGTH_SHORT).show();
                            }else {
                                submitUser(new Request(
                                        Snama,
                                        Stanggal_lahir,
                                        Salamat,
                                        Sno_telpon,
                                        Semail,
                                        Sfoto
                                ));
                            }
                        }
                    });


                }
            }
        });


        tv_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

    private void submitUser(Request request) {
        String user_id = mAuth.getCurrentUser().getUid();
        database.child("Users")
                .child(user_id)
                .setValue(request)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        loading.dismiss();

                        mNama.setText("");
                        mTanggal.setText("");
                        mAlamat.setText("");
                        mTelpon.setText("");
                        mEmail.setText("");
                        mPassword.setText("");

                        Toast.makeText(SignUpActivity.this, "Daftar berhasil!", Toast.LENGTH_SHORT).show();
                        finish();
                        return;

                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }
}

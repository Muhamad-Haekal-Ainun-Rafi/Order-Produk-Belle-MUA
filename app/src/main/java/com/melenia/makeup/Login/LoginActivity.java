package com.melenia.makeup.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.melenia.makeup.MenuUtama.MenuActivity;
import com.melenia.makeup.R;
public class LoginActivity extends AppCompatActivity {
    private EditText mEmail, mPassword;
    private Button mLogin;
    private TextView tRegist,mReset;
    private ProgressDialog loading;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        mAuth = FirebaseAuth.getInstance();

        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if ((user!=null)){
                    String user_id = mAuth.getCurrentUser().getUid();
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    intent.putExtra("Uid",user_id);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };

        mEmail = findViewById(R.id.inputEmail);
        mPassword = findViewById(R.id.inputPassword);
        mLogin = findViewById(R.id.btnLogin);
        mReset = findViewById(R.id.forgotPassword);
        tRegist = findViewById(R.id.gotoRegister);

        tRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEmail.getText().toString().equals("")){
                    mEmail.setError("Masukkan nama terlebih dahulu!");
                    mEmail.requestFocus();
                }else if (mPassword.getText().toString().equals("")){
                    mPassword.setError("Masukkan password terlebih dahulu!");
                    mPassword.requestFocus();
                }else {
                    loading = ProgressDialog.show(LoginActivity.this,
                            "",
                            "Please wait...",
                            true,
                            false);

                    final String email = mEmail.getText().toString();
                    final String password = mPassword.getText().toString();
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                loading.dismiss();
                                Toast.makeText(LoginActivity.this, "Sign In error!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
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


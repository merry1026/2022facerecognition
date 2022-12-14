package com.example.facerecognitionlock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";
    EditText mNameText, mEmailText, mPwdText;
    Button mRegisterBtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // firebase access
        firebaseAuth = FirebaseAuth.getInstance();

        mNameText = findViewById(R.id.nameTextR);
        mEmailText = findViewById(R.id.emailTextR);
        mPwdText = findViewById(R.id.pwdTextR);
        mRegisterBtn = findViewById(R.id.registerBtnR);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmailText.getText().toString().trim();
                String pwd = mPwdText.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    FirebaseUser user = firebaseAuth.getCurrentUser();

                                    String nickname = mNameText.getText().toString().trim();
                                    String email = user.getEmail();
                                    String uid = user.getUid();

                                    //????????? ???????????? ?????????????????? ????????????????????? ??????
                                    HashMap<Object,String> hashMap = new HashMap<>();

                                    hashMap.put("uid",uid);
                                    hashMap.put("email",email);
                                    hashMap.put("nickname",nickname);

                                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                                    DatabaseReference ref = db.getReference("Users");
                                    ref.child(uid).setValue(hashMap);

                                    //????????? ?????????????????? ?????? ????????? ????????????.
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(RegisterActivity.this, "??????????????? ?????????????????????.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterActivity.this, "?????? ???????????? ????????? ?????????.", Toast.LENGTH_SHORT).show();
                                    return; //?????? ????????? ????????? ????????? ????????????.
                                }
                            }
                        });
            }
        });
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();; // ???????????? ????????? ????????????
        return super.onSupportNavigateUp(); // ???????????? ??????
    }
}

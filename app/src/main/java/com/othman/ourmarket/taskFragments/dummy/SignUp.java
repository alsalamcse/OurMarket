package com.othman.ourmarket.taskFragments.dummy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.othman.ourmarket.LoginActivity;
import com.othman.ourmarket.R;

public class SignUp extends AppCompatActivity {


    private EditText firstName,LastName,Email,Password;
    private Button save;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_SinUp);
        firstName=findViewById(R.id.firstName);
        LastName=findViewById(R.id.Lastname);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.password);
        save=findViewById(R.id.save);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();//return if user signed in if user didn't sign in  return null


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x=false;
                if (Email!=null&&Password!=null){
                  x=true;
                    Intent i=new Intent(SignUp.this, LoginActivity.class);

                }
                else{
                    x=false;
                    Toast.makeText(SignUp.this, "failed to sign up please enter the current email and password", Toast.LENGTH_SHORT).show();
                }
                if (x==true){
                    auth.createUserWithEmailAndPassword(Email.getText().toString(), Password.getText().toString()).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){//chek if response arrive to server
                                Toast.makeText(SignUp.this, "Auth notification Successful", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else {
                                Toast.makeText(SignUp.this, "Auth notificatio Failed "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                task.getException().printStackTrace();
                            }
                        }
                    });
                }


            }
        });

    }
//    private void creatAcount(String email, String password){
//        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//               if (task.isSuccessful()){//chek if response arrive to server
//                   Toast.makeText(SignUp.this, "Auth notification Successful", Toast.LENGTH_SHORT).show();
//                   finish();
//               }
//               else {
//                   Toast.makeText(SignUp.this, "Auth notificatio Failed "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                   task.getException().printStackTrace();
//               }
//            }
//        });
//    }

}

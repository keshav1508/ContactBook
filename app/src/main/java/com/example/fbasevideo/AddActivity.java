package com.example.fbasevideo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText FirstName,LastName,Email,Phoneno,turl;
    Button btnAdd,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().hide();
        FirstName=(EditText)findViewById(R.id.txtFirstName);
        LastName=(EditText)findViewById(R.id.txtLastName);
        Email=(EditText)findViewById(R.id.txtEmail);
        Phoneno=(EditText)findViewById(R.id.txtPhoneNo);
        turl=(EditText)findViewById(R.id.txtImageUrl);

        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnBack=(Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    insertData();
                    finish();
                    clearAll();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private  void insertData()
    {
        Map<String,Object> map=new HashMap<>();
        map.put("FirstName",FirstName.getText().toString());
        map.put("LastName",LastName.getText().toString());
        map.put("Email",Email.getText().toString());
        map.put("Phoneno",Phoneno.getText().toString());
        map.put("turl",turl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("LOC").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "CONTACT ADDED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "Error While Inserting Contact", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void clearAll()
    {
        FirstName.setText("");
        LastName.setText("");
        Email.setText("");
        Phoneno.setText("");
        turl.setText("");
    }
}
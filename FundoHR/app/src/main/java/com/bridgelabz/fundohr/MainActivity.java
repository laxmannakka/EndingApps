package com.bridgelabz.fundohr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button mSignin;
    EditText mEmail;
    String mUserEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSignin = (Button) findViewById(R.id.signin);
        mEmail = (EditText) findViewById(R.id.gmail);
        mUserEmail = mEmail.getText().toString();
        mSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EmployeeDetailsActivity.class);

             //   Intent intent = new Intent(MainActivity.this,TimePIckerFragment.class);
                startActivity(intent);

            }
        });
    }
}

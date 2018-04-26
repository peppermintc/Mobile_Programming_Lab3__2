package org.androidtown.lab3__2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    //DECLARE
    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //INFLATE
        setContentView(R.layout.activity_new);

        //CONNECT XML
        textView1 = findViewById(R.id.txt5);
        textView2 = findViewById(R.id.txt7);
        textView3 = findViewById(R.id.txt9);
        btn = findViewById(R.id.btn);

        //INTENT & BUNDLE RECEIVE
        Intent intent = getIntent();
        Bundle myBundle = intent.getExtras();
        textView1.setText(": " + myBundle.getString("name"));
        textView2.setText(": " + myBundle.getString("gender"));
        textView3.setText(": " + myBundle.getString("reception"));

        //BUTTON ONCLICK
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //INTENT
                Intent intent = new Intent(NewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

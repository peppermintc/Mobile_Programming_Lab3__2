package org.androidtown.lab3__2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    //DECLARE
    Button btn;
    EditText name;
    RadioGroup radioGroup;
    RadioButton male;
    RadioButton female;
    CheckBox sms;
    CheckBox email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //INFLATE
        setContentView(R.layout.activity_main);

        //CONNECT
        btn = findViewById(R.id.btnRegister);
        name = findViewById(R.id.editTxt1);
        radioGroup = findViewById(R.id.radioGroup1);
        male = findViewById(R.id.radioBtn1);
        female = findViewById(R.id.radioBtn2);
        sms = findViewById(R.id.sms);
        email = findViewById(R.id.email);

        //BUTTON ONCLICK
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                //INTENT & BUNDLE
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                Bundle myBundle = new Bundle();

                //NAME
                String a = name.getText().toString();
                myBundle.putString("name",a);

                //GENDER
                int radId = radioGroup.getCheckedRadioButtonId();
                if(male.getId()==radId)
                    myBundle.putString("gender","남");
                if(female.getId()==radId)
                    myBundle.putString("gender","여");

                //RECEPTION
                if(sms.isChecked() && email.isChecked())
                    myBundle.putString("reception", "SMS, e-mail");
                else if(sms.isChecked())
                    myBundle.putString("reception", "SMS");
                else if(email.isChecked())
                    myBundle.putString("reception", "e-mail");

                //INTENT
                intent.putExtras(myBundle);
                startActivity(intent);
            }
        });
    }
}

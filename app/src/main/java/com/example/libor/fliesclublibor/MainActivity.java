package com.example.libor.fliesclublibor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner gender = (Spinner)findViewById(R.id.spinner_gender);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String sex = gender.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, sex + " is selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onButtonClickListener (View v) {
        ImageButton signup = (ImageButton) findViewById(R.id.imageButton_submit);
        EditText surname, firstname, mi, birth, address, email, password, confirm;
        String sn, fn, mid ,bd, add, mail, pass, conf, sub, match, warn, emailPattern;

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        signup.startAnimation(myAnim);

        sn = fn = bd = add = mail = pass = conf = sub = match = mid = warn = "";
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        surname = (EditText)findViewById(R.id.editText_surname);
        firstname = (EditText)findViewById(R.id.editText_firstname);
        mi = (EditText)findViewById(R.id.editText_middleinitial);
        birth = (EditText)findViewById(R.id.editText_birthday);
        address = (EditText)findViewById(R.id.editText_address);
        email = (EditText)findViewById(R.id.editText_email);
        password = (EditText)findViewById(R.id.editText_password);
        confirm = (EditText)findViewById(R.id.editText_retypepass);

        if (surname.getText().toString().equals("")) {
               sn = "○ Surname \n";
            warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        if (firstname.getText().toString().equals("")) {
               fn = "\n○ First Name \n";
            warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        if (mi.getText().toString().equals("")) {
              mid = "\n○ Middle Initial \n";
            warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        if (birth.getText().toString().equals("")) {
               bd = "\n○ Date of Birth \n";
            warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        if (address.getText().toString().equals("")) {
              add = "\n○ Postal Address \n";
            warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        if (email.getText().toString().equals("") || !email.getText().toString().trim().matches(emailPattern)) {
             mail = "\n○ E-Mail \n";
            warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        if (confirm.getText().toString().equals("")) {
             conf = "\n○ Re-Type Password \n";
            warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        if (password.getText().toString().equals("")) {
             pass = "\n○ Password \n";
             warn = "\n\n   !!! R E Q U I R E D !!!";
        }
        else if (password.getText().toString().equals(confirm.getText().toString()) &&
        !surname.getText().toString().equals("") && !firstname.getText().toString().equals("")
                && !mi.getText().toString().equals("") && !birth.getText().toString().equals("")
                && !address.getText().toString().equals("") && email.getText().toString().trim().matches(emailPattern)) {
              sub = "    Signing up... ";
        }
        else if (!password.getText().toString().equals(confirm.getText().toString())) {
            match = "\nPassword is not match \n";
        }
        Toast.makeText(MainActivity.this, sn + fn + mid + bd + add + mail + pass + conf + sub + match + warn, Toast.LENGTH_LONG).show();

    }

}

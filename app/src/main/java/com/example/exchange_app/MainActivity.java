package com.example.exchange_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    Button exchange_button;

    EditText ammount_Edittext,first_edit_text,second_edit_text;
    Spinner spinner_currency;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    exchange_button=findViewById(R.id.exchangebtn);

    ammount_Edittext=findViewById(R.id.ammounttext);
    spinner_currency=findViewById(R.id.spinner);
    first_edit_text=findViewById(R.id.firstedittext);
    second_edit_text=findViewById(R.id.secondedittext);

    String[] from={"USD","EURO","MAD"};
    ArrayAdapter adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
    spinner_currency.setAdapter(adapter);



    exchange_button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            double tot1;
            double tot2;
            double somme=Double.parseDouble(ammount_Edittext.getText().toString());
            if(spinner_currency.getSelectedItem().toString()=="USD"){
                tot1=somme * 10.46;
                tot2=somme * 0.95;

                first_edit_text.setText(new DecimalFormat("##.##").format(tot1)+" MAD");
                second_edit_text.setText(new DecimalFormat("##.##").format(tot2)+" EURO");
            }else if(spinner_currency.getSelectedItem().toString()=="MAD"){
                tot1=somme * 0.096;
                tot2=somme * 0.091;

                first_edit_text.setText(new DecimalFormat("##.##").format(tot1)+" USD");
                second_edit_text.setText(new DecimalFormat("##.##").format(tot2)+" EURO");
            }else{
                tot1=somme * 1.05;
                tot2=somme * 11.02;

                first_edit_text.setText(new DecimalFormat("##.##").format(tot1)+" USD");
                second_edit_text.setText(new DecimalFormat("##.##").format(tot2)+" MAD");
            }

        }
    });

    }
}
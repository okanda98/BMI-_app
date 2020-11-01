package com.example.bmiapp;
//Import necessary package and file


import com.example.bmiapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//Main activity class start here
public class MainActivity extends Activity {

    //Define layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText e1 = (EditText) findViewById(R.id.add2);
        final EditText e2 = (EditText) findViewById(R.id.add1);
       final TextView e3 = (TextView) findViewById(R.id.val);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }


                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2)/100;


                float bmiValue = calculateBMI(weight, height);


                String bmiInterpretation = interpretBMI(bmiValue);

                e3.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

            }
        });

    }

    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
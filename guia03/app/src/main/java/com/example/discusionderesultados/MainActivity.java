package com.example.discusionderesultados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int n=0;
    int numero=0;
    private TextView txtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtn=(TextView)findViewById(R.id.txtnum);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("num", n);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        n = savedInstanceState.getInt("num");
        txtn.setText(String.valueOf(n));
    }
    public void contador(View v){
        txtn=(TextView)findViewById(R.id.txtnum);

            if(n==9){
                n=0;
                txtn.setText(Integer.toString(n));
            }
            else{
                n++;
                txtn.setText(Integer.toString(n));


            }

    }
}
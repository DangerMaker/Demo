package com.compass.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.compass.common.A;
import com.compass.market.C;
import com.compass.trade.B;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A.print();
        B.print();
        C.print();
    }
}

package com.example.myform;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myform.form.MyFunction;
import com.example.myform.info.DeviceInfo;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bt=(Button) findViewById(R.id.button);
        bt.setOnClickListener(v -> {
            Intent i=new Intent(this, SecondActivity.class);
            startActivity(i);
        });

        //new DeviceInfo().MemoryInfoGet(getApplicationContext());
        //new DeviceInfo().StorageInfoGet(getApplicationContext());
        //new DeviceInfo().AppListGet(getApplicationContext());
    }
}
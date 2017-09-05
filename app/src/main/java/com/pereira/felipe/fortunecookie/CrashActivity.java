package com.pereira.felipe.fortunecookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CrashActivity extends AppCompatActivity {
    private TextView report;
    private Button btnclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);

        Intent intent  = getIntent();
        report = (TextView) findViewById(R.id.report);
        report.setText(intent.getStringExtra("stackTrace"));
        btnclose = (Button) findViewById(R.id.btnclose);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }
}

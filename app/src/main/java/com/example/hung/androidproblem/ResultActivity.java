package com.example.hung.androidproblem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        System.out.println(intent.hasExtra("a"));

        double a = intent.getDoubleExtra("a", 1);
        double b = intent.getDoubleExtra("b", 1);
        String result;
        if (a == 0 && b != 0) {
            result = "Vô nghiệm";
        } else if (a==0 && b==0) {
            result = "Vô số nghiệm";
        } else {
            result = "" + (-b/a);
        }

        TextView rs = findViewById(R.id.result);
        rs.setText(result);
    }


    public void back(View view) {
        finish();
    }
}

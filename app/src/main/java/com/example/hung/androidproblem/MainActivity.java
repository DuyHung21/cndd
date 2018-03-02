package com.example.hung.androidproblem;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    String string_a, string_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_ptbn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (string_b != null) {
            String text = "Welcome to MainActivity! Your last edit text: a= " + string_a + ", b=" + string_b;
            Toast ts = Toast.makeText(this, text, Toast.LENGTH_LONG);
            ts.show();

            EditText input = findViewById(R.id.a);
            input.setText("0");
            input = findViewById(R.id.b);
            input.setText("0");
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

    }



//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        EditText input = findViewById(R.id.a);
//        outState.putString("a", input.getText().toString());
//        input = findViewById(R.id.b);
//        outState.putString("b", input.getText().toString());
//    }

    public void giaiPT(View view) {
        EditText input = findViewById(R.id.a);
        string_a = input.getText().toString();

        input = findViewById(R.id.b);
        string_b = input.getText().toString();


        try {
            double a = Double.parseDouble(string_a);
            double b = Double.parseDouble(string_b);
            System.out.println(a);

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("a",a);
            intent.putExtra("b",b);

            System.out.println(intent.hasExtra("a"));
            startActivity(intent);
        } catch (NumberFormatException err) {
            Toast ts = Toast.makeText(this, "a và b phải là số!", Toast.LENGTH_SHORT);
            ts.show();
        }

    }
}

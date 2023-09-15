package ru.mirea.klimova.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShareActivity.class);
                startActivity(intent);
            }
        });

        Intent intent2 = getIntent();
        String cond = intent2.getStringExtra("condition");
        if(cond == null){
            cond = "2";
        }
        if(Integer.parseInt(cond) == 1){
            textView.setText("Название Вашей любимой книги: " + intent2.getStringExtra(
                    "message"));
        }
        else{
            textView.setText("Тут появится название вашей любимой книги!");
        }
    }
}
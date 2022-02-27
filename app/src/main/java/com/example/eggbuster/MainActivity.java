package com.example.eggbuster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView timerdisplay;
    EditText input ;
    CountDownTimer timer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        timerdisplay = findViewById(R.id.textView);
        input = findViewById(R.id.edit_text);
        ImageView img;
        img = findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int time = Integer.parseInt(input.getText().toString() );
                img.setImageDrawable(getDrawable(R.drawable.egg));


                timer = new CountDownTimer(time*1000,1000) {
                    @Override
                    public void onTick(long millsUntilFinished) {

                        int timeinsec = (int)millsUntilFinished /1000;
                        int min =timeinsec /60 ;
                        int sec = timeinsec % 60;

                        String display = min + " : " + sec ;
                        timerdisplay.setText(display);
                    }

                    @Override
                    public void onFinish() {
                    img.setImageDrawable(getDrawable(R.drawable.yolk));
                    }
                };
                timer.start();

            }
    });
}
}

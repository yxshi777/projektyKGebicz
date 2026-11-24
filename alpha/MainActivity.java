package com.example.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //1
        TextView pudelko = findViewById(R.id.pudelko);
        TextView procentyText = findViewById(R.id.procentyText);
        SeekBar seekAlpha = findViewById(R.id.seekAlpha);

        //2


        //1
        seekAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                int alpha = 100 - progress;
                pudelko.setAlpha(alpha / 100f);
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar){ }
            @Override public void onStopTrackingTouch(SeekBar seekBar){ }
        });

        //2

    }


}

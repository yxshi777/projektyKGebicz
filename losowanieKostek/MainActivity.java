package com.example.losowaniekosciprojekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText poleIloscKostek;
    private GridLayout poleKostek;
    private TextView wynikText;
    private List<Integer> wyniki = new ArrayList<>();

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

        poleIloscKostek = findViewById(R.id.poleIloscKostek);
        poleKostek = findViewById(R.id.poleKostek);
        wynikText = findViewById(R.id.wynikText);

        Button przyciskLosuj = findViewById(R.id.przyciskLosuj);
        Button przyciskRosnaco = findViewById(R.id.przyciskRosnaco);
        Button przyciskMalejaco = findViewById(R.id.przyciskMalejaco);

        przyciskLosuj.setOnClickListener(v -> losuj());
        przyciskRosnaco.setOnClickListener(v -> posortujRosnaco());
        przyciskMalejaco.setOnClickListener(v -> posortujMalejaco());
    }

    private void losuj(){
        String tekst = poleIloscKostek.getText().toString();
        int iloscKostekInt = Integer.parseInt(tekst);

        if(tekst.isEmpty()){
            Toast.makeText(this, "Podaj ilość kostek: ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(iloscKostekInt<=0){
            Toast.makeText(this, "Musisz mieć conajmniej jedną kostke!", Toast.LENGTH_SHORT).show();
            return;
        }
        wyniki.clear();
        Random random = new Random();
        for(int i = 0; i < iloscKostekInt; i++){
            wyniki.add(random.nextInt(6) + 1);
        }
        wynikiLosowania();
    }

    private void posortujRosnaco(){
        if(wyniki.isEmpty()){
            Toast.makeText(this, "Wylosuj kostki", Toast.LENGTH_SHORT).show();
            return;
        }else{
            wyniki.sort(null);
            wynikiLosowania();
        }
    }

    private void posortujMalejaco(){
        if(wyniki.isEmpty()){
            Toast.makeText(this, "Wylosuj kostki", Toast.LENGTH_SHORT).show();
            return;
        }else{
            wyniki.sort((a, b) -> b - a);
            wynikiLosowania();
        }
    }

    private void wynikiLosowania() {
        poleKostek.removeAllViews();
        String tekstWynikow = "";
        for(int i=0; i<wyniki.size(); i++){
            tekstWynikow += wyniki.get(i);
            if(i<wyniki.size()-1){
                tekstWynikow += ", ";
            }
        }
        wynikText.setText(tekstWynikow);
    }
}

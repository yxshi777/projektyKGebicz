package com.example.losowaniekosciprojekt;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> wyniki = new ArrayList<Integer>();
    TextView wynikText = findViewById(R.id.wynikText);

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
        Button przyciskLosuj = findViewById(R.id.przyciskLosuj);
        przyciskLosuj.setOnClickListener(v -> losuj());
        Button przyciskRosnaco = findViewById(R.id.przyciskRosnaco);
        przyciskRosnaco.setOnClickListener(v -> sortujRosnaco());
        Button przyciskMalejaco = findViewById(R.id.przyciskMalejaco);
        przyciskMalejaco.setOnClickListener(v -> sortujMalejaco());
    }
    
    public void losuj(){
        EditText poleIloscKostek = findViewById(R.id.poleIloscKostek);
        String iloscKostekStr = poleIloscKostek.getText().toString();
        int iloscKostekInt = parseInt(iloscKostekStr);
        
        if(iloscKostekStr.isEmpty()){
            Toast.makeText(this, "Podaj ilość kostek: ", Toast.LENGTH_SHORT).show();
            return;
        }
        if(iloscKostekInt<=0){
            Toast.makeText(this, "Musisz mieć conajmniej jedną kostke!", Toast.LENGTH_SHORT).show();
            return;
        }

        Random random = new Random();
        
        for(int i = 0; i < iloscKostekInt; i++){
            wyniki.add(random.nextInt(6) + 1);
        }
        wyswietlWyniki();
    }

    public void sortujRosnaco(){
        if(wyniki.isEmpty()){
            Toast.makeText(this, "Musisz miec wylosowane kostki", Toast.LENGTH_SHORT).show();
            return;
        }else{
            wyniki.sort(null);
            wyswietlWyniki();
        }
    }

    public void sortujMalejaco(){
        if(wyniki.isEmpty()){
            Toast.makeText(this, "Musisz miec wylosowane kostki", Toast.LENGTH_SHORT).show();
            return;
        }else{
            wyniki.sort((a, b) -> b - a); //czy to bedzie dzialac?
            wyswietlWyniki();
        }
    }

    public void wyswietlWyniki(){
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

package com.alberto.gesresfamilyapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alberto.gesresfamilyapp.R;

public class MainActivityView extends AppCompatActivity {

    Button btCentros;
    Button btProfesionales;
    Button btResidentes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCentros = findViewById(R.id.elevatedButtonCentros);
        btProfesionales = findViewById(R.id.elevatedButtonProfesionales);
        btResidentes = findViewById(R.id.elevatedButtonResidentes);

        btCentros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivityView.this, CentrosListView.class));
            }
        });

        btProfesionales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivityView.this, ProfesionalesActivity.class));
            }
        });

        btResidentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivityView.this, ResidentesActivity.class));
            }
        });




    }
}
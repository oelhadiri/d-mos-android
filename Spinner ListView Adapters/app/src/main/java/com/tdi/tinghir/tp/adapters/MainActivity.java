package com.tdi.tinghir.tp.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tdi.tinghir.tp.adapters.objects.Datas;
import com.tdi.tinghir.tp.adapters.objects.Personne;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Demo_Adapters";

    Spinner spPersonnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Datas datas = new Datas();
        Log.i(TAG, "onCreate: " + datas.size());

        spPersonnes = findViewById(R.id.spPersonnes);
        ArrayAdapter<Personne> adapter = new ArrayAdapter<>(
            MainActivity.this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            datas
        );
        spPersonnes.setAdapter(adapter);
        Log.i(TAG, "onCreate: Avec Succès");

    }
}

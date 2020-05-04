package com.tdi.tinghir.tp.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.tdi.tinghir.tp.adapters.objects.Datas;

import java.util.ArrayList;
import java.util.HashMap;

public class Main3Activity extends AppCompatActivity {

    ListView lvPersonnes2;

    private static final String TAG = "Demo_Adapters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Datas datas = new Datas();
        ArrayList<HashMap<String, String>> hashMaps = datas.parseToListOfHashMaps();
        Log.i(TAG, "onCreate: " + hashMaps.size());

        lvPersonnes2 = findViewById(R.id.lvPersonnes2);
        SimpleAdapter adapter = new SimpleAdapter(
                Main3Activity.this,
                hashMaps,
                R.layout.lv_element_personne,
                new String[] { "nom", "prenom", "actif" },
                new int[] { R.id.tvNom, R.id.tvPrenom, R.id.cbActif }
        );
        lvPersonnes2.setAdapter(adapter);
    }
}

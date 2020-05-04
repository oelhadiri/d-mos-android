package com.tdi.tinghir.tp.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.tdi.tinghir.tp.adapters.objects.Datas;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    ListView lvPersonnes;

    private static final String TAG = "Demo_Adapters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Datas datas = new Datas();
        ArrayList<HashMap<String, String>> hashMaps = datas.parseToListOfHashMaps();
        Log.i(TAG, "onCreate: " + hashMaps.size());

        lvPersonnes = findViewById(R.id.lvPersonnes);
        SimpleAdapter adapter = new SimpleAdapter(
          Main2Activity.this,
                hashMaps,
                android.R.layout.simple_list_item_2,
                new String[] { "nom", "prenom" },
                new int[] { android.R.id.text1, android.R.id.text2 }
        );
        lvPersonnes.setAdapter(adapter);

    }
}

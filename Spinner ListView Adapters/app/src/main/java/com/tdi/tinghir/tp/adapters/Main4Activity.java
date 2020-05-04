package com.tdi.tinghir.tp.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.tdi.tinghir.tp.adapters.customs.LvAdapter;
import com.tdi.tinghir.tp.adapters.objects.Datas;

import java.util.ArrayList;
import java.util.HashMap;

public class Main4Activity extends AppCompatActivity {

    ListView lvPersonnes3;

    private static final String TAG = "Demo_Adapters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Datas datas = new Datas();
        Log.i(TAG, "onCreate: " + datas.size());

        lvPersonnes3 = findViewById(R.id.lvPersonnes3);
        LvAdapter adapter = new LvAdapter(Main4Activity.this, datas);
        lvPersonnes3.setAdapter(adapter);
    }
}

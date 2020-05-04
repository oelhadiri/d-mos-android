package com.tdi.tinghir.async.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tdi.tinghir.async.rest.tasks.Long2AsyncTask;

public class MainActivity extends AppCompatActivity {

    Button btnLong, btnCourt;
    TextView tvLong, tvCourt, tvTest;

    int compteurCourt = 0, compteurLong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLong = findViewById(R.id.btnLong);
        btnCourt = findViewById(R.id.btnCourt);
        tvLong = findViewById(R.id.tvLong);
        tvCourt = findViewById(R.id.tvCourt);
        tvTest = findViewById(R.id.tvTest);


        btnCourt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCourt.setText("Clic n°" + (++compteurCourt));
            }
        });

        btnLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                (new Long2AsyncTask(MainActivity.this)).execute(3, 0, 0, -5);
            }
        });
    }

    public class LongAsyncTask extends AsyncTask<Integer, Boolean, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvLong.setText("En cours...");
        }


        @Override
        protected String doInBackground(Integer... integers) {
            try {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvTest.setText("Arrière-Plan");
                    }
                });

                if(integers.length > 0 && integers[0] != 0)
                    Thread.sleep(integers[0] * 1000 > 0 ? integers[0] * 1000 : -(integers[0] * 1000));
                else
                    Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "Non Terminé";
            }
            return "Terminé";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvLong.setText(s);
        }
    }

}

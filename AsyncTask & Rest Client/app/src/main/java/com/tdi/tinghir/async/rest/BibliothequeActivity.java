package com.tdi.tinghir.async.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tdi.tinghir.async.rest.objects.Bibliotheque;
import com.tdi.tinghir.async.rest.tasks.BiblioAsyncTask;

public class BibliothequeActivity extends AppCompatActivity {

    private static final String API_URL = "http://192.168.42.54:8080/DemoAjax/api.php";
    Bibliotheque bibliotheque = new Bibliotheque();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliotheque);

        (new BiblioAsyncTask(this, bibliotheque)).execute(API_URL, "action", "read");
    }
}

package com.tdi.tinghir.tp.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tdi.tinghir.tp.sqlite.db.MonGestionnaireBD;
import com.tdi.tinghir.tp.sqlite.objects.Personne;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MonGestionnaireBD bd = new MonGestionnaireBD(this);

        //bd.viderLaTablePersonne();
        bd.viderLaTableAdresse();

        /*
        Personne personne = new Personne("Khalid", "Amine", "1990-05-22", true);
        bd.insererPersonne(personne);

        personne = new Personne("Youssef", "Anass", "1996-11-18", true);
        bd.insererPersonne(personne);

        personne = new Personne("Ahmed", "Karim", "2000-02-03", false);
        bd.insererPersonne(personne);


        Personne p = new Personne(2, "Aymen", "Salim", "2000-02-22", true);
        bd.modifierPersonne(p);

        bd.supprimerPersonne(4);
        bd.supprimerPersonne(5);
        bd.supprimerPersonne(6);

         */
        bd.close();
    }
}

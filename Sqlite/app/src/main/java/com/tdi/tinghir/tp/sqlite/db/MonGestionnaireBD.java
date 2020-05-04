package com.tdi.tinghir.tp.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.tdi.tinghir.tp.sqlite.R;
import com.tdi.tinghir.tp.sqlite.objects.Personne;

public class MonGestionnaireBD extends SQLiteOpenHelper {

    private static final String NOM_BD = "PersonnesDb.db";
    private static final int VERSION_BD = 2;

    private static final String TAG = "DB_PERSONNES";

    Context context = null;

    public MonGestionnaireBD(Context context) {
        super(context, NOM_BD, null, VERSION_BD);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createPersonne = context.getString(R.string.create_table_personne);
        db.execSQL(createPersonne);
        Log.i(TAG, "classe MonGestionnaireBD Méthode onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String createAdresse = context.getString(R.string.create_table_adresse);
        db.execSQL(createAdresse);
        Log.i(TAG, "classe MonGestionnaireBD Méthode onUpgrade");
    }

    public void viderLaTablePersonne() {
        String deletePersonnes = context.getString(R.string.delete_toutes_personnes);
        this.getWritableDatabase().execSQL(deletePersonnes);
        Log.i(TAG, "classe MonGestionnaireBD Méthode viderLaTablePeresonne");
    }

    public void viderLaTableAdresse() {
        String deletePersonnes = context.getString(R.string.delete_toutes_adresses);
        this.getWritableDatabase().execSQL(deletePersonnes);
        Log.i(TAG, "classe MonGestionnaireBD Méthode viderLaTableAdresse");
    }

    public boolean insererPersonne(Personne personne) {
        try {
            String insertPersonne = context.getString(R.string.insert_une_personne);
            this.getWritableDatabase().execSQL(insertPersonne, new Object[] { personne.getNom(), personne.getPrenom(), personne.getDateNaissance(), personne.isEstActif() });
            Log.i(TAG, "classe MonGestionnaireBD Méthode InsererPersonne OK");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i(TAG, "classe MonGestionnaireBD Méthode InsererPersonne NOK");
        }
        return false;
    }

    public boolean modifierPersonne(Personne personne) {
        try {
            String modifierPersonne = context.getString(R.string.update_une_personne);
            this.getWritableDatabase().execSQL(modifierPersonne, new Object[] { personne.getNom(), personne.getPrenom(), personne.getDateNaissance(), personne.isEstActif(), personne.getId() });
            Log.i(TAG, "classe MonGestionnaireBD Méthode modifierPersonne OK");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i(TAG, "classe MonGestionnaireBD Méthode modifierPersonne NOK");
        }
        return false;
    }

    public boolean supprimerPersonne(int id) {
        try {
            String supprimerPersonne = context.getString(R.string.delete_une_personne);
            this.getWritableDatabase().execSQL(supprimerPersonne, new Object[] { id });
            Log.i(TAG, "classe MonGestionnaireBD Méthode supprimerPersonne OK");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i(TAG, "classe MonGestionnaireBD Méthode supprimerPersonne NOK");
        }
        return false;
    }
}

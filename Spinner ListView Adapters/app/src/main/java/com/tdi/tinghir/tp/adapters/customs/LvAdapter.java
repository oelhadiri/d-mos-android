package com.tdi.tinghir.tp.adapters.customs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tdi.tinghir.tp.adapters.R;
import com.tdi.tinghir.tp.adapters.objects.Personne;

import java.util.ArrayList;

public class LvAdapter extends BaseAdapter {

    private ArrayList<Personne> personnes;
    private Activity activity;

    public LvAdapter(Activity activity, ArrayList<Personne> personnes) {
        super();
        this.activity = activity;
        this.personnes = personnes;
    }

    @Override
    public int getCount() {
        return personnes.size();
    }

    @Override
    public Object getItem(int position) {
        return personnes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Personne)getItem(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Personne personne = (Personne)getItem(position);

        if(convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.lv_element_personne, null);
        }

        TextView tvNom = convertView.findViewById(R.id.tvNom);
        TextView tvPrenom = convertView.findViewById(R.id.tvPrenom);
        CheckBox cbActif = convertView.findViewById(R.id.cbActif);

        tvNom.setText(personne.getNom());
        tvPrenom.setText(personne.getPrenom());
        cbActif.setChecked(personne.isActif());

        return convertView;
    }
}

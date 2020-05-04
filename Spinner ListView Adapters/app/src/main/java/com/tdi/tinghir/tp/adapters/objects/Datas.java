package com.tdi.tinghir.tp.adapters.objects;

import java.util.ArrayList;
import java.util.HashMap;

public class Datas extends ArrayList<Personne> {

    public Datas() {
        this.add(new Personne(1, "Youssef", "Mohamed", true));
        this.add(new Personne(2, "Amine", "Younes", false));
        this.add(new Personne(3, "Karim", "Marouane", true));
        this.add(new Personne(4, "Hicham", "Yassine", true));
        this.add(new Personne(5, "Ahmed", "Khalid", true));
        this.add(new Personne(6, "Kamal", "Mouad", false));
    }

    public ArrayList<HashMap<String, String>> parseToListOfHashMaps() {
        ArrayList<HashMap<String, String>> liste = new ArrayList<>();
        for(Personne personne: this) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", personne.getId()+"");
            hashMap.put("nom", personne.getNom());
            hashMap.put("prenom", personne.getPrenom());
            hashMap.put("actif", personne.isActif()+"");
            liste.add(hashMap);
        }
        return liste;
    }



}

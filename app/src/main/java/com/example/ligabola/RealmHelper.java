package com.example.ligabola;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final ModelLigaRealm timModel) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null) {
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(ModelLigaRealm.class).max("idTeam");
                    int nextId;
                    if (currentIdNum==null) {
                        nextId = 1;
                    } else {
                        nextId = currentIdNum.intValue()+1;
                    }
                    timModel.setidTeam(nextId);
                    ModelLigaRealm modelRealm = realm.copyToRealm(timModel);
                } else {
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<ModelLigaRealm> getAllTim() {
        RealmResults<ModelLigaRealm> results = realm.where(ModelLigaRealm.class).findAll();
        return results;
    }

    public void delete (Integer idTeam){
        final RealmResults<ModelLigaRealm> model = realm.where(ModelLigaRealm.class).equalTo("idTeam", idTeam).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }

}
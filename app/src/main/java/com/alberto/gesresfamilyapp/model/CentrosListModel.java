package com.alberto.gesresfamilyapp.model;

import static com.alberto.gesresfamilyapp.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.alberto.gesresfamilyapp.contract.CentrosListContract;
import com.alberto.gesresfamilyapp.db.AppDatabase;
import com.alberto.gesresfamilyapp.domain.Centro;

import java.util.List;

public class CentrosListModel implements CentrosListContract.Model {

    private Context context;

    public CentrosListModel(Context context) {
        this.context = context;
    }
    @Override
    public List<Centro> loadAllCentros() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.centroDao().getAll();
    }

    @Override
    public List<Centro> loadCentrosByName(String name) {
        return null;
    }

    @Override
    public boolean deleteCentro(String name) {
        return false;
    }
}

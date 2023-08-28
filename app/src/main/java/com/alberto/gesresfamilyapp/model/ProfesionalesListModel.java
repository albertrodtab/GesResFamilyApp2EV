package com.alberto.gesresfamilyapp.model;

import static com.alberto.gesresfamilyapp.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.alberto.gesresfamilyapp.contract.ProfesionalesListContract;
import com.alberto.gesresfamilyapp.db.AppDatabase;
import com.alberto.gesresfamilyapp.domain.Profesional;

import java.util.List;

public class ProfesionalesListModel implements ProfesionalesListContract.Model {

    private Context context;

    public ProfesionalesListModel(Context context) {
        this.context = context;
    }
    @Override
    public List<Profesional> loadAllProfesionales() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.profesionalDao().getAll();
    }

    @Override
    public List<Profesional> loadProfesionalesByName(String name) {
        return null;
    }

    @Override
    public boolean deleteProfesional(String name) {
        return false;
    }
}

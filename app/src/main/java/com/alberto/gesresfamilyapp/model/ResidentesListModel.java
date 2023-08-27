package com.alberto.gesresfamilyapp.model;

import static com.alberto.gesresfamilyapp.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.alberto.gesresfamilyapp.contract.ProfesionalesListContract;
import com.alberto.gesresfamilyapp.contract.ResidentesListContract;
import com.alberto.gesresfamilyapp.db.AppDatabase;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.domain.Residente;

import java.util.List;

public class ResidentesListModel implements ResidentesListContract.Model {

    private Context context;

    public ResidentesListModel(Context context) {
        this.context = context;
    }
    @Override
    public List<Residente> loadAllResidentes() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.residenteDao().getAll();
    }

    @Override
    public List<Residente> loadResidentesByName(String name) {
        return null;
    }

    @Override
    public boolean deleteResidente(String name) {
        return false;
    }
}

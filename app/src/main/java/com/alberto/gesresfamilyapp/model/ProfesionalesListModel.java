package com.alberto.gesresfamilyapp.model;

import static com.alberto.gesresfamilyapp.db.Constants.DATABASE_NAME;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.alberto.gesresfamilyapp.api.GesResApi;
import com.alberto.gesresfamilyapp.api.GesResApiInterface;
import com.alberto.gesresfamilyapp.contract.CentrosListContract;
import com.alberto.gesresfamilyapp.contract.ProfesionalesListContract;
import com.alberto.gesresfamilyapp.db.AppDatabase;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfesionalesListModel implements ProfesionalesListContract.Model {

    private Context context;

    /*public ProfesionalesListModel(Context context) {
        this.context = context;
    }*/
    @Override
    public void loadAllProfesionales(ProfesionalesListContract.Model.OnLoadProfesionalListener listener) {
        GesResApiInterface apiInterface = GesResApi.buildInstance();
        Call<List<Profesional>> callProfesionales = apiInterface.getProfesionales();
        Log.d("profesionales", "Llamada desde model");
        callProfesionales.enqueue(new Callback<List<Profesional>>() {
            @Override
            public void onResponse(Call<List<Profesional>> call, Response<List<Profesional>> response) {
                Log.d("profesionales", "Llamada desde model ok");
                List<Profesional> profesionalList = response.body();
                listener.onLoadProfesionalSuccess(profesionalList);
            }
            @Override
            public void onFailure(Call<List<Profesional>> call, Throwable t) {
                Log.d("profesional", "Llamada desde model error");
                Log.d("profesional", t.getMessage());
                t.printStackTrace();
                String message = "Error al conseguir todos los profesionales";
                listener.onLoadProfesionalError(t.getMessage());
            }
        });
    }

/*    @Override
    public List<Profesional> loadProfesionalesByName(String name) {
        return null;
    }

    @Override
    public boolean deleteProfesional(String name) {
        return false;
    }*/
}

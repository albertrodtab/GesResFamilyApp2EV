package com.alberto.gesresfamilyapp.model.profesional;

import android.util.Log;

import com.alberto.gesresfamilyapp.api.GesResApi;
import com.alberto.gesresfamilyapp.api.GesResApiInterface;
import com.alberto.gesresfamilyapp.contract.centro.ModifyCentroContract;
import com.alberto.gesresfamilyapp.contract.profesional.ModifyProfesionalContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifyProfesionalModel implements ModifyProfesionalContract.Model {

    @Override
    public void modifyProfesional(Profesional profesional, OnModifyProfesionalListener listener) {
            GesResApiInterface apiInterface = GesResApi.buildInstance();
            Call<Profesional> profesionalCall = apiInterface.modifyProfesional(profesional.getId(), profesional);
            Log.d("Profesional", "Llamada desde model");
            profesionalCall.enqueue(new Callback<Profesional>() {
                @Override
                public void onResponse(Call<Profesional> call, Response<Profesional> response) {
                    Log.d("Profesional", "Llamada desde model ok");
                       listener.onModifyProfesionalSuccess(response.body());
                }
                @Override
                public void onFailure(Call<Profesional> call, Throwable t) {
                    Log.d("Profesional", "Llamada desde model error");
                    Log.d("Profesional", t.getMessage());
                    t.printStackTrace();
                    String message = "Error al conseguir todos los el profesional";
                    listener.onModifyProfesionalError(message);
                }
            });
    }

}

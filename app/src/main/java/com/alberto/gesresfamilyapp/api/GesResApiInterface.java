package com.alberto.gesresfamilyapp.api;

import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.domain.Residente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GesResApiInterface {

    //Cuales son las operaciones a las que queremos dar visibilidad dentro de la app android

    //Centros
    @GET("centros")
    Call<List<Centro>> getCentros();


    //Profesionales
    @GET("profesionales")
    Call<List<Profesional>> getProfesionales();


    //Residentes
    @GET("residentes")
    Call<List<Residente>> getResidentes();

}

package com.alberto.gesresfamilyapp.api;

import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.domain.Residente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GesResApiInterface {

    //Cuales son las operaciones a las que queremos dar visibilidad dentro de la app android

    //Centros
    @GET("centros")
    Call<List<Centro>> getCentros();

    @POST("centros")
    Call<Centro> addCentro(@Body Centro centro);


    //Profesionales
    @GET("profesionales")
    Call<List<Profesional>> getProfesionales();


    //Residentes
    @GET("residentes")
    Call<List<Residente>> getResidentes();

}

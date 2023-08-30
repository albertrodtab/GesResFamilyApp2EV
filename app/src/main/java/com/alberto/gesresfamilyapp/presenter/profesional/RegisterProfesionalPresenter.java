package com.alberto.gesresfamilyapp.presenter.profesional;


import com.alberto.gesresfamilyapp.contract.centro.RegisterCentroContract;
import com.alberto.gesresfamilyapp.contract.profesional.RegisterProfesionalContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.model.centro.RegisterCentroModel;
import com.alberto.gesresfamilyapp.model.profesional.RegisterProfesionalModel;
import com.alberto.gesresfamilyapp.view.centro.RegisterCentroView;
import com.alberto.gesresfamilyapp.view.profesional.RegisterProfesionalView;

public class RegisterProfesionalPresenter implements RegisterProfesionalContract.Presenter,
        RegisterProfesionalContract.Model.OnRegisterProfesionalListener{

    private RegisterProfesionalModel model;
    private RegisterProfesionalView view;

    public RegisterProfesionalPresenter(RegisterProfesionalView view){
        this.view = view;
        this.model = new RegisterProfesionalModel();
    }

    @Override
    public void registerProfesional(Profesional profesional) {
        model.registerProfesional(profesional, this);

    }

    @Override
    public void onRegisterProfesionalSuccess(Profesional profesional) {
        view.showMessage("Profesional registrado");
    }

    @Override
    public void onRegisterProfesionalError(String message) {
        view.showError("Se ha producido un error al registrar el Profesional. Inténtalo de nuevo");
    }
}
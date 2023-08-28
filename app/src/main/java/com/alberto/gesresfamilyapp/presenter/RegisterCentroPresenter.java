package com.alberto.gesresfamilyapp.presenter;


import com.alberto.gesresfamilyapp.contract.RegisterCentroContract;
import com.alberto.gesresfamilyapp.domain.Centro;

import com.alberto.gesresfamilyapp.model.RegisterCentroModel;
import com.alberto.gesresfamilyapp.view.RegisterCentroView;

public class RegisterCentroPresenter implements RegisterCentroContract.Presenter,
        RegisterCentroContract.Model.OnRegisterCentroListener{

    private RegisterCentroModel model;
    private RegisterCentroView view;

    public RegisterCentroPresenter(RegisterCentroView view){
        this.view = view;
        this.model = new RegisterCentroModel();
    }

    @Override
    public void registerCentro(Centro centro) {
        model.registerCentro(centro, this);

    }

    @Override
    public void onRegisterCentroSuccess(Centro centro) {
        view.showMessage("Centro registrado");
    }

    @Override
    public void onRegisterCentroError(String message) {
        view.showError("Se ha producido un error al registrar el centro. Inténtalo de nuevo");
    }
}
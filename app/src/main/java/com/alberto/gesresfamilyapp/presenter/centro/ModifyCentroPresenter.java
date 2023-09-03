package com.alberto.gesresfamilyapp.presenter.centro;


import com.alberto.gesresfamilyapp.contract.centro.ModifyCentroContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.model.centro.ModifyCentroModel;
import com.alberto.gesresfamilyapp.view.centro.RegisterCentroView;

public class ModifyCentroPresenter implements ModifyCentroContract.Presenter,
    ModifyCentroContract.Model.OnModifyCentroListener {
    private ModifyCentroModel model;
    private RegisterCentroView view;

    public ModifyCentroPresenter(RegisterCentroView view){
        this.view = view;
        model = new ModifyCentroModel();
    }

    @Override
    public void modifyCentro(Centro centro) {
        model.modifyCentro(centro,this);
    }

    @Override
    public void onModifyCentroSuccess(Centro centro) {
        view.showMessage("El centro: "+ centro.getNombre() + " se ha modificado correctamente.");
    }

    @Override
    public void onModifyCentroError(String message) {
        view.showError(message);

    }
}

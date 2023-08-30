package com.alberto.gesresfamilyapp.presenter.profesional;


import com.alberto.gesresfamilyapp.contract.centro.ModifyCentroContract;
import com.alberto.gesresfamilyapp.contract.profesional.ModifyProfesionalContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.model.centro.ModifyCentroModel;
import com.alberto.gesresfamilyapp.model.profesional.ModifyProfesionalModel;
import com.alberto.gesresfamilyapp.view.centro.RegisterCentroView;
import com.alberto.gesresfamilyapp.view.profesional.RegisterProfesionalView;

public class ModifyProfesionalPresenter implements ModifyProfesionalContract.Presenter,
    ModifyProfesionalContract.Model.OnModifyProfesionalListener {
    private ModifyProfesionalModel model;
    private RegisterProfesionalView view;

    public ModifyProfesionalPresenter(RegisterProfesionalView view){
        this.view = view;
        model = new ModifyProfesionalModel();
    }

    @Override
    public void modifyProfesional(Profesional profesional) {
        model.modifyProfesional(profesional,this);
    }

    @Override
    public void onModifyProfesionalSuccess(Profesional profesional) {
        view.showMessage("El profesional: "+ profesional.getNombre() + " se ha modificado correctamente.");
    }

    @Override
    public void onModifyProfesionalError(String message) {
        view.showError(message);

    }
}

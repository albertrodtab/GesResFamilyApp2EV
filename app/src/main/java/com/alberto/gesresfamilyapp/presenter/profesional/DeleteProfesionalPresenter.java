package com.alberto.gesresfamilyapp.presenter.profesional;

import com.alberto.gesresfamilyapp.adapter.CentroAdapter;
import com.alberto.gesresfamilyapp.adapter.ProfesionalAdapter;
import com.alberto.gesresfamilyapp.contract.centro.DeleteCentroContract;
import com.alberto.gesresfamilyapp.contract.profesional.DeleteProfesionalContract;
import com.alberto.gesresfamilyapp.model.centro.DeleteCentroModel;
import com.alberto.gesresfamilyapp.model.profesional.DeleteProfesionalModel;

public class DeleteProfesionalPresenter implements DeleteProfesionalContract.Presenter,
    DeleteProfesionalContract.Model.OnDeleteProfesionalListener {
    private DeleteProfesionalModel model;
    private ProfesionalAdapter view;

    public DeleteProfesionalPresenter(ProfesionalAdapter view){
        this.view = view;
        model = new DeleteProfesionalModel();
    }

    @Override
    public void deleteProfesional(long id) {
        model.deleteProfesional(id,this);
    }

    @Override
    public void onDeleteProfesionalSuccess(String message) {
        view.showMessage(message);
    }

    @Override
    public void onDeleteProfesionalError(String message) {
        view.showError(message);

    }
}

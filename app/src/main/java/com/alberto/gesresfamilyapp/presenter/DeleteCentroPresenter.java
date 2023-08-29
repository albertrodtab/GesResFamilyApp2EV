package com.alberto.gesresfamilyapp.presenter;

import com.alberto.gesresfamilyapp.adapter.CentroAdapter;
import com.alberto.gesresfamilyapp.contract.DeleteCentroContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.model.DeleteCentroModel;

import java.util.List;

public class DeleteCentroPresenter implements DeleteCentroContract.Presenter,
    DeleteCentroContract.Model.OnDeleteCentroListener {
    private DeleteCentroModel model;
    private CentroAdapter view;

    public DeleteCentroPresenter(CentroAdapter view){
        this.view = view;
        model = new DeleteCentroModel();
    }

    @Override
    public void deleteCentro(long id) {
        model.deleteCentro(id,this);

    }


    @Override
    public void onDeleteCentroSuccess(String message) {
        view.showMessage(message);
    }

    @Override
    public void onDeleteCentroError(String message) {
        view.showError(message);

    }
}

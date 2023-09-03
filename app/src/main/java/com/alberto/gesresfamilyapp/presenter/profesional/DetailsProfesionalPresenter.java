package com.alberto.gesresfamilyapp.presenter.profesional;


import com.alberto.gesresfamilyapp.contract.profesional.DetailsProfesionalContract;
import com.alberto.gesresfamilyapp.contract.profesional.ModifyProfesionalContract;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.model.profesional.DetailsProfesionalModel;
import com.alberto.gesresfamilyapp.model.profesional.ModifyProfesionalModel;
import com.alberto.gesresfamilyapp.view.profesional.DetailsProfesionalView;
import com.alberto.gesresfamilyapp.view.profesional.RegisterProfesionalView;

public class DetailsProfesionalPresenter implements DetailsProfesionalContract.Presenter,
    DetailsProfesionalContract.Model.OnLoadProfesionalListener {
    private DetailsProfesionalModel model;
    private DetailsProfesionalView view;

    public DetailsProfesionalPresenter(DetailsProfesionalView view){
        this.view = view;
        model = new DetailsProfesionalModel();
    }

    @Override
    public void loadProfesional (long id) {
        model.loadProfesional(id,this);
    }

    @Override
    public void onLoadProfesionalSuccess(Profesional profesional) {
        view.showProfesional(profesional);

    }

    @Override
    public void onLoadProfesionalError(String message) {
        view.showError(message);

    }
}

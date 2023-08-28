package com.alberto.gesresfamilyapp.presenter;

import com.alberto.gesresfamilyapp.contract.ProfesionalesListContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.model.CentrosListModel;
import com.alberto.gesresfamilyapp.model.ProfesionalesListModel;
import com.alberto.gesresfamilyapp.view.CentrosListView;
import com.alberto.gesresfamilyapp.view.ProfesionalesListView;

import java.util.List;

public class ProfesionalesListPresenter implements ProfesionalesListContract.Presenter,
    ProfesionalesListContract.Model.OnLoadProfesionalListener{

    private ProfesionalesListModel model;
    private ProfesionalesListView view;

    public ProfesionalesListPresenter(ProfesionalesListView view){
        this.view = view;
        this.model = new ProfesionalesListModel();
    }

    @Override
    public void loadAllProfesionales() {
        model.loadAllProfesionales(this);
    }


    @Override
    public void onLoadProfesionalSuccess(List<Profesional> ProfesionalesList) {
        view.showProfesionales(ProfesionalesList);

    }

    @Override
    public void onLoadProfesionalError(String message) {
        view.showMessage(message);

    }
}

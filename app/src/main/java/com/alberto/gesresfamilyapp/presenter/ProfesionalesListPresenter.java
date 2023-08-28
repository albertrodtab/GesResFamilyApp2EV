package com.alberto.gesresfamilyapp.presenter;

import com.alberto.gesresfamilyapp.contract.ProfesionalesListContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.model.CentrosListModel;
import com.alberto.gesresfamilyapp.model.ProfesionalesListModel;
import com.alberto.gesresfamilyapp.view.CentrosListView;
import com.alberto.gesresfamilyapp.view.ProfesionalesListView;

import java.util.List;

public class ProfesionalesListPresenter implements ProfesionalesListContract.Presenter {

    private ProfesionalesListModel model;
    private ProfesionalesListView view;

    public ProfesionalesListPresenter(ProfesionalesListView view){
        this.view = view;
        this.model = new ProfesionalesListModel(view.getApplicationContext());
    }

    @Override
    public void loadAllProfesionales() {
        List<Profesional> profesionales = model.loadAllProfesionales();
        view.showProfesionales(profesionales);

    }

    @Override
    public void loadProfesionalesByName(String name) {

    }

    @Override
    public void deleteProfesional(String name) {

    }
}

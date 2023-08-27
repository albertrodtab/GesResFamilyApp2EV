package com.alberto.gesresfamilyapp.presenter;

import com.alberto.gesresfamilyapp.contract.ResidentesListContract;
import com.alberto.gesresfamilyapp.domain.Residente;
import com.alberto.gesresfamilyapp.model.ResidentesListModel;
import com.alberto.gesresfamilyapp.view.ResidentesListView;

import java.util.List;

public class ResidentesListPresenter implements ResidentesListContract.Presenter {

    private ResidentesListModel model;
    private ResidentesListView view;

    public ResidentesListPresenter(ResidentesListView view){
        this.view = view;
        this.model = new ResidentesListModel(view.getApplicationContext());
    }

    @Override
    public void loadAllResidentes() {
        List<Residente> residentes = model.loadAllResidentes();
        view.showResidentes(residentes);

    }

    @Override
    public void loadResidentesByName(String name) {

    }

    @Override
    public void deleteResidente(String name) {

    }
}

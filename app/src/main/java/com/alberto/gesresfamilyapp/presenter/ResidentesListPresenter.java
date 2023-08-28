package com.alberto.gesresfamilyapp.presenter;

import com.alberto.gesresfamilyapp.contract.ResidentesListContract;
import com.alberto.gesresfamilyapp.domain.Residente;
import com.alberto.gesresfamilyapp.model.ResidentesListModel;
import com.alberto.gesresfamilyapp.view.ResidentesListView;

import java.util.List;

public class ResidentesListPresenter implements ResidentesListContract.Presenter,
    ResidentesListContract.Model.OnLoadResidenteListener{

    private ResidentesListModel model;
    private ResidentesListView view;

    public ResidentesListPresenter(ResidentesListView view){
        this.view = view;
        this.model = new ResidentesListModel();
    }

    @Override
    public void loadAllResidentes() {
        model.loadAllResidentes(this);

    }


    @Override
    public void onLoadResidenteSuccess(List<Residente> ResidentesList) {
        view.showResidentes(ResidentesList);

    }

    @Override
    public void onLoadResidenteError(String message) {
        view.showMessage(message);

    }
}

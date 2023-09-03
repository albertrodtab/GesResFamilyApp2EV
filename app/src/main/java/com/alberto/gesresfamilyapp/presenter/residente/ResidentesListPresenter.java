package com.alberto.gesresfamilyapp.presenter.residente;

import com.alberto.gesresfamilyapp.contract.residente.ResidentesListContract;
import com.alberto.gesresfamilyapp.domain.Residente;
import com.alberto.gesresfamilyapp.model.residente.ResidentesListModel;
import com.alberto.gesresfamilyapp.view.residente.ResidentesListView;

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

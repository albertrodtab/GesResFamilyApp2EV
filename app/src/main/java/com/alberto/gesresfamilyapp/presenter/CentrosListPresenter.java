package com.alberto.gesresfamilyapp.presenter;

import com.alberto.gesresfamilyapp.contract.CentrosListContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.model.CentrosListModel;
import com.alberto.gesresfamilyapp.view.CentrosListView;

import java.util.List;

public class CentrosListPresenter implements CentrosListContract.Presenter,
    CentrosListContract.Model.OnLoadCentroListener{

    private CentrosListModel model;
    private CentrosListView view;

    public CentrosListPresenter(CentrosListView view){
        this.view = view;
        this.model = new CentrosListModel();
    }

    @Override
    public void loadAllCentros() {
        model.loadAllCentros(this);

    }


    @Override
    public void onLoadCentrosSuccess(List<Centro> centrosList) {
        view.showCentros(centrosList);
    }

    @Override
    public void onLoadCentrosError(String message) {
        view.showMessage(message);

    }
}

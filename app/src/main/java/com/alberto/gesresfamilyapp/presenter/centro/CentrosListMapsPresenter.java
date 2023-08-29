package com.alberto.gesresfamilyapp.presenter.centro;

import com.alberto.gesresfamilyapp.contract.centro.CentrosListContract;
import com.alberto.gesresfamilyapp.contract.centro.CentrosListMapsContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.model.centro.CentrosListMapsModel;
import com.alberto.gesresfamilyapp.model.centro.CentrosListModel;
import com.alberto.gesresfamilyapp.view.MapsActivityView;
import com.alberto.gesresfamilyapp.view.centro.CentrosListView;

import java.util.List;

public class CentrosListMapsPresenter implements CentrosListMapsContract.Presenter,
    CentrosListMapsContract.Model.OnLoadCentroListener{

    private CentrosListMapsModel model;
    private MapsActivityView view;

    public CentrosListMapsPresenter(MapsActivityView view){
        this.view = view;
        this.model = new CentrosListMapsModel();
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

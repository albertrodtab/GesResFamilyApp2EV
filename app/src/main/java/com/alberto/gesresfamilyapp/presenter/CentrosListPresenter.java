package com.alberto.gesresfamilyapp.presenter;

import com.alberto.gesresfamilyapp.contract.CentrosListContract;
import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.model.CentrosListModel;
import com.alberto.gesresfamilyapp.view.CentrosListView;

import java.util.List;

public class CentrosListPresenter implements CentrosListContract.Presenter {

    private CentrosListModel model;
    private CentrosListView view;

    public CentrosListPresenter(CentrosListView view){
        this.view = view;
        this.model = new CentrosListModel(view.getApplicationContext());
    }

    @Override
    public void loadAllCentros() {
        List<Centro> centros = model.loadAllCentros();
        view.showCentros(centros);

    }

    @Override
    public void loadCentrosByName(String name) {

    }

    @Override
    public void deleteCentro(String name) {

    }
}

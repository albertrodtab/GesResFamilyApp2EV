package com.alberto.gesresfamilyapp.contract;

import com.alberto.gesresfamilyapp.domain.Profesional;
import com.alberto.gesresfamilyapp.domain.Residente;

import java.util.List;

public interface ResidentesListContract {

    interface Model{
        interface OnLoadResidenteListener {
            void onLoadResidenteSuccess(List<Residente> ResidentesList);
            void onLoadResidenteError(String message);
        }
        void loadAllResidentes(ResidentesListContract.Model.OnLoadResidenteListener listener);
    }

    interface view{
        void showResidentes(List<Residente> residentes);
        void showMessage(String message);
    }

    interface Presenter{
        void loadAllResidentes();
    }

}

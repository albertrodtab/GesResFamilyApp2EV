package com.alberto.gesresfamilyapp.contract;

import com.alberto.gesresfamilyapp.domain.Residente;

import java.util.List;

public interface ResidentesListContract {

    interface Model{
        List<Residente> loadAllResidentes();
        List<Residente> loadResidentesByName(String name);
        boolean deleteResidente(String name);

    }

    interface view{
        void showResidentes(List<Residente> residentes);
        void showMessage(String message);
    }

    interface Presenter{
        void loadAllResidentes();
        void loadResidentesByName(String name);
        void deleteResidente(String name);
    }

}

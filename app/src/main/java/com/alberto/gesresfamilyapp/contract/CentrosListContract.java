package com.alberto.gesresfamilyapp.contract;

import com.alberto.gesresfamilyapp.domain.Centro;

import java.util.List;

public interface CentrosListContract {

    interface Model{
        List<Centro> loadAllCentros();
        List<Centro> loadCentrosByName(String name);
        boolean deleteCentro(String name);

    }

    interface view{
        void showCentros(List<Centro> centros);
        void showMessage(String message);
    }

    interface Presenter{
        void loadAllCentros();
        void loadCentrosByName(String name);
        void deleteCentro(String name);
    }

}

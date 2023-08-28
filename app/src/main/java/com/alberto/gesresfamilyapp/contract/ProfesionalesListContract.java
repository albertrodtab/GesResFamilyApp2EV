package com.alberto.gesresfamilyapp.contract;

import com.alberto.gesresfamilyapp.domain.Centro;
import com.alberto.gesresfamilyapp.domain.Profesional;

import java.util.List;

public interface ProfesionalesListContract {

    interface Model{
        List<Profesional> loadAllProfesionales();
        List<Profesional> loadProfesionalesByName(String name);
        boolean deleteProfesional(String name);

    }

    interface view{
        void showProfesionales(List<Profesional> profesionales);
        void showMessage(String message);
    }

    interface Presenter{
        void loadAllProfesionales();
        void loadProfesionalesByName(String name);
        void deleteProfesional(String name);
    }

}

package com.alberto.gesresfamilyapp.contract.profesional;

import com.alberto.gesresfamilyapp.domain.Profesional;

public interface ModifyProfesionalContract {

    interface Model{
        interface OnModifyProfesionalListener {
            void onModifyProfesionalSuccess(Profesional profesional);
            void onModifyProfesionalError(String error);
        }
        void modifyProfesional(Profesional profesional, OnModifyProfesionalListener listener);
    }

    interface view {
        void showError(String message);
        void showMessage(String message);
    }

    interface Presenter{
        void modifyProfesional(Profesional profesional);

    }

}

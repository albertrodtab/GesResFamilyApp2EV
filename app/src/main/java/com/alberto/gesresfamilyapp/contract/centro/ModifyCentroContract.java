package com.alberto.gesresfamilyapp.contract.centro;

import com.alberto.gesresfamilyapp.domain.Centro;

public interface ModifyCentroContract {

    interface Model{
        interface OnModifyCentroListener {
            void onModifyCentroSuccess(Centro centro);
            void onModifyCentroError(String error);
        }
        void modifyCentro(Centro centro, OnModifyCentroListener listener);
    }

    interface view {
        void showError(String message);
        void showMessage(String message);
    }

    interface Presenter{
        void modifyCentro(Centro centro);

    }

}

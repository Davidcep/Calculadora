package com.example.calculadora.Domain;

import com.example.calculadora.View.Vista;

public interface Presenter {

    void setVista(Vista vista);
    void setOperacion(int id);
    void setCalculo();
}

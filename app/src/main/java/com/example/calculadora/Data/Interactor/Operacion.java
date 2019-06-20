package com.example.calculadora.Data.Interactor;

import com.example.calculadora.Data.Entity.Operando;
import com.example.calculadora.Data.Entity.Resutado;

public interface Operacion {

    void init(Operando operando1, Operando operando2);
    void calcular();
    Resutado getResultado();
}

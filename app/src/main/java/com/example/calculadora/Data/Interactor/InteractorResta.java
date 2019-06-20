package com.example.calculadora.Data.Interactor;

import com.example.calculadora.Data.Entity.Operando;
import com.example.calculadora.Data.Entity.Resutado;

public class InteractorResta implements Operacion{

    Operando operando1;
    Operando operando2;
    Resutado resutado;

    @Override
    public void init(Operando operando1, Operando operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    @Override
    public void calcular() {
        resutado = new Resutado(operando1.getValor() - operando2.getValor());
    }

    @Override
    public Resutado getResultado() {
        return resutado;
    }
}

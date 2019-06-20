package com.example.calculadora.Domain;

import com.example.calculadora.Data.Entity.Operando;
import com.example.calculadora.Data.Interactor.Operacion;
import com.example.calculadora.Inject.DaggerInteractorComponent;
import com.example.calculadora.View.Vista;
import com.example.calculadora.R;

import javax.inject.Inject;
import javax.inject.Named;

public class PresenterImpl implements Presenter {

    private static final int SUMA = 0;
    private static final int RESTA = 1;
    private static final int MULT = 2;
    private static final int DIV = 3;

    private int tipoOperacion;
    private Vista vista;

    @Inject @Named("Suma") Operacion opSuma;
    @Inject @Named("Resta") Operacion opResta;
    @Inject @Named("Div") Operacion opDiv;
    @Inject @Named("Mult") Operacion opMult;


    @Override
    public void setVista(Vista vista) {
        this.vista = vista;
    }

    @Override
    public void setOperacion(int id) {
        switch (id) {
            case R.id.btnSuma:
                tipoOperacion = SUMA;
                break;
            case R.id.btnResta:
                tipoOperacion = RESTA;
                break;
            case R.id.btnMult:
                tipoOperacion = MULT;
                break;
            case R.id.btnDivision:
                tipoOperacion = DIV;
                break;
        }
    }

    @Override
    public void setCalculo() {

        DaggerInteractorComponent.builder().build().inject(this);
        Operacion operacion = null;
        String[] operandos = vista.getOperandos();
        Operando operando1 = new Operando(Integer.parseInt(operandos[0]));
        Operando operando2 = new Operando(Integer.parseInt(operandos[1]));


        switch (tipoOperacion) {
            case SUMA:
                operacion = opSuma;
                opSuma.init(operando1, operando2);
                break;
            case RESTA:
                operacion = opResta;
                opResta.init(operando1, operando2);
                break;
            case MULT:
                operacion = opMult;
                opMult.init(operando1, operando2);
                break;
            case DIV:
                operacion = opDiv;
                opDiv.init(operando1, operando2);
                break;
        }

        operacion.calcular();
        vista.mostrarResultado(String.valueOf(operacion.getResultado().getValor()));
    }
}

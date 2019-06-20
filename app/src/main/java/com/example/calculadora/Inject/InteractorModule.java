package com.example.calculadora.Inject;

import com.example.calculadora.Data.Interactor.InteractorDivision;
import com.example.calculadora.Data.Interactor.InteractorMultiplicacion;
import com.example.calculadora.Data.Interactor.InteractorResta;
import com.example.calculadora.Data.Interactor.InteractorSuma;
import com.example.calculadora.Data.Interactor.Operacion;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    @Named("Suma")
    public Operacion provideSuma() {
        return new InteractorSuma();
    }

    @Provides
    @Named("Resta")
    public Operacion provideResta() {
        return new InteractorResta();
    }

    @Provides
    @Named("Div")
    public Operacion provideDiv() {
        return new InteractorDivision();
    }

    @Provides
    @Named("Mult")
    public Operacion provideMult() {
        return new InteractorMultiplicacion();
    }
}


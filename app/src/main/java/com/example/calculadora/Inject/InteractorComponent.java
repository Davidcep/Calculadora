package com.example.calculadora.Inject;

import com.example.calculadora.Domain.PresenterImpl;

import dagger.Component;

@Component(modules = InteractorModule.class)
public interface InteractorComponent {
    void inject(PresenterImpl presenteImpl);
}

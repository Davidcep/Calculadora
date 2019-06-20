package com.example.calculadora.Inject;

import com.example.calculadora.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = PresenterModule.class)
public interface PresenterComponent {
    void inject(MainActivity mainActivity);
}

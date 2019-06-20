package com.example.calculadora.Inject;

import com.example.calculadora.Domain.Presenter;
import com.example.calculadora.Domain.PresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Singleton
    @Provides
    public Presenter providePresenter() {
        return new PresenterImpl();
    }
}

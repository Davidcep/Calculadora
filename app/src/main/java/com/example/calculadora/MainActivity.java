package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculadora.Inject.DaggerPresenterComponent;
import com.example.calculadora.Domain.Presenter;
import com.example.calculadora.View.Vista;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements Vista {

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerPresenterComponent.builder().build().inject(this);
        presenter.setVista(this);

        cargarVista();
    }

    private void cargarVista() {
        Button btnSuma = findViewById(R.id.btnSuma);
        Button btnResta = findViewById(R.id.btnResta);
        Button btnDiv = findViewById(R.id.btnDivision);
        Button btnMult = findViewById(R.id.btnMult);

        //Al pulsar cualquier botón
        btnSuma.setOnClickListener(onClick);
        btnResta.setOnClickListener(onClick);
        btnDiv.setOnClickListener(onClick);
        btnMult.setOnClickListener(onClick);
    }

    private View.OnClickListener onClick = (new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.setOperacion(v.getId());
            presenter.setCalculo();
        }
    });
    @Override
    public String[] getOperandos() {
        EditText et1 = findViewById(R.id.etOperando1);
        EditText et2 = findViewById(R.id.etOperando2);
        String[] s  = {et1.getText().toString(), et2.getText().toString()};
        return s;
    }

    @Override
    public void mostrarResultado(String resutado) {
        TextView tv = findViewById(R.id.tvResultado);
        tv.setText(resutado);
    }
}

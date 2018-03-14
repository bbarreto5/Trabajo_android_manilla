package com.example.user.mymanillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    private RadioGroup op1,op2;
    private EditText cantidad,precio;
    private Button cotizar;
    private Spinner spiner;
    private Switch sw1,sw2;
    private int valor;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        op1 = findViewById(R.id.rg1);
        op2 = findViewById(R.id.rg2);
        cantidad = findViewById(R.id.txtcantidad);
        precio = findViewById(R.id.txtprecio);
        cotizar = findViewById(R.id.button);
        spiner = findViewById(R.id.spinner);
        sw1 = findViewById(R.id.switch1);
        sw2 = findViewById(R.id.switch2);
        recursos = this.getResources();
    }
    public void mostrar(View v){
        if(validar()){
            pago();
            int n = Integer.parseInt(cantidad.getText().toString());
            valor*=n;
            tipo_moneda();
            precio.setText(valor+"");
        }
        //Toast.makeText(MainActivity.this,"valor: "+(valor), Toast.LENGTH_SHORT).show();
    }

    public boolean validar(){
        if(cantidad.getText().toString().equals("")){
            cantidad.requestFocus();
            cantidad.setError(recursos.getString(R.string.error1));
            return false;
        }else if(Integer.parseInt(cantidad.getText().toString())<=0){
            cantidad.requestFocus();
            cantidad.setError(recursos.getString(R.string.error2));
            return false;
        }else if(!sw1.isChecked() && !sw2.isChecked() ){
            Toast toast = Toast.makeText(this, recursos.getString(R.string.error3)+"", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return false;
        }else if(sw1.isChecked() && sw2.isChecked()){
            Toast toast = Toast.makeText(this, recursos.getString(R.string.error4)+"", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
            return false;
        }
        return true;
    }
    public void pago() {
        if (op1.getCheckedRadioButtonId() == R.id.rb1) {
            tipo_dijen(1);
        }else{
            tipo_dijen(2);
        }
    }
    public void tipo_dijen(int n){
        switch (n) {
            case 1:
                if (op2.getCheckedRadioButtonId() == R.id.rb3) {
                    int opcion = spiner.getSelectedItemPosition();
                    valor=Metodos.tipo_tipo(opcion);
                }else{
                    int opcion = spiner.getSelectedItemPosition();
                    valor=Metodos.tipo_tipo2(opcion);
                }
                break;
            case 2:
                if (op2.getCheckedRadioButtonId() == R.id.rb3) {
                    int opcion = spiner.getSelectedItemPosition();
                    valor=Metodos.tipo_tipo3(opcion);
                }else{
                    int opcion = spiner.getSelectedItemPosition();
                    valor=Metodos.tipo_tipo4(opcion);
                }
                break;
        }
    }

    public void tipo_moneda(){
        if(sw2.isChecked()){
            valor*=3200;
        }
    }
}

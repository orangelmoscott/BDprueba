package com.example.mybasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db= null;
    private RadioButton r1,r2,r3,r4;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1= findViewById(R.id.btc_consul);
        r2= findViewById(R.id.btc_alta);
        r3= findViewById(R.id.btc_eli);
        r4 = findViewById(R.id.btc_mod);
        rg= findViewById(R.id.radiogrupo1);

    }

    public void crearBd(View view){
        BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null,1);
        db = usdbh.getWritableDatabase();
        if(db != null){
            for(int i =1; i <= 5; i++){
                int codigo = i;
                String nombre = "Usuario" + i;
                db.execSQL("INSERT INTO Usuarios  (codigo, nombre) " +  "VALUES ("+ codigo + ", '" + nombre + " ')");
                System.out.println("INSERTADO !!!");
            }
        }
    }

        public void mostrarLayout(View view){
        int radioseleccionado = rg.getCheckedRadioButtonId();

        switch (radioseleccionado){
            case R.id.btc_consul:
                Intent i = new Intent(this, Consulta.class);
                startActivity(i);
                break;
            case R.id.btc_alta:
                Intent i2 = new Intent(this, Alta.class);
                startActivity(i2);
                break;
            case R.id.btc_eli:
                Intent i3 = new Intent(this, Eliminar.class);
                startActivity(i3);
                break;
            case  R.id.btc_mod:
                Intent i4 = new Intent(this,Actualizar.class);
                startActivity(i4);
                break;
            default:
                break;
        }
        }
}
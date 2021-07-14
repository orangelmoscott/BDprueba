package com.example.mybasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Eliminar extends AppCompatActivity {
    private EditText nombre;
    private TextView resultado;
    SQLiteDatabase  db = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);

        this.nombre= findViewById(R.id.txtNombreBorrar);
        this.resultado= findViewById(R.id.txtborrado);

    }
    public void BorrarBD( View view){
        try{
            BaseDatosHelper usdbh = new BaseDatosHelper(this,"DBUsuarios",null,1);
            db = usdbh.getWritableDatabase();

            db.delete("Usuarios", "codigo=?",new String[] {nombre.getText().toString()

            });
            this.resultado.setText("Borrardo con exito!!!");


        }catch (Exception e){
            System.out.println(toString());

        }
    }

    public void cerrar(View view){
        finish();
    }
}
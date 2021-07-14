package com.example.mybasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Alta extends AppCompatActivity {
    private EditText codigo,nombre;
    private TextView resultado;
    SQLiteDatabase db= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        this.codigo= findViewById(R.id.txtCodigo);
        this.nombre = findViewById(R.id.txtNombre);
        this.resultado= findViewById(R.id.tv_resultado);

    }
    public void Alta( View view){
        BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios",null,1);
        db = usdbh.getWritableDatabase();

        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("codigo", codigo.getText().toString());
        nuevoRegistro.put("nombre", nombre.getText().toString());
        db.insert("Usuarios", null, nuevoRegistro);
        this.resultado.setText("Alta correcta!!!");
    }
    public void cerrar(View view){
        finish();
    }
}
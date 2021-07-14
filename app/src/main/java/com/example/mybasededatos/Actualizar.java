package com.example.mybasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Actualizar extends AppCompatActivity {
    private EditText codigo,nombre;
    private TextView resulatdo;
    SQLiteDatabase db = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);

        this.resulatdo = findViewById(R.id.txtModifi);
        this.codigo = findViewById(R.id.txtcodigoActualizar);
        this.nombre = findViewById(R.id.txtNombreActualizar);

    }

    public void ModificarBD(View view){
        try{
            BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null,1);
            db = usdbh.getWritableDatabase();

            ContentValues valores =  new ContentValues();
            valores.put("codigo", codigo.getText().toString());

            db.update("Usuarios", valores,"nombre=?", new String[]{
                    nombre.getText().toString()
            });
            this.resulatdo.setText("registro modificado!!!");


        } catch (Exception e){
            System.out.println(e.toString());

        }
    }

    public void cerra( View view){
        finish();
    }
}
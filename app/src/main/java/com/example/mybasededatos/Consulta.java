package com.example.mybasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Consulta extends AppCompatActivity {

    private EditText nombre;
    private TextView resultado;
    SQLiteDatabase db = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        this.resultado = findViewById(R.id.txtrecuperar);
        this.nombre = findViewById(R.id.editTextTextPersonName);

    }
    public void recuperarDatos( View view){
        try {
            String [] args = new String[] {nombre.getText().toString()};
            String codigo = " ";
             String nombre = " ";
            BaseDatosHelper usdbh = new BaseDatosHelper(this, "DBUsuarios", null,1);

            SQLiteDatabase db = usdbh.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT codigo,nombre FROM Usuarios where nombre=?", args);
            if(c.moveToFirst()){
                do{
                    codigo = c.getString(0);
                    nombre = c.getString(1);

                } while(c.moveToNext());

            }
             this.resultado.setText("codigo usuario:" + codigo);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public void cerrar (View view){
        finish();
    }
}
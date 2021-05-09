package sv.edu.udb.guia12appcontentprovider;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText et1,et2,et3;

    private StudentsAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
    }
    public void cargar (View view) {
       finish();
    }
    public void alta(View v) {
        DatabaseHelper admin = new DatabaseHelper(this,"administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String nom = et1.getText().toString();
        String apel = et2.getText().toString();
        String carn = et3.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put(StudentsContract.Columnas.NOMBRE, nom);
        registro.put(StudentsContract.Columnas.APELLIDO, apel);
        registro.put(StudentsContract.Columnas.CARNET, carn);

        try {
            bd.insertOrThrow(StudentsContract.STUDENTS, null, registro);
            bd.close();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            Toast.makeText(this, "Se cargaron los datos del alumno",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR!! No se cargaron los datos del alumno" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

}
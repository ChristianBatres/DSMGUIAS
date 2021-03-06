package sv.edu.udb.sqllitepersona;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3, et4, et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
    }

    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String cod = et1.getText().toString();
        String nomb = et2.getText().toString();
        String apell = et3.getText().toString();
        String edad = et4.getText().toString();
        String tel = et5.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("codigo", cod);
        registro.put("nombre", nomb);
        registro.put("apellido", apell);
        registro.put("edad", edad);
        registro.put("telefono", tel);

        try {
            bd.insertOrThrow("personas", null, registro);
            bd.close();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
            et5.setText("");

            Toast.makeText(this, "Se cargaron los datos de la persona",Toast.LENGTH_SHORT).show();
        } catch (SQLiteException e) {
            Toast.makeText(this, "ERROR!! No se cargaron los datos de la persona" + e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    public void consultaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        Cursor fila = bd.rawQuery("select nombre, apellido, edad, telefono from personas where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
            et5.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe la persona con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void consultaportelefono(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String tel = et5.getText().toString();
        Cursor fila = bd.rawQuery("select codigo,nombre, apellido, edad from personas where telefono='" + tel +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            et2.setText(fila.getString(1));
            et3.setText(fila.getString(2));
            et4.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe persona con ese numero de telefono",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }

    public void bajaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et1.getText().toString();
        int cant = bd.delete("personas", "codigo=" + cod, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró la persona con dicho código",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe una persona con dicho código",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String nomb = et2.getText().toString();
        String apell = et3.getText().toString();
        String edad= et4.getText().toString();
        String tel = et5.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("nombre", nomb);
        registro.put("apellido", apell);
        registro.put("telefono", tel);
        registro.put("edad", edad);
        int cant = bd.update("personas", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe una con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }
}
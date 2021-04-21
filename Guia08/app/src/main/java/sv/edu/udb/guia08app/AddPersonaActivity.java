package sv.edu.udb.guia08app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import sv.edu.udb.guia08app.datos.Persona;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtDUI, edtNombre, edNacimiento, edGenero, edAltura, edPeso;
    String key="",nombre="",dui="",accion="",genero="", nacimiento="", altura="", peso="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edNacimiento = findViewById(R.id.edNacimiento);
        edGenero = findViewById(R.id.edGenero);
        edAltura = findViewById(R.id.edAltura);
        edPeso = findViewById(R.id.edPeso);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        nacimiento = datos.getString("nacimiento");
        genero=datos.getString("genero");
        altura = datos.getString("altura");
        peso=datos.getString("peso");
        accion=datos.getString("accion");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);

        edNacimiento.setText(nacimiento);
        edGenero.setText(genero);

        edPeso.setText(peso);
        edAltura.setText(altura);
    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();

        String nacimiento = edNacimiento.getText().toString();
        String genero = edGenero.getText().toString();

        String peso = edPeso.getText().toString();
        String altura = edAltura.getText().toString();
        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre,nacimiento, genero, peso, altura);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}

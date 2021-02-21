package sv.edu.udb.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText horas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=(EditText)findViewById(R.id.txtnombre);
        horas=(EditText)findViewById(R.id.txthoras);
    }

    public void segundaActividad (View v) {
        Intent i=new Intent(this, segundaActivida.class);
        i.putExtra("txtnombre", nombre.getText().toString());
        i.putExtra("txthoras", horas.getText().toString());
        startActivity(i);
    }
}
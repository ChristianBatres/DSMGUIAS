package sv.edu.udb.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

public class segundaActivida extends AppCompatActivity {
    private TextView txtNombre;
    private TextView tvSueldo;
    private TextView tvisss;
    private TextView tvafp;
    private TextView tvrenta;
    private TextView tvneto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_activida);

        txtNombre=(TextView)findViewById(R.id.txtNombre);
        tvSueldo=(TextView)findViewById(R.id.txtsalario);
        tvafp=(TextView)findViewById(R.id.txtafp);
        tvisss=(TextView)findViewById(R.id.txtiss);
        tvrenta=(TextView)findViewById(R.id.txtrenta);
        tvneto=(TextView)findViewById(R.id.txtneto);
        Bundle bundle = getIntent().getExtras();

        String nombre=bundle.getString("txtnombre");
        txtNombre.setText(nombre);
        double horas=Double.parseDouble( bundle.getString("txthoras"));
        double salario=horas*8.5;
        double isss=salario*0.02;
        double afp=salario*0.03;
        double renta=salario*0.04;
        double neto=salario-isss-afp-renta;

        tvSueldo.setText(String.valueOf(salario));
        tvisss.setText(String.valueOf(isss));
        tvafp.setText(String.valueOf(afp));
        tvrenta.setText(String.valueOf(renta));
        tvneto.setText(String.valueOf(neto));
    }

    public void finalizar(View v) {

        finish();
    }
}
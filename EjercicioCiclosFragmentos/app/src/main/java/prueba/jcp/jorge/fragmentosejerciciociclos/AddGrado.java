package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Añade un nuevo ciclo.
 */
public class AddGrado extends AppCompatActivity {
    private EditText nombre, desc;
    private RadioButton rbGradSup, rbGradMed, rbInfo, rbEmp, rbDep;
    private Button btnEnviar;

    private String nom, des, tipo, familia;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grado);

        nombre = (EditText) findViewById(R.id.etNombre);
        desc = (EditText) findViewById(R.id.etDesc);

        rbGradMed = (RadioButton) findViewById(R.id.rbMedio);
        rbGradSup = (RadioButton) findViewById(R.id.rbSuperior);

        rbDep = (RadioButton) findViewById(R.id.rbDep);
        rbEmp = (RadioButton) findViewById(R.id.rbEmpresa);
        rbInfo = (RadioButton) findViewById(R.id.rbInfo);

        btnEnviar = (Button) findViewById(R.id.btnAddCiclo);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom = nombre.getText().toString();
                des = desc.getText().toString();

                if(rbGradSup.isChecked()) tipo = "Mitjà";
                else if(rbGradMed.isChecked()) tipo = "Superior";

                if(rbInfo.isChecked()) familia = "INFORMÀTICA";
                else if(rbEmp.isChecked()) familia = "EMPRESA";
                else if(rbDep.isChecked()) familia = "ESPORT";

                new CicleFlorida(nom, des, tipo, familia);
                Log.d("env", "eee");

                Toast.makeText(getApplicationContext(), "Ciclo creado con éxito.", Toast.LENGTH_LONG);
            }
        });
    }

}

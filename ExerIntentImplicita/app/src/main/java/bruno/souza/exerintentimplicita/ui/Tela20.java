package bruno.souza.exerintentimplicita.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bruno.souza.exerintentimplicita.R;
import bruno.souza.exerintentimplicita.model.Pessoa;

public class Tela20 extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela20);
        etNome = findViewById(R.id.t20_et_nome);
        etIdade = findViewById(R.id.t20_et_idade);
        btEnviar = findViewById(R.id.t20_bt_enviar);
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setIdade(Integer.parseInt(etIdade.getText().toString()));
                Intent it = new Intent(Tela20.this,Tela21.class);
                it.putExtra("c",p);
                startActivity(it);
            }
        });
    }
}

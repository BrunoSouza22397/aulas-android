package bruno.souza.exerintentimplicita.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bruno.souza.exerintentimplicita.R;

public class Tela10 extends AppCompatActivity {

    private EditText etNome;
    private Button btEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela10);
        etNome = findViewById(R.id.t10_et_nome);
        btEnviar = findViewById(R.id.t10_bt_enviar);
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Tela10.this, Tela11.class);
                it.putExtra("nome",etNome.getText().toString());
                startActivity(it);
            }
        });
    }
}

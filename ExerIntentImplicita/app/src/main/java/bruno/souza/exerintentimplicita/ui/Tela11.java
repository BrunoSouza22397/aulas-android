package bruno.souza.exerintentimplicita.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import bruno.souza.exerintentimplicita.R;

public class Tela11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela11);
        if(getIntent().hasExtra("nome")){
            String nome = getIntent().getStringExtra("nome");
            Toast.makeText(getBaseContext(),"Olá "+nome+".",Toast.LENGTH_LONG).show();
        }
    }
}

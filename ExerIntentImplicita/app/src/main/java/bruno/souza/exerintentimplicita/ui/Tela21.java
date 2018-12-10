package bruno.souza.exerintentimplicita.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import bruno.souza.exerintentimplicita.R;
import bruno.souza.exerintentimplicita.model.Pessoa;

public class Tela21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela21);
        if (getIntent().hasExtra("c")){
            Pessoa p = getIntent().getParcelableExtra("c");
            Toast.makeText(getBaseContext(),"Nome: "+p.getNome()+"\nIdade: "+p.getIdade(),Toast.LENGTH_LONG).show();
        }
    }
}

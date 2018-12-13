package bruno.souza.exspinnerlistviewstringarraytarde.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import bruno.souza.exspinnerlistviewstringarraytarde.R;
import bruno.souza.exspinnerlistviewstringarraytarde.model.Contato;

public class Ex4Detalhes extends AppCompatActivity {

    private TextView tvDetalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_detalhes);
        tvDetalhes = findViewById(R.id.e4det_tv_detalhes);

        if (getIntent().hasExtra("c")){
            Contato c = getIntent().getParcelableExtra("c");
            tvDetalhes.setText(c.toString());
        }
    }
}

package bruno.souza.exspinnerlistviewstringarraytarde.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import bruno.souza.exspinnerlistviewstringarraytarde.R;

public class Ex1 extends AppCompatActivity {

    private Spinner spSexo;
    private Button btOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
        spSexo = findViewById(R.id.e1_sp_sexo);
        btOK = findViewById(R.id.e1_bt_ok);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spSexo.getSelectedItemPosition() == 0){
                    toast("Selecione um contato!");
                    return;
                }
                String sexo = spSexo.getSelectedItem().toString();
                toast("Sexo selecionado: "+sexo);
            }
        });
        spSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    String sexo = parent.getSelectedItem().toString();
                    toast("Sexo selecionado: "+sexo);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }//fecha onCreate

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}

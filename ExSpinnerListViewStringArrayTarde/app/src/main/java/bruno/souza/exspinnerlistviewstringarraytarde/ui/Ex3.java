package bruno.souza.exspinnerlistviewstringarraytarde.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import bruno.souza.exspinnerlistviewstringarraytarde.R;

public class Ex3 extends AppCompatActivity {

    private EditText etNome;
    private Button btCadastrar;
    private ListView lvNomes;

    private ArrayAdapter<String> adapter;
    private ArrayList<String> nomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
        init();
        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNome.getText().toString().isEmpty()){
                    etNome.setError("Digite um nome!");
                    return;
                }
                nomes.add(etNome.getText().toString());
                adapter.notifyDataSetChanged();
                limpar();
                toast("Contato adicionado com sucesso!");
            }
        });
        lvNomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = parent.getItemAtPosition(position).toString();
                toast("Clicou no "+nome);
            }
        });
        lvNomes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String nome = parent.getItemAtPosition(position).toString();
                toast("Clicou e segurou no "+nome);
                return true;
            }
        });
    }
    private void limpar(){
        etNome.setText("");
    }
    private void toast(String msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }
    private void init(){
        etNome = findViewById(R.id.e3_et_nome);
        btCadastrar = findViewById(R.id.e3_bt_cadastrar);
        lvNomes = findViewById(R.id.e3_lv_nomes);

        nomes = new ArrayList<>();
        adapter = new ArrayAdapter<>(Ex3.this,android.R.layout.simple_list_item_1,nomes);
        lvNomes.setAdapter(adapter);
    }
}

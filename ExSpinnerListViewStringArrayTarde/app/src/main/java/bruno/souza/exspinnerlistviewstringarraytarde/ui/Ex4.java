package bruno.souza.exspinnerlistviewstringarraytarde.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;

import bruno.souza.exspinnerlistviewstringarraytarde.R;
import bruno.souza.exspinnerlistviewstringarraytarde.model.Contato;

public class Ex4 extends AppCompatActivity {

    private EditText etNome;
    private EditText etIdade;
    private EditText etEmail;
    private EditText etFone;
    private Button btCad;
    private ListView lvContatos;

    private ArrayAdapter<Contato> adapter;
    private ArrayList<Contato> contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);
        init();

        btCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etNome.getText().toString().isEmpty()){
                    etNome.setError("Digite um nome!");
                    return;
                }
                if (etIdade.getText().toString().isEmpty()){
                    etIdade.setError("Digite uma idade!");
                    return;
                }
                if (etEmail.getText().toString().isEmpty()){
                    etEmail.setError("Digite um email!");
                    return;
                }
                if (etFone.getText().toString().isEmpty()){
                    etFone.setError("Digite um telefone!");
                    return;
                }

                Contato c = new Contato();
                c.setNome(etNome.getText().toString());
                c.setIdade(Integer.parseInt(etIdade.getText().toString()));
                c.setEmail(etEmail.getText().toString());
                c.setTelefone(etFone.getText().toString());

                contato.add(c);
                adapter.notifyDataSetChanged();
                limpar();
                hideSoftKeyboard(v);
                toast("Contato cadastrado com sucesso!");
            }
        });
        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(Ex4.this,Ex4Detalhes.class);
                Contato c = (Contato) parent.getItemAtPosition(position);
                it.putExtra("c", c);
                startActivity(it);
            }
        });
        lvContatos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(Ex4.this);
                adb.setTitle("Excluir?");
                adb.setMessage("Tem certeza que quer excluir este contato?");
                adb.setNegativeButton("Cancelar", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        contato.remove(position);
                        adapter.notifyDataSetChanged();
                    }});
                adb.show();
                return true;
            }
        });

    }
    private void hideSoftKeyboard(View v){
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
    private void limpar(){
        etNome.setText("");
        etIdade.setText("");
        etEmail.setText("");
        etFone.setText("");
    }
    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
    private void init(){
        etNome = findViewById(R.id.e4_et_nome);
        etIdade = findViewById(R.id.e4_et_idade);
        etEmail = findViewById(R.id.e4_et_email);
        etFone = findViewById(R.id.e4_et_telefone);
        btCad = findViewById(R.id.e4_bt_cadastrar);
        lvContatos = findViewById(R.id.e4_lv_contatos);

        contato = new ArrayList<>();
        adapter = new ArrayAdapter<>(Ex4.this,android.R.layout.simple_list_item_1,contato);
        lvContatos.setAdapter(adapter);
    }
}

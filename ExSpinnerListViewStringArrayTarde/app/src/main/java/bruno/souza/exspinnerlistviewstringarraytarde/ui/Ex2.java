package bruno.souza.exspinnerlistviewstringarraytarde.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import bruno.souza.exspinnerlistviewstringarraytarde.R;

public class Ex2 extends AppCompatActivity {

    private ListView lvFrutas;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        init();

        lvFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fruta = parent.getItemAtPosition(position).toString();
                toast("Clicou na fruta: "+fruta);
            }
        });
        lvFrutas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String fruta = parent.getItemAtPosition(position).toString();
                toast("Clicou e segurou na fruta: "+fruta);
                return true;
            }
        });
    }
    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void init(){
        lvFrutas = findViewById(R.id.e2_lv_frutas);

        frutas = new ArrayList<>();
        frutas.add("Banana");
        frutas.add("Maçã");
        frutas.add("Limão");
        frutas.add("Laranja");
        frutas.add("Morango");

        adapter = new ArrayAdapter<>(Ex2.this,android.R.layout.simple_list_item_1,frutas);
        lvFrutas.setAdapter(adapter);
    }
}

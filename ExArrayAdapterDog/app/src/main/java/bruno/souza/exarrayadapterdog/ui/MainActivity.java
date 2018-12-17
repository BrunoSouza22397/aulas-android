package bruno.souza.exarrayadapterdog.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import bruno.souza.exarrayadapterdog.R;
import bruno.souza.exarrayadapterdog.adapters.DogAdapter;
import bruno.souza.exarrayadapterdog.model.Dog;

public class MainActivity extends AppCompatActivity {

    private EditText etRace;
    private EditText etAge;
    private Button btOK;
    private RecyclerView rvDogs;

    private ArrayList<Dog> dogs;
    private DogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dog d = new Dog();

                d.setRace(etRace.getText().toString());
                d.setAge(Integer.parseInt(etAge.getText().toString()));

                dogs.add(d);

                adapter.notifyDataSetChanged();
                toast("Dog cadastrado.");
            }
        });
        adapter.setOnItemClickListener(new DogAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                toast("Clicou");
            }

            @Override
            public void onItemLongClick(View v, int position) {
                toast("Clicou e segurou");
            }
        });
    }
    private void init(){
        etRace = findViewById(R.id.ma_et_race);
        etAge = findViewById(R.id.ma_et_age);
        btOK = findViewById(R.id.ma_bt_ok);
        rvDogs = findViewById(R.id.ma_rv_dogs);

        dogs = new ArrayList<>();
        adapter = new DogAdapter(MainActivity.this,dogs);
        rvDogs.setAdapter(adapter);
        rvDogs.setHasFixedSize(true);
        rvDogs.setLayoutManager(new LinearLayoutManager(this));
    }
    private void toast(String msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

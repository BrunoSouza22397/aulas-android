package bruno.souza.exarrayadapterdog.ui;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        //Firebase
        FirebaseApp.initializeApp(MainActivity.this);
        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference banco = db.getReference("dogs");
        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etRace.getText().toString().isEmpty()){
                    etRace.setError("Digite uma raça.");
                    return;
                }
                if (etAge.getText().toString().isEmpty()){
                    etAge.setError("Digite uma idade.");
                    return;
                }
                Dog d = new Dog();

                d.setRace(etRace.getText().toString());
                d.setAge(Integer.parseInt(etAge.getText().toString()));

//                dogs.add(d);
//                adapter.notifyDataSetChanged();
                banco.push().setValue(d);
                toast("Dog cadastrado.");
            }
        });
        banco.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dogs.clear();
                for (DataSnapshot data: dataSnapshot.getChildren()){
                    Dog d = data.getValue(Dog.class);
                    d.setKey(data.getKey());
                    dogs.add(d);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        adapter.setOnItemClickListener(new DogAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                toast("Clicou");
            }

            @Override
            public void onItemLongClick(View v, int position) {
                final Dog d = dogs.get(position);

                AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Excluir?");
                adb.setMessage("Tem certeza que quer sacrificar esse dog?");
                adb.setNegativeButton("Cancelar", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        banco.child(d.getKey()).removeValue();
                        adapter.notifyDataSetChanged();
                        toast("Dog sacrificado com sucesso! :^)");
                    }});
                adb.show();
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

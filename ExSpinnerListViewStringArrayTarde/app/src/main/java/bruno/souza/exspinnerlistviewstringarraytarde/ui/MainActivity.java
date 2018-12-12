package bruno.souza.exspinnerlistviewstringarraytarde.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import bruno.souza.exspinnerlistviewstringarraytarde.R;

public class MainActivity extends AppCompatActivity {

    private Button btEx1;
    private Button btEx2;
    private Button btEx3;
    private Button btEx4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Ex1.class));
            }
        });
        btEx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ex2.class));
            }
        });
        btEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Ex3.class));
            }
        });
        btEx4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Ex4.class));
            }
        });
    }//fecha oncreate

    private void init(){
        btEx1 = findViewById(R.id.ma_bt_ex1);
        btEx2 = findViewById(R.id.ma_bt_ex2);
        btEx3 = findViewById(R.id.ma_bt_ex3);
        btEx4 = findViewById(R.id.ma_bt_ex4);
    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}//fecha classe

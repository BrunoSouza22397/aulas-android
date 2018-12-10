package bruno.souza.exerintentimplicita.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import bruno.souza.exerintentimplicita.R;

public class MainActivity extends AppCompatActivity {
    private Button bt10;
    private Button bt20;
    private Button bt30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Tela10.class));
            }
        });
        bt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Tela20.class));
            }
        });
        bt30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Tela30.class));
            }
        });
    }
    private void initialize(){
        bt10 = findViewById(R.id.ma_bt_10);
        bt20 = findViewById(R.id.ma_bt_t20);
        bt30 = findViewById(R.id.ma_bt_t30);
    }
}

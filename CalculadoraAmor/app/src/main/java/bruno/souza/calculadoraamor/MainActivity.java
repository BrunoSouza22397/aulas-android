package bruno.souza.calculadoraamor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText etNameX;
    private EditText etNameY;
    private Button btCalc;
    private TextView tvNomeX;
    private TextView tvNomeY;
    private TextView tvPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNomeX.setText(etNameX.getText().toString());
                tvNomeY.setText(etNameY.getText().toString());
                tvPercentage.setText(String.valueOf(gerarAmor())+"%");
            }
        });
    }//fecha onCreate

    public int gerarAmor(){
        Random rand = new Random();
        return rand.nextInt(100);
    }
    public void toast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    private void initialize(){
        etNameX = findViewById(R.id.ma_et_name_x);
        etNameY = findViewById(R.id.ma_et_name_y);
        btCalc = findViewById(R.id.ma_bt_calc);
        tvNomeX = findViewById(R.id.ma_tv_name_x);
        tvNomeY = findViewById(R.id.ma_tv_name_y);
        tvPercentage = findViewById(R.id.ma_tv_percentage);
    }
}//fecha class

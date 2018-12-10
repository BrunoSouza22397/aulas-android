package bruno.souza.exerintentimplicita.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import bruno.souza.exerintentimplicita.R;

public class Tela30 extends AppCompatActivity {
    private EditText etURL;
    private Button btURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela30);
        etURL = findViewById(R.id.t30_et_url);
        btURL = findViewById(R.id.t30_bt_go);
    }
}

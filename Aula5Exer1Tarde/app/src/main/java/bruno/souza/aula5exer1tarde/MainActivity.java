package bruno.souza.aula5exer1tarde;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{

    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        bt5 = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("mensagem por OnClickListener");
            }
        });
        bt4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                toast("mensagem por OnLongClickListener");
                return true;
            }
        });
        bt5.setOnClickListener(this);
        bt6.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        toast("mesagem por implement");
    }
    @Override
    public boolean onLongClick(View v) {
        toast("mensagem por implement long click");
        return true;
    }

    public void ClickButton1(View view) {
        toast("onClick por XML");
    }

    public void ClickButton2(View view) {
        toast("onClick por XML 2");
    }

    public void toast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}

package bruno.souza.calculaterectangle.ui;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bruno.souza.calculaterectangle.R;
import bruno.souza.calculaterectangle.model.Rectangle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etWidth;
    private EditText etHeight;
    private Button btCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @Override
    public void onClick(View v) {
        Rectangle r = new Rectangle();
        r.setWidth(Double.parseDouble(etWidth.getText().toString()));
        r.setHeight(Double.parseDouble(etHeight.getText().toString()));

        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        msg.setTitle(getResources().getText(R.string.alert_title));
        msg.setMessage("Results: \nWidth: "+r.getWidth()+"\nHeight: "+r.getHeight()+calculate(r.getWidth(),r.getHeight()));
        msg.show();
    }

    private void initialize(){
        etWidth = findViewById(R.id.ma_et_width);
        etHeight = findViewById(R.id.ma_et_height);
        btCalc = findViewById(R.id.ma_bt_calculate);
        btCalc.setOnClickListener(this);
    }
    private String calculate(double w, double h){
        double area = w * h;
        double perimeter = w * 2 + h * 2;
        return "\nArea: "+area+
                "\nPerimeter: "+perimeter;
    }
}

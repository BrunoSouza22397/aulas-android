package bruno.souza.ageconversion.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import bruno.souza.ageconversion.R;
import bruno.souza.ageconversion.model.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etName;
    private EditText etAge;
    private Button btConvert;
    private TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @Override
    public void onClick(View v) {
        Person p = new Person();
        p.setName(etName.getText().toString());
        p.setAge(Integer.parseInt(etAge.getText().toString()));

        tvResults.setText("Results: \n"+p.getName()+convertAge(p.getAge()));
    }

    private void initialize(){
        etName = findViewById(R.id.ma_et_name);
        etAge = findViewById(R.id.ma_et_age);
        btConvert = findViewById(R.id.ma_bt_convert);
        tvResults = findViewById(R.id.ma_tv_results);

        btConvert.setOnClickListener(this);
    }

    public String convertAge(int v){
        int months = v * 12;
        Double weeks = v * 52.142857142857;
        int days = v * 365;
        return "\nYears: "+v+
                "\nMonths: "+months+
                "\nWeeks: "+weeks+
                "\nDays: "+days;
    }
}

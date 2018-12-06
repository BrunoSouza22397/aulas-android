package bruno.souza.calculategrades.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import bruno.souza.calculategrades.R;
import bruno.souza.calculategrades.model.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etName;
    private EditText etN1;
    private EditText etN2;
    private RadioGroup rgSex;
    private Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @Override
    public void onClick(View v) {
        //validações
        if(etName.getText().toString().isEmpty()){
            etName.setError(getResources().getText(R.string.name_error));
            return;
        }
        if(etN1.getText().toString().isEmpty()){
            etN1.setError(getResources().getText(R.string.grade_error));
            return;
        }
        if(etN2.getText().toString().isEmpty()){
            etN2.setError(getResources().getText(R.string.grade_error));
            return;
        }
        if(rgSex.getCheckedRadioButtonId() == -1){
            toast((String) String.valueOf(getResources().getText(R.string.sex_error)));
            return;
        }

        Student s = new Student();
        s.setName(etName.getText().toString());
        RadioButton rbChecked = findViewById(rgSex.getCheckedRadioButtonId());
        s.setSex(rbChecked.getText().toString());
        s.setN1(Double.parseDouble(etN1.getText().toString()));
        s.setN2(Double.parseDouble(etN2.getText().toString()));
        s.calcularMediaAritmetica(s.getN1(),s.getN2());


        toast("Results: \nStudent: "+s.getName()+"\nSex: "+s.getSex()+"\nG1: "+s.getN1()+"\nG2: "+s.getN2()+"\nFinal Grade: "+s.getNf()+"\nScore: "+s.verificarConceito(s.getNf()));
    }
    
    public void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
    private void initialize(){
        etName = findViewById(R.id.ma_et_name);
        etN1 = findViewById(R.id.ma_et_n1);
        etN2 = findViewById(R.id.ma_et_n2);
        rgSex = findViewById(R.id.ma_rg_sex);
        btRegister = findViewById(R.id.ma_bt_register);
        btRegister.setOnClickListener(this);
    }
}

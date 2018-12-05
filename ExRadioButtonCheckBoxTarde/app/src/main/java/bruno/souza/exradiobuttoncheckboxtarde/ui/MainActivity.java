package bruno.souza.exradiobuttoncheckboxtarde.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import bruno.souza.exradiobuttoncheckboxtarde.R;
import bruno.souza.exradiobuttoncheckboxtarde.model.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Widgets
    private EditText etName;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RadioGroup rgGender;
    private CheckBox cbAnime;
    private CheckBox cbManga;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }//close onCreate
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ma_bt_add:
                Person p = new Person();
                p.setName(etName.getText().toString());

                if(rgGender.getCheckedRadioButtonId() == rbMale.getId()){
                    p.setGender(rbMale.getText().toString());
                }else if(rgGender.getCheckedRadioButtonId() == rbFemale.getId()){
                    p.setGender(rbFemale.getText().toString());
                }

                ArrayList<String> prefs = new ArrayList<>();
                if(cbAnime.isChecked()){
                    prefs.add(cbAnime.getText().toString());
                }
                if(cbManga.isChecked()){
                    prefs.add(cbManga.getText().toString());
                }
                p.setPrefs(prefs);
                toast(p.toString());
                break;
        }
    }

    public void toast(String msg){
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }

    private void initialize(){
        etName = findViewById(R.id.ma_et_name);
        rbMale = findViewById(R.id.ma_rb_male);
        rbFemale = findViewById(R.id.ma_rb_female);
        rgGender = findViewById(R.id.ma_rg_gender);
        cbAnime = findViewById(R.id.ma_cb_anime);
        cbManga = findViewById(R.id.ma_cb_manga);
        btAdd = findViewById(R.id.ma_bt_add);

        btAdd.setOnClickListener(this);
    }
}//close Class

package net.centricdata.agricura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    CheckBox maize, sugarCane, soyaBeans, tobacco, tea, macademia, avocado, other;
    TextView fullName, mobile, email;
    ArrayList<String> crops = new ArrayList<>();
    int count = 0;

    Button btn_saveFormDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        fullName = (TextView) findViewById(R.id.EditTextFullname);
        mobile = (TextView) findViewById(R.id.EditTextMobile);
        email = (TextView) findViewById(R.id.EditTextEmail);

        maize = (CheckBox) findViewById(R.id.chkMaize);
        sugarCane = (CheckBox) findViewById(R.id.chkSugarCane);
        soyaBeans = (CheckBox) findViewById(R.id.chkSoyaBean);
        tobacco = (CheckBox) findViewById(R.id.chkTobacco);
        tea = (CheckBox) findViewById(R.id.chkTea);
        macademia = (CheckBox) findViewById(R.id.chkMacademia);
        avocado = (CheckBox) findViewById(R.id.chkAvocado);
        other = (CheckBox) findViewById(R.id.chkOther);


        btn_saveFormDetails = (Button) findViewById(R.id.btn_saveFormDetails);

        btn_saveFormDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this   ,"todo: add save details functionality",Toast.LENGTH_SHORT).show();
                Intent main = new Intent(LoginActivity.this, MainActivity.class);
                main.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                finish();
            }
        });

    }




    public void add_crop_preferences() {
        //String result = "";
        //crops.add(result);

        if (maize.isChecked()) {
            // result += "\nMaize";
            crops.add("Maize");
            //crops.remove("Maize");
        }
        if (sugarCane.isChecked()) {
            //result += "\nSugar Cane";
            crops.add("Sugar Cane");
        }
        if (soyaBeans.isChecked()) {
            //result += "\nSoya Beans";
            crops.add("Soya Beans");
        }
        if (tobacco.isChecked()) {
            //result += "\nTobacco";
            crops.add("Tobacco");
        }
        if (tea.isChecked()) {
            //result += "\nTea";
            crops.add("Tea");
        }
        if (macademia.isChecked()) {
            //result += "\nMacademia";
            crops.add("Macademia");
        }
        if (avocado.isChecked()) {
            //result += "\nAvocado";
            crops.add("Avocado");
        }
        if (other.isChecked()) {
            //result += "\nOther";
            crops.add("Other");
        }

        String myCropString = crops.toString();
    }





}
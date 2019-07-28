package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import net.centricdata.agricura.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyAccountFragment extends Fragment {


    public MyAccountFragment() {
        // Required empty public constructor
    }
CheckBox maize, sugarCane, soyaBeans, tobacco, tea, macademia, avocado, other;
 TextView fullName, mobile, email;
 ArrayList<String> crops = new ArrayList<>();
int count =0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        getActivity().setTitle("My Account");
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);

        fullName = (TextView) view.findViewById(R.id.EditTextFullname);
        mobile = (TextView) view.findViewById(R.id.EditTextMobile);
        email = (TextView) view.findViewById(R.id.EditTextEmail);

        maize = (CheckBox) view.findViewById(R.id.chkMaize);
        sugarCane = (CheckBox) view.findViewById(R.id.chkSugarCane);
        soyaBeans = (CheckBox) view.findViewById(R.id.chkSoyaBean);
        tobacco = (CheckBox) view.findViewById(R.id.chkTobacco);
        tea = (CheckBox) view.findViewById(R.id.chkTea);
        macademia = (CheckBox) view.findViewById(R.id.chkMacademia);
        avocado = (CheckBox) view.findViewById(R.id.chkAvocado);
        other = (CheckBox) view.findViewById(R.id.chkOther);

        Button btn = (Button) view.findViewById(R.id.btn_saveFormDetails);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Toast.makeText(getActivity().getApplicationContext(), myCropString, Toast.LENGTH_SHORT).show();
            }
        });



      return view;

    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str="";
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.chkMaize:
                str = checked?"Maize Selected":"Maize Deselected";
                break;
            case R.id.chkSugarCane:
                str = checked?"Sugar Cane Selected":"Sugar Cane Deselected";
                break;
            case R.id.chkSoyaBean:
                str = checked?"Soya Bean Selected":"Soya Bean Deselected";
                break;
            case R.id.chkTobacco:
                str = checked?"Tobacco Selected":"Tobacco Deselected";
                break;
            case R.id.chkTea:
                str = checked?"Tea Selected":"Tea Deselected";
                break;
            case R.id.chkMacademia:
                str = checked?"Macademia Selected":"Macademia Deselected";
                break;
            case R.id.chkAvocado:
                str = checked?"Avocado Selected":"Avocado Deselected";
                break;
        }
        Toast.makeText(getActivity().getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}

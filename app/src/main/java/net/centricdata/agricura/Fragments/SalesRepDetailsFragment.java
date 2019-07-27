package net.centricdata.agricura.Fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.centricdata.agricura.App;
import net.centricdata.agricura.Models.SalesTeam;
import net.centricdata.agricura.R;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import daoModels.DaoSession;
import daoModels.SalesTeamDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalesRepDetailsFragment extends Fragment {

    private  final int MY_PERM_PHONE_CALL =  100;
    private Integer salesId = 0 ;

    TextView sBranch, sName, sTel, sEmail, sAddress;


    String salesKey;

    Query<SalesTeam> salesTeamQuery;
    SalesTeamDao salesTeamDao;
    SalesTeam salesTeam;

    String screenTittle = "";
    String branch = "";
    String email = "";
    String telephone = "";
    String address = "";


    public SalesRepDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sales_rep_details, container, false);

        DaoSession daoSession = App.getInstance().getDaoSession();
        salesTeamDao = daoSession.getSalesTeamDao();

        sName = view.findViewById(R.id.txtSNameP);
        sBranch = view.findViewById(R.id.txtSBranch);
        //sAddress = view.findViewById(R.id.txtSAdd);
        sEmail = view.findViewById(R.id.txtSEmail);
        sTel = view.findViewById(R.id.txtSTel);

        salesKey = getArguments().getString("salesID");

        salesId = Integer.valueOf(salesKey) + 1;

        salesTeam = new SalesTeam();

        salesTeamQuery = salesTeamDao.queryBuilder().where(SalesTeamDao.Properties.SalesID.eq(salesId)).build();

        List<SalesTeam> salesRepDetails = salesTeamQuery.list();



        screenTittle = salesRepDetails.get(0).salesPerson;
        branch = salesRepDetails.get(0).salesBranch;
        email = salesRepDetails.get(0).salesEmail;
        telephone = salesRepDetails.get(0).salesPersonTel;



        getActivity().setTitle(screenTittle);

        sName.setText(screenTittle);
        sBranch.setText(branch);
        //sAddress.setText(salesRepDetails.get(0).sa);
        sTel.setText(telephone);
        sEmail.setText(email);


        sTel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+ telephone));

                        if(permCheck()){
                            try {
                                startActivity(callIntent);
                            }catch (android.content.ActivityNotFoundException ex){
                                Toast.makeText(getActivity().getBaseContext(), "Request Failed.. Please try again", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
        );

        sEmail.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Email= String.valueOf(sEmail);
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + Email));
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Agricura Mobile App");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
//emailIntent.putExtra(Intent.EXTRA_HTML_TEXT, body); //If you are using HTML in your body text
                        startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
                    }
                });



        return view;
    }

    private boolean permCheck(){
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
            return true;
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CALL_PHONE)){
            Toast.makeText(getActivity().getBaseContext(), "Please enable call permission in your settings", Toast.LENGTH_LONG).show();
            return false;
        }else {

            requestPermissions(
                    new String[]{Manifest.permission.CALL_PHONE}, MY_PERM_PHONE_CALL);

                    return true;


        }
    }

}

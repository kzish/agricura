package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    private Integer salesId = 0 ;

    TextView sBranch, sName, sTel, sEmail, sAddress;


    String salesKey;

    Query<SalesTeam> salesTeamQuery;
    SalesTeamDao salesTeamDao;
    SalesTeam salesTeam;


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

        sName = view.findViewById(R.id.txtSalesRep);
        sBranch = view.findViewById(R.id.txtSBranch);
        sAddress = view.findViewById(R.id.txtSAdd);
        sEmail = view.findViewById(R.id.txtSEmail);
        sTel = view.findViewById(R.id.txtSTel);

        salesKey = getArguments().getString("salesID");

        salesId = Integer.valueOf(salesKey) + 1;

        salesTeam = new SalesTeam();

        salesTeamQuery = salesTeamDao.queryBuilder().where(SalesTeamDao.Properties.SalesID.eq(salesId)).build();

        List<SalesTeam> salesRepDetails = salesTeamQuery.list();

        String screenTittle = "";

        screenTittle = salesRepDetails.get(0).salesPerson;



        getActivity().setTitle(screenTittle);

        sName.setText(salesRepDetails.get(0).getSalesPerson());
        /*sBranch.setText(salesRepDetails.get(0).getSalesBranch());
        //sAddress.setText(salesRepDetails.get(0).sa);
        sTel.setText(salesRepDetails.get(0).getSalesPersonTel());
        sEmail.setText(salesRepDetails.get(0).getSalesEmail());*/



        return view;
    }

}

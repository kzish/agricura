package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.centricdata.agricura.Adapters.SalesAdapter;
import net.centricdata.agricura.App;
import net.centricdata.agricura.Models.SalesTeam;
import net.centricdata.agricura.R;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

import daoModels.DaoSession;
import daoModels.SalesTeamDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalesTeamFragment extends Fragment {

    RecyclerView salesRecycle;
    SalesAdapter salesAdapter;

    SalesTeamDao salesTeamDao;
    Query<SalesTeam> salesTeamQuery;

    List<SalesTeam> salesTeamList;
    ArrayList<SalesTeamDao> salez = new ArrayList<>();

    SalesTeam salesTeam;


    public SalesTeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        getActivity().setTitle("Sales Team");
        View view = inflater.inflate(R.layout.fragment_sales_team, container, false);

        DaoSession daoSession = App.getInstance().getDaoSession();
        salesTeamDao = daoSession.getSalesTeamDao();

        addSalesTeam();

        salesTeamQuery = salesTeamDao.queryBuilder().build();

        salesTeamList =salesTeamQuery.list();

        salesRecycle = view.findViewById(R.id.recycle_sales);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        salesRecycle.setLayoutManager(layoutManager);

        salesAdapter = new SalesAdapter((ArrayList<SalesTeam>) salesTeamList);


        salesRecycle.setAdapter(salesAdapter);


        return view;
    }

    private void addSalesTeam() {

        //salesTeamList.clear();

        SalesTeam salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Sales Manager");
        salesTeam.setSalesBranch("Harare Head Office");
        salesTeam.setSalesPersonTel("0772407879");
        salesTeam.setSalesEmail("bongayi.gokoma@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Agronomist ");
        salesTeam.setSalesBranch("Harare Head Office");
        salesTeam.setSalesPersonTel("0774901767");
        salesTeam.setSalesEmail("onias.mlambo@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);
    }

}

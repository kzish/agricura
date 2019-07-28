package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
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

        //addSalesTeam();

        salesTeamQuery = salesTeamDao.queryBuilder().build();

        salesTeamList =salesTeamQuery.list();

        if(salesTeamList.size()<=0){
            addSalesTeam();
            salesTeamList =salesTeamQuery.list();

        }else{
            Log.i( "size", String.valueOf(salesTeamList.size()));
        };

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
        //salesTeam.salesContact("No. 62 Birmingham Road P.O Box 2742 Southerton, Harare.");
        salesTeam.setSalesPersonTel("0772407879");
        salesTeam.setSalesEmail("agricura@agricura.co.zw ");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Agronomist ");
        salesTeam.setSalesBranch("Harare Head Office");
        salesTeam.setSalesPersonTel("0774901767");
        salesTeam.setSalesEmail("agricura@agricura.co.zw ");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Corporate Sales");
        salesTeam.setSalesBranch("Harare Head Office");
        salesTeam.setSalesPersonTel("0773434200");
        salesTeam.setSalesEmail("agricura@agricura.co.zw ");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Naomi");
        salesTeam.setSalesBranch("Harare Street Branch");
        salesTeam.setSalesPersonTel("0718861765");
        salesTeam.setSalesEmail("nmhlanga3@gmail.com");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Chris");
        salesTeam.setSalesBranch("Marondera Branch");
        salesTeam.setSalesPersonTel("0772659129");
        salesTeam.setSalesEmail("cchandi.chandirekera@gmail.com");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Wilbroad");
        salesTeam.setSalesBranch("Marondera Branch");
        salesTeam.setSalesPersonTel("0772587350");
        salesTeam.setSalesEmail("wilbroad.kudangirana@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Wilbroad");
        salesTeam.setSalesBranch("Marondera Branch");
        salesTeam.setSalesPersonTel("0772587350");
        salesTeam.setSalesEmail("wilbroad.kudangirana@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Munyaradzi");
        salesTeam.setSalesBranch("Bulawayo Branch");
        salesTeam.setSalesPersonTel("0772674050");
        salesTeam.setSalesEmail("munyaradzi.nyika@yahoo.com");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Tonderai ");
        salesTeam.setSalesBranch("Chinhoyi Branch");
        salesTeam.setSalesPersonTel("0717043578 ");
        salesTeam.setSalesEmail("tonderai.mutara@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Knight ");
        salesTeam.setSalesBranch("Chinhoyi Branch");
        salesTeam.setSalesPersonTel("0772556781");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mr Chiutsi");
        salesTeam.setSalesBranch("Chegutu Branch");
        salesTeam.setSalesPersonTel("0772884310");
        salesTeam.setSalesEmail("tonderai.mutara@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mhangura Sales Rep");
        salesTeam.setSalesBranch("Mhangura Branch");
        salesTeam.setSalesPersonTel("0773085594");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Chipinge Sales Rep");
        salesTeam.setSalesBranch("Chipinge Branch");
        salesTeam.setSalesPersonTel("0717996673");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mount Darwin Sales Rep");
        salesTeam.setSalesBranch("Mount Darwin Branch");
        salesTeam.setSalesPersonTel("0772725819");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mr Mupawaenda");
        salesTeam.setSalesBranch("Mvurwi Branch");
        salesTeam.setSalesPersonTel("0772848149");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mr Bvudzijena");
        salesTeam.setSalesBranch("Masvingo Branch");
        salesTeam.setSalesPersonTel("0773228294");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mrs Bvudzijena");
        salesTeam.setSalesBranch("Masvingo Branch");
        salesTeam.setSalesPersonTel("0775498800");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mutare Sales Rep");
        salesTeam.setSalesBranch("Mutare Branch");
        salesTeam.setSalesPersonTel("0773427570");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Karoi  Sales Rep");
        salesTeam.setSalesBranch("Karoi  Branch");
        salesTeam.setSalesPersonTel("0712119463");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Mr Chiutsi");
        salesTeam.setSalesBranch("Kadoma  Branch");
        salesTeam.setSalesPersonTel("0772884310");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Chiredzi Sales Rep");
        salesTeam.setSalesBranch("Chiredzi Branch");
        salesTeam.setSalesPersonTel("0772720869");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Guruve Sales Rep");
        salesTeam.setSalesBranch("Guruve Branch");
        salesTeam.setSalesPersonTel("0732620366");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);

        salesTeam = new SalesTeam();
        salesTeam.setSalesPerson("Glendale Sales Rep");
        salesTeam.setSalesBranch("Glendale Branch");
        salesTeam.setSalesPersonTel("0772375583");
        salesTeam.setSalesEmail("agricura@agricura.co.zw");
        salesTeamDao.insertOrReplaceInTx(salesTeam);
    }

}

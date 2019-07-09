package net.centricdata.agricura.Fragments;


import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import net.centricdata.agricura.Adapters.BranchesAdapter;
import net.centricdata.agricura.App;
import net.centricdata.agricura.Models.Branches;
import net.centricdata.agricura.R;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

import daoModels.BranchesDao;
import daoModels.DaoSession;

/**
 * A simple {@link Fragment} subclass.
 */
public class BranchesFragment extends Fragment {

    RecyclerView branchesRecycleview;
    BranchesAdapter branchesAdapter;

    private BranchesDao branchesDao;
    private Query<Branches> branchesQuery;


    ArrayList<BranchesDao> branches = new ArrayList<>();

    List<Branches> branchesList;



    public BranchesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Our Branches");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_branches, container, false);

        DaoSession daoSession = App.getInstance().getDaoSession();
        branchesDao =  daoSession.getBranchesDao();

        //


        branchesQuery = branchesDao.queryBuilder().build();


        branchesList = branchesQuery.list();

        if(branchesList.size()<=0){
            addBranches();

        }else{
            Log.i( "size", String.valueOf(branchesList.size()));
        };

        //Log.e("List", String.valueOf(branchesQuery));

        branchesRecycleview = view.findViewById(R.id.reclycleview_branches);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        branchesRecycleview.setLayoutManager(layoutManager);

       branchesAdapter = new BranchesAdapter((ArrayList<Branches>) branchesList);






        branchesRecycleview.setAdapter(branchesAdapter);




        return view;
    }



    void addBranches() {
        //branches.clear();

        Branches myBranches = new Branches();
        myBranches.setBranchName("Harare (Southerton)");
        myBranches.setBranchAddress("62 Birmingham Road, Southerton, Harare, Zimbabwe");
        branchesDao.insert(myBranches);
        Log.d("dataDB","Inserted new note, ID: " + myBranches.getBranchID() + myBranches.getBranchName() );

        myBranches = new Branches();
        myBranches.setBranchName("Norton");
        myBranches.setBranchAddress("Norton, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Glendale");
        myBranches.setBranchAddress("Shop No. 2 Glendale Main Square, Glendale, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Bindura");
        myBranches.setBranchAddress("No. 758 TM Area, Bindura, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Marondera");
        myBranches.setBranchAddress("No. 45 Chicago Drive, Marondera, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Shamva");
        myBranches.setBranchAddress("Shamva, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mvurwi");
        myBranches.setBranchAddress("No. 23 Hands worth township, Mvurwi, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chegutu");
        myBranches.setBranchAddress("No. 26 Abercon Street, Chegutu, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chinhoyi");
        myBranches.setBranchAddress("No. 14 Park Street, Chinhoyi, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Kadoma");
        myBranches.setBranchAddress("No. 2580 J. Tongogara Road, Kadoma, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mt Darwin");
        myBranches.setBranchAddress("No. 109 Hospital Road, Mt Darwin, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Guruve");
        myBranches.setBranchAddress("No. 82 Guruve Growth Point,Guruve, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mhangura");
        myBranches.setBranchAddress("No. 26 Abercon Street, Mhangura, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Karoi");
        myBranches.setBranchAddress("No. 316 Industrial Site, Karoi, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Magunje");
        myBranches.setBranchAddress("Magunje, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mutare");
        myBranches.setBranchAddress("No. 13 Chipanda Street, Murare, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Masvingo");
        myBranches.setBranchAddress("No. 46 Greenfields Road, Masvingo, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chipinge");
        myBranches.setBranchAddress("No. 326 Gaza Eastern Road, Chipinge, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Bulawayo");
        myBranches.setBranchAddress("No. 60 George Silundika Avenue, Bulawayo, Zimbabwe");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chiredzi");
        myBranches.setBranchAddress("No. 355 Chilonga Drive, Chiredzi, Zimbabwe");
        branchesDao.insert(myBranches);
    }

}

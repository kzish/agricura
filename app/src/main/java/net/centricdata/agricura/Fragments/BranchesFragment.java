package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
            branchesList = branchesQuery.list();

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
        myBranches.setBranchLatitude(-17.852916);
        myBranches.setBranchLongitude(31.025923);
        myBranches.setBranchTelephone("0772407879");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Glendale");
        myBranches.setBranchAddress("Shop No. 2 Glendale Main Square, Glendale, Zimbabwe");
        myBranches.setBranchLatitude(-17.359957);
        myBranches.setBranchLongitude(31.061336);
        myBranches.setBranchTelephone("0772375583");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Bindura");
        myBranches.setBranchAddress("49 Robert Mugabe Way, Bindura, Zimbabwe");
        myBranches.setBranchLatitude(-17.308309);
        myBranches.setBranchLongitude(31.335141);
        myBranches.setBranchTelephone("0777170565");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Marondera");
        myBranches.setBranchAddress("No. 45 Chicago Drive, Marondera, Zimbabwe");
        myBranches.setBranchLatitude(-18.185628);
        myBranches.setBranchLongitude(31.537310);
        myBranches.setBranchTelephone("0772587350");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Shamva");
        myBranches.setBranchAddress("36 Wadzanai Street, Shamva, Zimbabwe");
        myBranches.setBranchLatitude(-17.297546);
        myBranches.setBranchLongitude(31.568438);
        myBranches.setBranchTelephone("0772594738");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mvurwi");
        myBranches.setBranchAddress("No. 23 Hands worth township, Mvurwi, Zimbabwe");
        myBranches.setBranchLatitude(-17.031867);
        myBranches.setBranchLongitude(30.850957);
        myBranches.setBranchTelephone("0772848149");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chegutu");
        myBranches.setBranchAddress("No. 26 Abercon Street, Chegutu, Zimbabwe");
        myBranches.setBranchLatitude(-18.132765);
        myBranches.setBranchLongitude(30.143719);
        myBranches.setBranchTelephone("0712799029");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chinhoyi");
        myBranches.setBranchAddress("No. 14 Park Street, Chinhoyi, Zimbabwe");
        myBranches.setBranchLatitude(-17.360065);
        myBranches.setBranchLongitude(30.199351);
        myBranches.setBranchTelephone("0772556781");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Kadoma");
        myBranches.setBranchAddress("No. 2580 J. Tongogara Road, Kadoma, Zimbabwe");
        myBranches.setBranchLatitude(-18.348644);
        myBranches.setBranchLongitude(29.910354);
        myBranches.setBranchTelephone("0773541388");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mt Darwin");
        myBranches.setBranchAddress("No. 109 Hospital Road, Mt Darwin, Zimbabwe");
        myBranches.setBranchLatitude(-16.775939);
        myBranches.setBranchLongitude(31.579448);
        myBranches.setBranchTelephone("0772725819");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Guruve");
        myBranches.setBranchAddress("No. 82 Guruve Growth Point,Guruve, Zimbabwe");
        myBranches.setBranchLatitude(-16.659591);
        myBranches.setBranchLongitude(30.698039);
        myBranches.setBranchTelephone("0732620366");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mhangura");
        myBranches.setBranchAddress("49 Chebanga Rd, Mhangura, Zimbabwe");
        myBranches.setBranchLatitude(-16.89685);
        myBranches.setBranchLongitude(30.1515909);
        myBranches.setBranchTelephone("0773085594");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Karoi");
        myBranches.setBranchAddress("116 Industrial Site, Karoi, Zimbabwe");
        myBranches.setBranchLatitude(-16.819611);
        myBranches.setBranchLongitude(29.690877);
        myBranches.setBranchTelephone("0772585898");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Magunje");
        myBranches.setBranchAddress("Magunje, Zimbabwe");
        myBranches.setBranchLatitude(-17.878060);
        myBranches.setBranchLongitude(30.676410);
        myBranches.setBranchTelephone("0773085594");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Mutare");
        myBranches.setBranchAddress("No. 13 Chipanda Street, Murare, Zimbabwe");
        myBranches.setBranchLatitude(-18.9735667);
        myBranches.setBranchLongitude(32.6596313);
        myBranches.setBranchTelephone("0773427570");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Masvingo");
        myBranches.setBranchAddress("No. 46 Greenfields Road, Masvingo, Zimbabwe");
        myBranches.setBranchLatitude(-20.0729395);
        myBranches.setBranchLongitude(30.8085373);
        myBranches.setBranchTelephone("0775498800");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chipinge");
        myBranches.setBranchAddress("No. 326 Gaza Eastern Road, Chipinge, Zimbabwe");
        myBranches.setBranchLatitude(-20.1915765);
        myBranches.setBranchLongitude(32.6170626);
        myBranches.setBranchTelephone("0717996673");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Bulawayo");
        myBranches.setBranchAddress("No. 60 George Silundika Avenue, Bulawayo, Zimbabwe");
        myBranches.setBranchLatitude(-20.149834);
        myBranches.setBranchLongitude(28.587359);
        myBranches.setBranchTelephone("0772407879");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Gweru");
        myBranches.setBranchAddress("50 Robert Mugabe Way, Gweru, Zimbabwe");
        myBranches.setBranchLatitude(-19.451607);
        myBranches.setBranchLongitude(29.815628);
        myBranches.setBranchTelephone("0773756706");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Harare Street");
        myBranches.setBranchAddress("58 Harare Street, Harare, Zimbabwe");
        myBranches.setBranchLatitude(-17.838790);
        myBranches.setBranchLongitude(31.041263);
        myBranches.setBranchTelephone("0773443017");
        branchesDao.insert(myBranches);

        myBranches = new Branches();
        myBranches.setBranchName("Chiredzi");
        myBranches.setBranchAddress("No. 355 Chilonga Drive, Chiredzi, Zimbabwe");
        myBranches.setBranchLatitude(-21.0398425);
        myBranches.setBranchLongitude(31.6573619);
        myBranches.setBranchTelephone("0713011934");
        branchesDao.insert(myBranches);
    }

}

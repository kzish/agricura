package net.centricdata.agricura.Fragments;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import net.centricdata.agricura.App;
import net.centricdata.agricura.Models.Branches;
import net.centricdata.agricura.R;

import org.greenrobot.greendao.query.Query;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import daoModels.BranchesDao;
import daoModels.DaoSession;

/**
 * A simple {@link Fragment} subclass.
 */
public class BranchDetailsFragment extends Fragment {

    private MapView mMapView;
    private SupportMapFragment googleMap;
    SupportMapFragment mapFragment;

    //private SupportMapFragment mapFragment;

    private Integer branchId = 0 ;

    TextView bAddress, bName;


    String branchKey;
    BranchesFragment ourBranches;
    //ArrayList<Branches> branches = new ArrayList<>();

    Query<Branches> branchesQuery;
    BranchesDao branchesDao;
    Branches branches;

    //Branches branches;

    //geocoder = new google.maps.Geocoder();



    public BranchDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_branch_details, container, false);

        googleMap  = ((SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.myMap));

        bAddress = view.findViewById(R.id.txtBranchA);
        bName = view.findViewById(R.id.txtBranchN);

        DaoSession daoSession = App.getInstance().getDaoSession();
        branchesDao =  daoSession.getBranchesDao();

        branchKey = getArguments().getString("branchID");

        branchId = Integer.valueOf(branchKey) + 1;

        branches = new Branches();

        branchesQuery = branchesDao.queryBuilder().where(BranchesDao.Properties.BranchID.eq(branchId )).build();

        List<Branches> branchesNameDetail = branchesQuery.list();

         final String b;

         b = branchesNameDetail.get(0).branchName;

//         branch = branchesNameDetail.get(Integer.parseInt(branchKey)).getBranchName();

         Log.d("branchdetailsSize", String.valueOf(branchesNameDetail.size()));
         Log.d("branchkey", String.valueOf(branchId));
            Log.d("branchdetails", String.valueOf(branchesNameDetail));
            Log.d("branchkeyName", b);



        getActivity().setTitle(b + " Details");

        bName.setText(branchesNameDetail.get(0).getBranchName());
        bAddress.setText(branchesNameDetail.get(0).getBranchAddress());

        Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
           List<Address> addressList = geocoder.getFromLocationName(b, 1);
           if(addressList.size()>0){

           }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Log.e("listarray", address);

        // Remove old code
        // SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        // don't recreate fragment everytime ensure last map location/state are maintained
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    LatLng latLng = new LatLng(-17.8165877, 30.916772);
                    //Address address = b;

                    googleMap.addMarker(new MarkerOptions().position(latLng)
                            .title(b));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 9));
                    googleMap.getMaxZoomLevel();
                }
            });
        }

        // R.id.map is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.myMap, mapFragment).commit();









        return view;

    }

}

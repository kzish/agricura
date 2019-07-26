package net.centricdata.agricura.Fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private  final int MY_PERM_PHONE_CALL =  100;

    TextView bAddress, bName, bEmail;
    Double latitude, longitude;
    String bPhone = "";
    Button callMe;

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

        latitude = 0.00000;
        longitude = 0.0000;

        bAddress = view.findViewById(R.id.txtBranchA);
        bName = view.findViewById(R.id.txtBranchN);
        bEmail = view.findViewById(R.id.txtbEmail);
        callMe = view.findViewById(R.id.btnCallBranch);

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
        bEmail.setText("agricura@agricura.co.zw");
        longitude = branchesNameDetail.get(0).branchLongitude;
        latitude = branchesNameDetail.get(0).branchLatitude;
        bPhone = branchesNameDetail.get(0).branchTelephone;

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
                    LatLng latLng = new LatLng(latitude, longitude);
                    //Address address = b;

                    googleMap.addMarker(new MarkerOptions().position(latLng)
                            .title(b));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                    googleMap.getMaxZoomLevel();
                }
            });
        }

        // R.id.map is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.myMap, mapFragment).commit();

        callMe.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:"+ bPhone));

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

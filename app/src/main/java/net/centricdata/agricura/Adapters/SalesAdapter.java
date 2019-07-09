package net.centricdata.agricura.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.centricdata.agricura.Fragments.SalesRepDetailsFragment;
import net.centricdata.agricura.Models.SalesTeam;
import net.centricdata.agricura.R;

import java.util.ArrayList;
import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SalesViewHolder> {

    ArrayList<SalesTeam> salesTeams;
    Context ctx;

    public SalesAdapter(ArrayList<SalesTeam> salesTeams, Context ctx) {
        this.salesTeams = salesTeams;
        this.ctx = ctx;
    }

    public SalesAdapter(ArrayList<SalesTeam> salesTeams) {
        this.salesTeams = salesTeams;
    }

    public SalesAdapter(List<SalesTeam> salesTeamList) {
    }

    @NonNull
    @Override
    public SalesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_sales, viewGroup,false);
        return new  SalesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesViewHolder salesViewHolder, final int position) {

        salesViewHolder.salesLoc.setText(salesTeams.get(position).getSalesBranch());
        salesViewHolder.salesRep.setText(salesTeams.get(position).getSalesPerson());

        salesViewHolder.salesCard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppCompatActivity activity = (AppCompatActivity) v.getContext();

                        //Log.e("position", String.valueOf(position));
                        final  String salesKey = String.valueOf(position)  ;
                        //Log.e("salesID", salesKey);

                        Bundle bundle = new Bundle();
                        bundle.putString("salesID" ,salesKey );

                        Fragment fragment = new SalesRepDetailsFragment();

                        fragment.setArguments(bundle);


                        FragmentTransaction ft =  activity.getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack("salesReps");
                        ft.commit();
                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return salesTeams.size();
    }

    public class SalesViewHolder extends RecyclerView.ViewHolder{

        TextView salesRep;
        TextView salesLoc;
        CardView salesCard;



        public SalesViewHolder(@NonNull View itemView) {
            super(itemView);

            View myView = itemView;

            salesRep = myView.findViewById(R.id.txtSalesRep);
            salesLoc = myView.findViewById(R.id.txtSalesLocation);
            salesCard = myView.findViewById(R.id.card_sales_team);


        }
    }
}

package net.centricdata.agricura.Adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.centricdata.agricura.App;
import net.centricdata.agricura.Fragments.BranchDetailsFragment;
import net.centricdata.agricura.Models.Branches;
import net.centricdata.agricura.R;

import java.util.ArrayList;

public class BranchesAdapter extends RecyclerView.Adapter<BranchesAdapter.BranchesViewHolder> {


    public BranchesAdapter(Context ctx, ArrayList<Branches> branches) {
        this.ctx = ctx;
        this.branches = branches;
    }

    Context ctx;
    ArrayList<Branches> branches;

    public BranchesAdapter(ArrayList<Branches> branches) {

        this.branches = branches;
    }

    @NonNull
    @Override
    public BranchesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_branches, viewGroup, false);
        return new BranchesViewHolder(v);
    }

    @Override
    public long getItemId(int position) {
        super.getItemId(position);
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull final BranchesViewHolder branchesViewHolder, final int position) {

        branchesViewHolder.bAddress.setText(branches.get(position).getBranchAddress());
        branchesViewHolder.bName.setText(branches.get(position).getBranchName());

        if(position%2==0) {
            branchesViewHolder.bg_lay.setBackgroundColor(App.getInstance().getResources().getColor(R.color.verylightGreen));
        }else
        {
            branchesViewHolder.bg_lay.setBackgroundColor(App.getInstance().getResources().getColor(R.color.backgroundcalaz));
        }

        branchesViewHolder.cardViewBranch.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        AppCompatActivity activity = (AppCompatActivity) v.getContext();

                        Log.e("position", String.valueOf(position));
                        final String branchKey = String.valueOf(position);
                        Log.e("branchID", branchKey);

                        Bundle bundle = new Bundle();
                        bundle.putString("branchID", branchKey);
                        //bundle.putDouble("lat");

                        Fragment fragment = new BranchDetailsFragment();

                        fragment.setArguments(bundle);


                        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.content_main, fragment);
                        ft.addToBackStack("branches");
                        ft.commit();
                    }
                }
        );

    }


    @Override
    public int getItemCount() {
        return branches.size();
    }

    public class BranchesViewHolder extends RecyclerView.ViewHolder {

        TextView bName;
        TextView bAddress;
        CardView cardViewBranch;
        public LinearLayout bg_lay;

        public BranchesViewHolder(@NonNull View itemView) {

            super(itemView);

            View myView = itemView;

            bName = myView.findViewById(R.id.txt_branchname);
            bAddress = myView.findViewById(R.id.txt_branchadd);
            cardViewBranch = myView.findViewById(R.id.card_branch);
            bg_lay = (LinearLayout) myView.findViewById(R.id.bg_lay);


        }


    }
}
package net.centricdata.agricura.ViewHolders;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.centricdata.agricura.R;

public class BranchesViewHolder extends RecyclerView.ViewHolder {

    TextView bName;
    TextView bAddress;

    public BranchesViewHolder(@NonNull View itemView) {

    super(itemView);

    View myView = itemView;

    bName =  myView.findViewById(R.id.txt_branchname);
    bAddress = myView.findViewById(R.id.txt_branchadd);

    }
}

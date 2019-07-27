package net.centricdata.agricura.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import net.centricdata.agricura.Fragments.InputsFragment;
import net.centricdata.agricura.Fragments.OutputsFragment;
import net.centricdata.agricura.Fragments.StatementFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                InputsFragment inputsFragment= new InputsFragment();
                return inputsFragment;
            case 1:
                OutputsFragment outputsFragment= new OutputsFragment();
                return outputsFragment;
            case 2:
                StatementFragment statementFragment = new StatementFragment();
                return statementFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
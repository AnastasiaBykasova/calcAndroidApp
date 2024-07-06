package com.example.lab6_7_2calcTabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {
    public MyAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return CalcFragment.newInstance(position);
            case 1:
                return AppInfoFragment.newInstance(position);
            case 2:
                return AuthorInfoFragment.newInstance(position);
            default:
                return CalcFragment.newInstance(0);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

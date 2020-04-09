package com.gocorona.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.gocorona.R;
import com.gocorona.fragments.AppBaseFragment;
import com.gocorona.fragments.MapViewFragment;
import com.gocorona.fragments.QuestionsMainFargment;
import com.google.android.gms.maps.GoogleMap;

import java.util.Map;


public class HomeFragment extends AppBaseFragment {

//    private HomeViewModel homeViewModel;

 //public View onCreateView(@NonNull LayoutInflater inflater,
   //                          ViewGroup container, Bundle savedInstanceState) {
     //        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }

    @Override
    public void initViews() {

        addFragment(new MapViewFragment(), true);
        setOnClickListener(R.id.mylocation);
    }

    public void addFragment(Fragment fragment, boolean b) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        }
        if (b) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.replace(R.id.fragmentmapcontainer,fragment).commit();

    }

    @Override
    public void onClick(View v) {

        super.onClick(v);
        switch (v.getId()) {
            case R.id.mylocation:

                showToast("FAButton");
                break;

        }

    }



    @Override
    public int getViewID() {
        return R.layout.fragment_home;
    }
}
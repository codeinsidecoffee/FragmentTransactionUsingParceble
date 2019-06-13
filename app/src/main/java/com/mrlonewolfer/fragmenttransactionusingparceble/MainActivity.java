package com.mrlonewolfer.fragmenttransactionusingparceble;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFirstFragmentListenr {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment=new FirstFragment();
        FragmentManager frmdFragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=frmdFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFirstFragment(PersonBean personBean) {
        Bundle bundle= new Bundle();
        bundle.putParcelable("personData",personBean);
        Fragment fragment=new SecondFragment();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.addToBackStack(FirstFragment.class.getName());
        fragmentTransaction.commit();

    }
}

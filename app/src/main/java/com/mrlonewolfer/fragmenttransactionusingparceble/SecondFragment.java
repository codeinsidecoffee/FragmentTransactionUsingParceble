package com.mrlonewolfer.fragmenttransactionusingparceble;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    TextView txtmsg;


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second, container, false);
        txtmsg=view.findViewById(R.id.txtMsg);
        Bundle bundle=getArguments();
        PersonBean personBean=bundle.getParcelable("personData");
        String mymsg="\n \t First name is : "+personBean.getFname()+"\n \t Last Name is : "+personBean.getLname()
                +"\n \t Email is : "+personBean.getLname()+"\n \t Cno is : "+personBean.getCno();
        txtmsg.setText(mymsg);
        // Inflate the layout for this fragment
        return view;
    }

}

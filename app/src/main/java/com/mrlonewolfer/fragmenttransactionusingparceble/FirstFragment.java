package com.mrlonewolfer.fragmenttransactionusingparceble;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    EditText edtfname,edtlname,edtemail,edtcno;
    Button btnsend;
Context context;
    public FirstFragment() {
        // Required empty public constructor
    }
public interface OnFirstFragmentListenr{
        void onFirstFragment(PersonBean personBean);

}
OnFirstFragmentListenr listenr;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFirstFragmentListenr){
            listenr= (OnFirstFragmentListenr) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
        edtfname=view.findViewById(R.id.edtFName);
        edtlname=view.findViewById(R.id.edtLName);
        edtemail=view.findViewById(R.id.edtEmail);
        edtcno=view.findViewById(R.id.edtCno);
        btnsend=view.findViewById(R.id.btnSend);
        btnsend.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        PersonBean personBean=new PersonBean();
        personBean.setFname(edtfname.getText().toString());
        personBean.setLname(edtlname.getText().toString());
        personBean.setEmail(edtemail.getText().toString());
        personBean.setCno(Integer.parseInt(edtcno.getText().toString()));
        listenr.onFirstFragment(personBean);
//        Bundle bundle= new Bundle();
//        bundle.putParcelable("personData",personBean);
//        Fragment fragment=new SecondFragment();
//        fragment.setArguments(bundle);
//
//        FragmentManager fragmentManager=getFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,fragment);
//        fragmentTransaction.addToBackStack(FirstFragment.class.getName());
//        fragmentTransaction.commit();

    }
}

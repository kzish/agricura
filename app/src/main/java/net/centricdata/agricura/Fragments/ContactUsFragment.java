package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.centricdata.agricura.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {

    EditText name, tel, email, subject, body;
    Button send;


    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        name = view.findViewById(R.id.edtcontactName);
        tel = view.findViewById(R.id.edtcontactTel);
        email = view.findViewById(R.id.edtcontactEmail);
        subject = view.findViewById(R.id.edtcontactSubject);
        body = view.findViewById(R.id.edtcontactBody);





        return view;
    }

}

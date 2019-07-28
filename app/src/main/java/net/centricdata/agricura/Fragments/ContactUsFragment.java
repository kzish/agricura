package net.centricdata.agricura.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.centricdata.agricura.R;

import java.util.HashMap;
import java.util.Map;

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
        send = view.findViewById(R.id.btn_sendForm);

        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendContactForm();
                    }
                }
        );








        return view;
    }

    private void sendContactForm() {

        String urlPost = "https://www.centricdata.net/demo/a/contact.php";

        final String n = name.getText().toString().trim();
        final String t = tel.getText().toString().trim();
        final String e = email.getText().toString().trim();
        final String s = subject.getText().toString().trim();
        final String b = body.getText().toString().trim();


        StringRequest putRequest = new StringRequest(Request.Method.PUT, urlPost,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {

                        name.setText("");
                        tel.setText("");
                        email.setText("");
                        subject.setText("");
                        body.setText("");


                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        //Log.d("Error.Response", response);
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("name", n);
                params.put("email", e);
                params.put("body", t);
                params.put("subject", s);
                params.put("message", b);

                return params;
            }

        };

        RequestQueue queue = Volley.newRequestQueue(getContext());

        queue.add(putRequest);
    }

}

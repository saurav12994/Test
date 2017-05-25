package com.example.sourabh.bookmyticket;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class profFragment extends Fragment {
    ProgressDialog pr1;
EditText et1,et2,et3,et4;
     private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    Button bs,bb;
    
    public profFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prof, container, false);
        firebaseAuth=FirebaseAuth.getInstance();
        et1=(EditText)view.findViewById(R.id.editText);
        et2=(EditText)view.findViewById(R.id.editText3);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        et3=(EditText)view.findViewById(R.id.editText4);
        pr1 = new ProgressDialog(getActivity());
        et4=(EditText)view.findViewById(R.id.editText5);
         bs = (Button) view.findViewById(R.id.button1);
        bb = (Button) view.findViewById(R.id.button6);
        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=et1.getText().toString().trim();
               String ph=et2.getText().toString().trim();
                String add=et3.getText().toString().trim();
                String emil=et4.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ph)) {
                    Toast.makeText(getContext(), "Enter Mobile No.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(add)) {
                    Toast.makeText(getContext(), "Enter Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(emil)) {
                    Toast.makeText(getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
  pr1.setMessage("Adding user");
                pr1.show();
                Userinformation userinformation =new Userinformation(add,ph,emil,name);
                FirebaseUser user=firebaseAuth.getCurrentUser();
             final String   muserid=user.getUid();
                databaseReference.child(muserid).setValue(userinformation);
              //  pr1.setMessage("Adding user");
                pr1.dismiss();
                Toast.makeText(getActivity(),"Database saved ", Toast.LENGTH_LONG).show();
            }
         });
       bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });


       // return inflater.inflate(R.layout.fragment_prof, container, false);
   return  view;
    }


}

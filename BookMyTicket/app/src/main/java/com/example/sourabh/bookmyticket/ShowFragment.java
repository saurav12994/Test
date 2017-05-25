package com.example.sourabh.bookmyticket;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {

TextView t1,t2,t3,t4;
    Button bn;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        firebaseAuth=FirebaseAuth.getInstance();
        t1=(TextView) view.findViewById(R.id.textView11);
        t2=(TextView) view.findViewById(R.id.textView13);
        t3=(TextView) view.findViewById(R.id.textView15);
        t4=(TextView) view.findViewById(R.id.textView17);
        bn = (Button) view.findViewById(R.id.button7);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        final String   muserid=user.getUid();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        Userinformation user1 =new Userinformation();
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainActivity.class);
                startActivity(intent);
               /* Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);*/
            }
        });
//t1.setText("1");
        //Toast.makeText(getActivity(),muserid, Toast.LENGTH_LONG).show();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //Getting the data from snapshot
                    if(postSnapshot.getKey().equals(muserid)) {

                        Userinformation user1 = postSnapshot.getValue(Userinformation.class);

                        String str1 = user1.getNam();
                        String str2 = user1.getPhone();
                        String str3 = user1.getAddress();
                        String str4 = user1.getEmail();
                        t1.setText(str1);
                        t2.setText(str2);
                        t3.setText(str3);
                        t4.setText(str4);
                    }
            }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });


        return view ;
    }

}

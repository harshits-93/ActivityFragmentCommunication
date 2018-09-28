package com.example.harsh.activityfragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MesssageFragment extends Fragment {
    private EditText editText;
    private Button button;

    public OnMessageReadListener onMessageReadListener;

    public MesssageFragment() {
        // Required empty public constructor
    }

    //Creating interface here for establishing communication b/w activity & fragment
    public interface OnMessageReadListener {
        public void onMessageRead(String message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messsage, container, false);

        //Initializing references
        editText = view.findViewById(R.id.messageEditText);
        button = view.findViewById(R.id.sendButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                onMessageReadListener.onMessageRead(message);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {
            onMessageReadListener = (OnMessageReadListener) activity;
        } catch (ClassCastException e) {

            throw new ClassCastException(activity.toString() + "must override onMessageRead");
        }
    }
}

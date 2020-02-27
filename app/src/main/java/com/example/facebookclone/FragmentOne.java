package com.example.facebookclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebookclone.data.DataBase;

public class FragmentOne extends Fragment {

    EditText name,age,marks;
    DataBase db;
    Button insert;
    public static FragmentOne newInstance(){
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DataBase(getContext(),DataBase.DB_NAME,null,DataBase.DB_VERSION);

        insert = view.findViewById(R.id.insert);
        name = view.findViewById(R.id.Name);
        age = view.findViewById(R.id.Age);
        marks = view.findViewById(R.id.Marks);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertStudent(name.getText().toString(), age.getText().toString(), marks.getText().toString());
            }
        });


    }


}

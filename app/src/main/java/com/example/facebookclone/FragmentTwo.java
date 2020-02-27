package com.example.facebookclone;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebookclone.data.DataBase;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {


    AutoCompleteTextView autoCompleteTextView;
    Button search;
    ListView listView;
    DataBase db;
    public static FragmentTwo newInstance(){
        FragmentTwo fragment = new FragmentTwo();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_two,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DataBase(getContext(),DataBase.DB_NAME,null,DataBase.DB_VERSION);
        autoCompleteTextView = view.findViewById(R.id.auto);
        listView = view.findViewById(R.id.list);
        search = view.findViewById(R.id.search);

        Cursor dataList = db.getAllStudent();
        ArrayList<String> list = new ArrayList<>();
        while (dataList.moveToNext()) {
            list.add(dataList.getString(0));
        }

        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        autoCompleteTextView.setAdapter(adapter);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchName = autoCompleteTextView.getText().toString();
                Cursor dataList = db.getAllStudent();
                ArrayList<String> list = new ArrayList<>();
                while (dataList.moveToNext()) {
                    if (dataList.getString(0).equals(searchName)) {
                        list.add("Name: " + dataList.getString(0));
                        list.add("Age: " + dataList.getString(1));
                        list.add("Mark: " + dataList.getString(2));
                    }

                }
                ArrayAdapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
                listView.setAdapter(adapter);
            }
        });


    }
}

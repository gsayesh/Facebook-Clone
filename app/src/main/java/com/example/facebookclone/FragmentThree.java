package com.example.facebookclone;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.facebookclone.data.DataBase;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentThree extends Fragment {

    ListView listView;
    DataBase db;
    public static FragmentThree newInstance(){
        FragmentThree fragment = new FragmentThree();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_three,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = new DataBase(getContext(), DataBase.DB_NAME, null, DataBase.DB_VERSION);

        Cursor cursor = db.getAllStudent();
        ArrayList<String> list = new ArrayList<>();
        while(cursor.moveToNext()) {
            list.add(cursor.getString(0));
        }
        ArrayAdapter adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}

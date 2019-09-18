package ru.netology.lists;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        String[] from = {"text_1", "text_2"};
        int[] to = {R.id.text_1, R.id.text_2};
        BaseAdapter listContentAdapter = createAdapter(values, from, to);

        list.setAdapter(listContentAdapter);
    }

    private BaseAdapter createAdapter(List<Map<String, String>> values, String[] from, int[] to) {
        return new SimpleAdapter(this, values, R.layout.list, from, to);
    }

    private List<Map<String, String>> prepareContent() {
        String[] strings = getString(R.string.large_text).split("\n\n");

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("text_1", strings[i]);
            map.put("text_2",  String.valueOf(strings[i].length()));
            list.add(map);
        }

        return list;
    }
}
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

    ListView listView;
    private String[] from;
    private final String ATTRIBUTE_TITLE_TEXT = "title";
    private final String ATTRIBUTE_SUBTITLE_TEXT = "subtitle";

    int[] to = {R.id.text_1, R.id.text_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView_text_1);
        ListView list = findViewById(R.id.list);

        String[] values = prepareContent();

        ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>(values.length);
        Map<String, String> mapText;

        for (int i = 0; i < values.length; i++) {
            mapText = new HashMap<>();

            mapText.put(ATTRIBUTE_TITLE_TEXT, values[i]);
            mapText.put(ATTRIBUTE_SUBTITLE_TEXT, "" + values[i].length());
            data.add(mapText);


        }
        from = new String[]{ATTRIBUTE_TITLE_TEXT, ATTRIBUTE_SUBTITLE_TEXT};

        BaseAdapter listContentAdapter = createAdapter(data);
        listView.setAdapter(listContentAdapter);

    }


    private BaseAdapter createAdapter(List<Map<String, String>> data) {
        return new SimpleAdapter(this, data, R.layout.list,
                from, to);
    }

    private String[] prepareContent() {
        return getString(R.string.large_text).split("\n\n");
    }
}

package ru.startandroid.obhodprototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;

import org.parceler.Parcels;

import ru.startandroid.obhodprototype.Model.Path;
import ru.startandroid.obhodprototype.Model.Point;

public class PathActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);

        Path currentPath = (Path) Parcels.unwrap(getIntent().getParcelableExtra("path"));
        
        // TODO сформировать группы для отображения в листе
        //SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this,);
    }
}

package ru.startandroid.obhodprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.startandroid.obhodprototype.Adapters.PathAdapter;
import ru.startandroid.obhodprototype.Model.Item;
import ru.startandroid.obhodprototype.Model.Path;
import ru.startandroid.obhodprototype.Model.Point;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.pathsListView) ListView pathListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        // TODO: вытащить из нужного места нужные данные про обходы
        //Временные данные для тестирования
        Path fp = new Path(); fp.Id=1; fp.Name="First name"; fp.Title="First title"; fp.Place="First place";
        Path sp = new Path(); sp.Id=1; sp.Name="Second name"; sp.Title="Second title"; sp.Place="Second place";
        Path[] data = new Path[]{fp,sp};


        PathAdapter adapter = new PathAdapter(this,data);
        pathListView.setAdapter(adapter);


        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

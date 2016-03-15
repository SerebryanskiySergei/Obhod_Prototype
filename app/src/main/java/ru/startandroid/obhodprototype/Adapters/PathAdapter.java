package ru.startandroid.obhodprototype.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.parceler.Parcels;

import ru.startandroid.obhodprototype.Model.Path;
import ru.startandroid.obhodprototype.PathActivity;
import ru.startandroid.obhodprototype.R;

/**
 * Created by edu02 on 03.03.2016.
 */
public class PathAdapter extends BaseAdapter {

    Context context;
    Path[] data;


    public PathAdapter(Context context, Path[] data){
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return data[position].Id;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.path_in_list_view,null);
        TextView titleTV = (TextView) view.findViewById(R.id.pathTitle);
        titleTV.setText(data[position].Title);
        LinearLayout ll = (LinearLayout) view.findViewById(R.id.LLToInsertDetailsInfo);
        ToggleButton showInfoBtn = (ToggleButton) view.findViewById(R.id.togglePathInfoBtn);
        showInfoBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    data[position].Expanded = true;
                    notifyDataSetChanged();
                } else {
                    data[position].Expanded = false;
                    notifyDataSetChanged();
                }
            }
        });
        TextView detailsTV = (TextView) view.findViewById(R.id.pathDetails);
        if(data[position].Expanded){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Name: " + data[position].Name + "\n");
            stringBuilder.append("Title: " + data[position].Title + "\n");
            detailsTV.setText(stringBuilder.toString());
            detailsTV.setVisibility(View.VISIBLE);
        }
        else {
            detailsTV.setText("");
            detailsTV.setVisibility(View.GONE);
        }

        Button btnSelectPath = (Button) view.findViewById(R.id.pathSelect);
        btnSelectPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PathActivity.class);
                intent.putExtra("path", Parcels.wrap(data[position]) );
                context.startActivity(intent);
            }
        });

        return view;
    }
}

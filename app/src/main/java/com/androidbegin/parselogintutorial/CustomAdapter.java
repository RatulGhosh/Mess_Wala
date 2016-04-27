package com.androidbegin.parselogintutorial;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Rohit on 16-Apr-16.
 */
public class CustomAdapter extends BaseAdapter {

    String [] day,menu_break,menu_lunch,menu_dinner;
    Context context;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Menu mainActivity, String[] dayName, String[] breakfast,String[] lunch,String[] dinner) {
        // TODO Auto-generated constructor stub
        day=dayName;
        //result=prgmNameList;
        context=mainActivity;
        //imageId=prgmImages;
        menu_break=breakfast;
        menu_lunch=lunch;
        menu_dinner=dinner;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return day.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView txtDay;
        TextView txtMenuBreak;
        TextView txtMenuLunch;
        TextView txtMenuDinner;;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.menu_detail, null);
        holder.txtMenuBreak=(TextView) rowView.findViewById(R.id.breakfast);
        holder.txtMenuLunch=(TextView) rowView.findViewById(R.id.lunch);
        holder.txtMenuDinner=(TextView) rowView.findViewById(R.id.dinner);
        holder.txtDay=(TextView) rowView.findViewById(R.id.day);
        holder.txtMenuBreak.setText(Html.fromHtml(menu_break[position]));
        holder.txtMenuLunch.setText(Html.fromHtml(menu_lunch[position]));
        holder.txtMenuDinner.setText(Html.fromHtml(menu_dinner[position]));
        holder.txtDay.setText(day[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked ", Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}

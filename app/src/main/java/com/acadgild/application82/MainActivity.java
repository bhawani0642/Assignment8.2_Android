package com.acadgild.application82;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //listview object
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the listview object
        lst= (ListView)findViewById(R.id.listview);
        lst.setAdapter(new MyAdapter(this));





    }
    //Creating MyAdaper class it extend the BaseAdapter class
    class MyAdapter extends BaseAdapter{
        ArrayList<SingleRow>list;
        Context context;
        MyAdapter(Context c){
            context=c;
            list=new ArrayList<SingleRow>();
            //using getResources method to pull Name and phonenumber
           Resources res= c.getResources();
         String[] name=   res.getStringArray(R.array.Name);
          String[] phoneNumber=  res.getStringArray(R.array.PhoneNumber);
            for (int i=0;i<7;i++){
                //Creating single row object
              list.add( new SingleRow( name[i],phoneNumber[i]));
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
         //getview method it take cares of all the views
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row=   inflater.inflate(R.layout.simpleadapter,parent,false);
            TextView name= (TextView) row.findViewById(R.id.textView3);
            TextView phoneNumber= (TextView) row.findViewById(R.id.textView4);
            SingleRow tep= list.get(position);
            name.setText(tep.Name);
            phoneNumber.setText(tep.PhoneNumber);
            return row ;
        }
    }
}

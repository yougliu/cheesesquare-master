package com.support.android.designlibdemo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.support.android.designlibdemo.R;
import com.support.android.designlibdemo.entity.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by helios on 10/27/15.
 */
public class LeftMenuListAdapter extends BaseAdapter{

    private int mIconSize = 24;
    private LayoutInflater mInflater;
    private Context mContext;

    public LeftMenuListAdapter(Context context){
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    private List<MenuItem> menuItems = new ArrayList<MenuItem>(
            Arrays.asList(new MenuItem("Home", R.drawable.ic_dashboard),
                    new MenuItem("Messages",R.drawable.ic_event),
                    new MenuItem("Friends",R.drawable.ic_headset),
                    new MenuItem("Discussion",R.drawable.ic_forum),
                    new MenuItem(),
                    new MenuItem("动态"),
                    new MenuItem("我的动态",R.drawable.ic_dashboard),
                    new MenuItem("内心独白",R.drawable.ic_headset))
    );

    @Override
    public int getCount() {
        return menuItems.size()>0?menuItems.size():0;
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MenuItem item = menuItems.get(position);
        switch (item.getType()){
            case MenuItem.TYPE_NORMAL:
                if(convertView == null){
                    convertView = mInflater.inflate(R.layout.layout_left_menu_normal,parent,false);
                }
                TextView title = (TextView) convertView.findViewById(R.id.id_text_drawable);
                title.setText(item.name);
                Drawable drawable = mContext.getResources().getDrawable(item.icon);
                if(drawable != null){
                    drawable.setBounds(0,0,mIconSize,mIconSize);
                    TextViewCompat.setCompoundDrawablesRelative(title,drawable,null,null,null);
                }
                break;
            case MenuItem.TYPE_NO_ICON:
                if(convertView == null){
                    convertView = mInflater.inflate(R.layout.layout_left_menu_no_icon,parent,false);
                }
                TextView textTitle = (TextView) convertView.findViewById(R.id.id_text_no_icon);
                textTitle.setText(item.name);
                break;
            case MenuItem.TYPE_SEPARATOR:
                if(convertView == null){
                    convertView = mInflater.inflate(R.layout.layout_left_menu_separator,parent,false);
                }
                break;
        }
        return null;
    }
}

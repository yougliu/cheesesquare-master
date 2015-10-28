package com.support.android.designlibdemo.entity;

import android.text.TextUtils;

/**
 * Created by helios on 10/27/15.
 */
public class MenuItem {

    private static final int NO_ICON = 0;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_NO_ICON = 1;
    public static final int TYPE_SEPARATOR = 2;

    public int icon;
    public String name;
    public int type;

    public MenuItem(String name, int icon ){
        this.icon = icon;
        this.name = name;
        if(icon == NO_ICON && TextUtils.isEmpty(name)){
            type = TYPE_SEPARATOR;
        }else if(icon == NO_ICON){
            type = TYPE_NO_ICON;
        }else{
            type = TYPE_NORMAL;
        }

        if(icon != NO_ICON && TextUtils.isEmpty(name)){
            throw new IllegalArgumentException("error type");
        }
    }

    public MenuItem(String name){
        this(name,0);
    }

    public MenuItem(){
        this(null,0);
    }

    public int getType(){
        return type;
    }
}

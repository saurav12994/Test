package com.example.sourabh.bookmyticket;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sourabh on 21-02-2017.
 */
public class Intromanger
{
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    public Intromanger(Context context)
    {
        this.context=context;
        pref=context.getSharedPreferences("first",0);
        editor=pref.edit();
    }
    public void setFirst(Boolean isfirst)
    {
editor.putBoolean("check",isfirst);
        editor.commit();
    }
    public Boolean Check()
    {
        return pref.getBoolean("check",true);
    }
}

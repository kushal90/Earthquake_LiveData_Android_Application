package com.example.android.quakereport;

import static com.example.android.quakereport.R.id.mag;

/**
 * Created by Kushal on 11/05/2017.
 */

public class Earthquake {

    private String magnitude;
    private String location;
    private String date;
    private long mTimeInMilli;

    public Earthquake(String mag, String loc, long timeInMilli){
        magnitude = mag;
        location = loc;
        mTimeInMilli = timeInMilli;
    }


    public String getloc(){
        return location;
    }
    public long gettime(){
        return mTimeInMilli;
    }


    public String getMag() {
        return magnitude;
    }
}

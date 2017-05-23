package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;
import static com.example.android.quakereport.R.id.mag;
import static java.lang.Double.valueOf;

/**
 * Created by Kushal on 11/05/2017.
 */

public class Earthquake_Adapter_first extends ArrayAdapter<Earthquake> {


    public Earthquake_Adapter_first(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent){
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_item, parent, false);
        }

        /**
        Get items from {@Link earthquakeCustomList}
         */
        Earthquake earthquake = getItem(position);
        String loc_offset;
        String primary_loc;
        double d = Double.parseDouble(earthquake.getMag());
        DecimalFormat newFormat = new DecimalFormat("#.#");
        String twoDecimal =  Double.toString(valueOf(newFormat.format(d)));

        TextView t1 = (TextView) listItemView.findViewById(mag);
        TextView t2 = (TextView) listItemView.findViewById(R.id.loc_offset);
        TextView t3 = (TextView) listItemView.findViewById(R.id.primary_loc);
        TextView t4 = (TextView) listItemView.findViewById(R.id.date);
        TextView t5 = (TextView) listItemView.findViewById(R.id.time);
        GradientDrawable magnitudeCircle = (GradientDrawable) t1.getBackground();
        int magnitudeColor = getMagnitudeColor(d);
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        t1.setText(twoDecimal);
        String full_loc = earthquake.getloc();
        if (full_loc.contains("of"))
        {
            String[] str1 = full_loc.split(" of ");
            loc_offset = str1[0] + " of";
            primary_loc = str1[1];
        }
        else
        {
            loc_offset = "Near the ";
            primary_loc = full_loc;
        }
        t2.setText(loc_offset);
        t3.setText(primary_loc);
        long timeMilli = earthquake.gettime();
        Date dateObj = new Date(timeMilli);
        String date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(dateObj);
        String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(dateObj);
        t4.setText(date);
        t5.setText(time);


        return listItemView;
    }
    public int getMagnitudeColor(double magnitude){
        int magnitudeColor;
        int x = (int) magnitude;
        switch (x) {
            case (0):
            case (1):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case (2):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case (3):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case (4):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case (5):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case (6):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case (7):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case (8):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case (9):
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitudeColor;
    }
}

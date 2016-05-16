package io.github.httpdhruvaalam.forecast.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.httpdhruvaalam.forecast.R;
import io.github.httpdhruvaalam.forecast.weather.Day;

/**
 * Created by naqib on 5/2/2016.
 */
public class DayAdapter extends BaseAdapter {
    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days){
        mContext = context;
        mDays = days;

    }

    //gets the number of item that the adapter is using
    @Override
    public int getCount() {
        return mDays.length;
    }

    //returns the item at position in the arrays mDays
    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    //not needed
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            //brand new
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.temperatureLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];
        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax() + "");
        if (position == 0){
          holder.dayLabel.setText("Today");
        } else {
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }
        holder.dayLabel.setText(day.getDayOfTheWeek());
        return convertView;
    }

    private static class ViewHolder{
        ImageView iconImageView;
        TextView temperatureLabel;
        TextView dayLabel;
    }
}

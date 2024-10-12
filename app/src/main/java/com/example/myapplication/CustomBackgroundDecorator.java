package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

public class CustomBackgroundDecorator implements DayViewDecorator {

    private final Drawable drawable;
    private final CalendarDay date;


    public CustomBackgroundDecorator(Context context, CalendarDay date) {
        drawable = ContextCompat.getDrawable(context, R.drawable.ic_launcher_foreground);
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        // 日付が指定された日と一致する場合にデコレーションを適用する
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
    }
}

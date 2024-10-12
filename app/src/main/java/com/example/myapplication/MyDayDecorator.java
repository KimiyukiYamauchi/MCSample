package com.example.myapplication;

import android.graphics.Color;

import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;
import com.prolificinteractive.materialcalendarview.CalendarDay;

public class MyDayDecorator implements DayViewDecorator {

    private final CalendarDay date;

    public MyDayDecorator(CalendarDay date) {
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        // 日付が指定された日と一致する場合にデコレーションを適用する
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        // 背景にドットを表示する
        view.addSpan(new DotSpan(10, Color.RED));
    }
}

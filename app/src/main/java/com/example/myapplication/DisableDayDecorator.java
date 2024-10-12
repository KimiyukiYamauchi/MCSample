package com.example.myapplication;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

public class DisableDayDecorator implements DayViewDecorator {

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        // ここで特定の日付に対して無効化を適用するかどうかを決定
        return day.isBefore(CalendarDay.today());
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setDaysDisabled(true); // 日付を無効にする
    }
}

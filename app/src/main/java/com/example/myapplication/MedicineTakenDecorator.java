package com.example.myapplication;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import java.util.HashSet;

public class MedicineTakenDecorator implements DayViewDecorator {

    private HashSet<CalendarDay> medicineTakenDates;

    // 服薬済みの日付をセット
    public MedicineTakenDecorator(HashSet<CalendarDay> medicineTakenDates) {
        this.medicineTakenDates = medicineTakenDates;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        // 服用済みの日付にのみハイライトを適用
        return medicineTakenDates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {

        view.addSpan(new BackgroundColorSpan(android.graphics.Color.YELLOW));
        view.addSpan(new ForegroundColorSpan(android.graphics.Color.BLACK));

        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(1.4f));
    }
}
